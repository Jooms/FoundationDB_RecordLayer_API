package com.jooms.tickettracker.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.function.Function;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import com.apple.foundationdb.record.provider.foundationdb.FDBDatabase;
import com.apple.foundationdb.record.provider.foundationdb.FDBDatabaseFactory;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;

import com.jooms.tickettracker.CreateTicketResponse;
import com.jooms.tickettracker.DeleteAllRequest;
import com.jooms.tickettracker.DeleteAllResponse;
import com.jooms.tickettracker.GetTicketRequest;
import com.jooms.tickettracker.GetTicketResponse;
import com.jooms.tickettracker.GetTicketsRequest;
import com.jooms.tickettracker.GetTicketsResponse;
import com.jooms.tickettracker.GoodbyeMessage;
import com.jooms.tickettracker.TicketTrackerGrpc;
import com.jooms.tickettracker.TicketTracker.Ticket;
import com.jooms.tickettracker.data.TicketLayer;

public class TicketTrackerServer {
  private static final Logger logger = Logger.getLogger(TicketTrackerServer.class.getName());

  private final int port;
  private final Server server;

  public TicketTrackerServer(int port, TicketLayer ticketLayer) throws IOException {
    this.port = port;

    server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
        .addService(new TicketTrackerService(ticketLayer)).build();
  }

  public void start() throws IOException {
    server.start();
    info("Server started, listening on " + port);
    Runtime.getRuntime().addShutdownHook(new Thread() {
      @Override
      public void run() {
        warning("*** shutting down gRPC server since JVM is shutting down");
        try {
          TicketTrackerServer.this.stop();
        } catch (InterruptedException e) {
          e.printStackTrace(System.err);
        }
        warning("*** server shut down");
      }
    });
  }

  public void stop() throws InterruptedException {
    if (server != null) {
      server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
    }
  }

  public void blockUntilShutdown() throws InterruptedException {
    if (server != null) {
      server.awaitTermination();
    }
  }

  private static class TicketTrackerService extends TicketTrackerGrpc.TicketTrackerImplBase {
    private final TicketLayer ticketLayer;
    private final Function<FDBRecordContext, FDBRecordStore> rsp;

    TicketTrackerService(TicketLayer ticketLayer) {
      this.ticketLayer = ticketLayer;
      rsp = ticketLayer.getRecordStoreProvider();
    }

    @Override
    public void sayHello(com.jooms.tickettracker.HelloMessage request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GoodbyeMessage> responseObserver) {
      info("Saw:" + request);
      responseObserver.onNext(GoodbyeMessage.newBuilder().setText("Saw ya").build());
      responseObserver.onCompleted();
    }

    @Override
    public void createTicket(com.jooms.tickettracker.CreateTicketRequest request,
        StreamObserver<com.jooms.tickettracker.CreateTicketResponse> responseObserver) {
      Ticket pbt = request.getTicket();
      ticketLayer.save(this.rsp, pbt);
      responseObserver.onNext(CreateTicketResponse.getDefaultInstance());
      responseObserver.onCompleted();
    }

    @Override
    public void getTicket(GetTicketRequest request, StreamObserver<GetTicketResponse> responseObserver) {
      Ticket t;
      switch (request.getSearchParamCase()) {
        case TICKET_ID:
          int tid = request.getTicketId();
          t = ticketLayer.get(this.rsp, tid);
          break;
        default:
          warning("getTicket didn't include a recognized search param", request);
          responseObserver.onNext(null);
          responseObserver.onCompleted();
          return;
      }

      GetTicketResponse gtr = GetTicketResponse.newBuilder().setTicket(t).build();
      responseObserver.onNext(gtr);
      responseObserver.onCompleted();
    }

    @Override
    public void getTickets(GetTicketsRequest request, StreamObserver<GetTicketsResponse> responseObserver) {
      ArrayList<Ticket> tickets;

      tickets = ticketLayer.getMultiple(this.rsp);

      GetTicketsResponse.Builder gtr = GetTicketsResponse.newBuilder();
      for (Ticket t: tickets) {
        gtr.addTickets(t);
      }
      responseObserver.onNext(gtr.build());
      responseObserver.onCompleted();
    }
    
    @Override
    public void deleteAll(DeleteAllRequest request, StreamObserver<DeleteAllResponse> responseObserver) {
      ticketLayer.deleteAll(this.rsp);
      responseObserver.onNext(DeleteAllResponse.getDefaultInstance());
      responseObserver.onCompleted();

    }
  }

  private static void info(String msg, Object... params) {
    msg = "Server: " + msg;
    logger.log(Level.INFO, msg, params);
  }

  private static void warning(String msg, Object... params) {
    msg = "Server: " + msg;
    logger.log(Level.WARNING, msg, params);
  }

  public static void main(String[] args) {
        System.out.println("STARTING!!!");

        int port = 8000;

        // Create DB
        FDBDatabase db = FDBDatabaseFactory.instance().getDatabase();

        // Set up DAL
        TicketLayer tl = new TicketLayer(db, "TicketTracker");

        // Create Server with DAL
        TicketTrackerServer serv;
        try {
            serv = new TicketTrackerServer(port, tl);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Start Server
        try {
            serv.start();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Block Until Shutdown
        try {
            serv.blockUntilShutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("ENDING!!!");
    }
}
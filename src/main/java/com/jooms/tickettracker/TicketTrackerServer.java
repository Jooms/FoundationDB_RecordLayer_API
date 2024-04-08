package com.jooms.tickettracker;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.function.Function;


import com.apple.foundationdb.record.provider.foundationdb.FDBRecordContext;
import com.apple.foundationdb.record.provider.foundationdb.FDBRecordStore;
import com.jooms.tickettracker.TicketTracker.Ticket;

public class TicketTrackerServer {
  private static final Logger logger = Logger.getLogger(TicketTrackerServer.class.getName());

  private final int port;
  private final Server server;
  private final TicketLayer ticketLayer;

  public TicketTrackerServer(int port, TicketLayer ticketLayer) throws IOException {
    this.port = port;
    this.ticketLayer = ticketLayer;

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
    public void createTicket(com.jooms.tickettracker.CreateTicketRequest request, StreamObserver<com.jooms.tickettracker.CreateTicketResponse> responseObserver) {
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
          t = ticketLayer.get(rsp, tid);
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
  }

  private static void info(String msg, Object... params) {
    msg = "Server: " + msg;
    logger.log(Level.INFO, msg, params);
  }

  private static void warning(String msg, Object... params) {
    msg = "Server: " + msg;
    logger.log(Level.WARNING, msg, params);
  }
}
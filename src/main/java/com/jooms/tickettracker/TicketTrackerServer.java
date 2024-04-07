package com.jooms.tickettracker;

import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TicketTrackerServer {
    private static final Logger logger = Logger.getLogger(TicketTrackerServer.class.getName());
  
    private final int port;
    private final Server server;
  
    public TicketTrackerServer(int port) throws IOException {
      ServerBuilder<?> serverBuilder = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create());
      this.port = port;
      server = serverBuilder.addService(new TicketTrackerService())
        .build();
    }
  
    /** Start serving requests. */
    public void start() throws IOException {
      server.start();
      info("Server started, listening on " + port);
      Runtime.getRuntime().addShutdownHook(new Thread() {
        @Override
        public void run() {
          // Use stderr here since the logger may have been reset by its JVM shutdown hook.
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
  
    /** Stop serving requests and shutdown resources. */
    public void stop() throws InterruptedException {
      if (server != null) {
        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
      }
    }

    /** Block until exit. */
    public void blockUntilShutdown() throws InterruptedException {
      if (server != null) {
        server.awaitTermination();
      }
    }

    /**
     * Our implementation of RouteGuide service.
     *
     * <p>See route_guide.proto for details of the methods.
     */
    private static class TicketTrackerService extends TicketTrackerGrpc.TicketTrackerImplBase {
  
      TicketTrackerService() {}
  
      @Override
      public void sayHello(com.jooms.tickettracker.HelloMessage request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GoodbyeMessage> responseObserver) {
          info("Saw:" + request);
          responseObserver.onNext(GoodbyeMessage.newBuilder().setText("Saw ya").build());
          responseObserver.onCompleted();
      }
    }

    private static void info(String msg, Object... params) {
      msg = "Server:" + msg;
      logger.log(Level.INFO, msg, params);
    }

    private static void warning(String msg, Object... params) {
      msg = "Server:" + msg;
      logger.log(Level.WARNING, msg, params);
    }
  }
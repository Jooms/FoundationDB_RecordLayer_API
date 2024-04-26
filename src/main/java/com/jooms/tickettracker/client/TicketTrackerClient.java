package com.jooms.tickettracker.client;

import java.util.logging.Logger;
import java.util.List;
import java.util.logging.Level;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

import com.jooms.tickettracker.GoodbyeMessage;
import com.jooms.tickettracker.HelloMessage;
import com.jooms.tickettracker.TicketTracker;
import com.jooms.tickettracker.CreateTicketRequest;
import com.jooms.tickettracker.CreateTicketResponse;
import com.jooms.tickettracker.CreateTicketsRequest;
import com.jooms.tickettracker.CreateTicketsResponse;
import com.jooms.tickettracker.DeleteAllRequest;
import com.jooms.tickettracker.DeleteAllResponse;
import com.jooms.tickettracker.GetTicketRequest;
import com.jooms.tickettracker.GetTicketResponse;
import com.jooms.tickettracker.GetTicketsRequest;
import com.jooms.tickettracker.GetTicketsResponse;
import com.jooms.tickettracker.TicketTrackerGrpc;
import com.jooms.tickettracker.TicketTrackerGrpc.TicketTrackerBlockingStub;
import com.jooms.tickettracker.data.TicketLayer;

public class TicketTrackerClient {
  static final private Logger logger = Logger.getLogger(TicketTrackerClient.class.getName());

  final private boolean loggingEnabled;
  final private TicketTrackerBlockingStub blockingStub;

  public TicketTrackerClient(Channel channel) {
    this(channel, true);
  }

  public TicketTrackerClient(Channel channel, boolean loggingEnabled) {
    this.loggingEnabled = loggingEnabled;

    blockingStub = TicketTrackerGrpc.newBlockingStub(channel);
  }

  public void sayHello(String msg) {
    info("*** Saying Hello: {0}", msg);

    HelloMessage hmsg = HelloMessage.newBuilder().setText(msg).build();
    GoodbyeMessage gmsg;
    try {
      gmsg = blockingStub.sayHello(hmsg);
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      return;
    }

    info("*** Saw goodbye: {0}", gmsg);
  }

  public void createTicket(TicketTracker.Ticket t) {
    info("*** Creating ticket: {0}", t);

    CreateTicketRequest req = CreateTicketRequest.newBuilder().setTicket(t).build();
    CreateTicketResponse resp;
    try {
      resp = blockingStub.createTicket(req);
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      return;
    }

    info("*** Saw response: {0}", resp);
  }

  public void createTickets(List<TicketTracker.Ticket> ts) {
    info("*** Creating tickets: {0}", ts);

    CreateTicketsRequest req = CreateTicketsRequest.newBuilder().addAllTickets(ts).build();
    CreateTicketsResponse resp;
    try {
      resp = blockingStub.createTickets(req);
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      return;
    }

    info("*** Saw response: {0}", resp);
  }

  public TicketTracker.Ticket getTicket(int id) {
    info("*** Getting ticket: {0}", id);

    GetTicketRequest req = GetTicketRequest.newBuilder().setTicketId(id).build();
    GetTicketResponse resp;
    try {
      resp = blockingStub.getTicket(req);
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      return null;
    }

    info("*** Saw response: {0}", resp);
    return resp.getTicket();
  }

  public List<TicketTracker.Ticket> getTickets() {
    info("*** Getting tickets:");

    GetTicketsRequest req = GetTicketsRequest.newBuilder().build();
    GetTicketsResponse resp;
    try {
      resp = blockingStub.getTickets(req);
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      return null;
    }

    info("*** Saw response size: {0}", resp.getTicketsCount());
    return resp.getTicketsList();
  }

  public void deleteAll() {
    info("*** Deleting tickets:");

    DeleteAllRequest req = DeleteAllRequest.newBuilder().build();
    DeleteAllResponse resp;
    try {
      resp = blockingStub.deleteAll(req);
      info("*** Deleted tickets:");
    } catch (StatusRuntimeException e) {
      warning("RPC failed: {0}", e.getStatus());
      return;
    }

    info("*** Saw response: {0}", resp);
  }

  private void info(String msg, Object... params) {
    if (loggingEnabled) {
      msg = "CLIENT:" + msg;
      logger.log(Level.INFO, msg, params);
    }
  }

  private void warning(String msg, Object... params) {
    msg = "CLIENT:" + msg;
    logger.log(Level.WARNING, msg, params);
  }

  public static void main(String[] args) {
    System.out.println("STARTING!!!");

    int port = 8000;
    String target = "localhost:" + port;

    // Create Client
    ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
        .build();
    TicketTrackerClient cl = new TicketTrackerClient(channel);

    // Craft Ticket
    TicketTracker.Ticket t = TicketLayer.buildTicket(6, TicketLayer.ticketType.WORK, "Sixes", "cat",
        "Still no description");

    // Create Ticket
    cl.createTicket(t);

    // Get Ticket
    TicketTracker.Ticket rt = cl.getTicket(t.getId());
    System.out.println("Got ticket: " + rt);

    channel.shutdown();

    System.out.println("ENDING!!!");
  }
}
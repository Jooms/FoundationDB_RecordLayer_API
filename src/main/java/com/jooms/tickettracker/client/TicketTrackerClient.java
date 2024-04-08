package com.jooms.tickettracker.client;

import java.util.logging.Logger;
import java.util.logging.Level;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

import com.jooms.tickettracker.GoodbyeMessage;
import com.jooms.tickettracker.HelloMessage;
import com.jooms.tickettracker.TicketTracker;
import com.jooms.tickettracker.CreateTicketRequest;
import com.jooms.tickettracker.CreateTicketResponse;
import com.jooms.tickettracker.GetTicketRequest;
import com.jooms.tickettracker.GetTicketResponse;
import com.jooms.tickettracker.TicketTrackerGrpc;
import com.jooms.tickettracker.TicketTrackerGrpc.TicketTrackerBlockingStub;
import com.jooms.tickettracker.TicketTrackerGrpc.TicketTrackerStub;

public class TicketTrackerClient {
  private static final Logger logger = Logger.getLogger(TicketTrackerClient.class.getName());

  private final TicketTrackerBlockingStub blockingStub;
  private final TicketTrackerStub asyncStub;

  public TicketTrackerClient(Channel channel) {
    blockingStub = TicketTrackerGrpc.newBlockingStub(channel);
    asyncStub = TicketTrackerGrpc.newStub(channel);
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

  private void info(String msg, Object... params) {
    msg = "CLIENT:" + msg;
    logger.log(Level.INFO, msg, params);
  }

  private void warning(String msg, Object... params) {
    msg = "CLIENT:" + msg;
    logger.log(Level.WARNING, msg, params);
  }

}
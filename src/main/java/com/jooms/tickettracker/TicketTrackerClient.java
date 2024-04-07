package com.jooms.tickettracker;

import io.grpc.Channel;
import io.grpc.StatusRuntimeException;

import java.util.logging.Logger;
import java.util.logging.Level;

import com.jooms.tickettracker.TicketTrackerGrpc.TicketTrackerBlockingStub;
import com.jooms.tickettracker.TicketTrackerGrpc.TicketTrackerStub;


public class TicketTrackerClient {
    private static final Logger logger = Logger.getLogger(TicketTrackerClient.class.getName());

  private final TicketTrackerBlockingStub blockingStub;
  private final TicketTrackerStub asyncStub;

  /** Construct client for accessing RouteGuide server using the existing channel. */
  public TicketTrackerClient(Channel channel) {
    blockingStub = TicketTrackerGrpc.newBlockingStub(channel);
    asyncStub = TicketTrackerGrpc.newStub(channel);
  }

  /**
   * Blocking unary call example.  Calls getFeature and prints the response.
   */
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

  private void info(String msg, Object... params) {
    msg = "CLIENT:" + msg;
    logger.log(Level.INFO, msg, params);
  }

  private void warning(String msg, Object... params) {
    msg = "CLIENT:" + msg;
    logger.log(Level.WARNING, msg, params);
  }
  
}
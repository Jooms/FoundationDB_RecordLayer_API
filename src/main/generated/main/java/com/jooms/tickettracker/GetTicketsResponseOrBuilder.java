// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ticket_tracker_service.proto

package com.jooms.tickettracker;

public interface GetTicketsResponseOrBuilder extends
    // @@protoc_insertion_point(interface_extends:GetTicketsResponse)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  java.util.List<com.jooms.tickettracker.TicketTracker.Ticket> 
      getTicketsList();
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  com.jooms.tickettracker.TicketTracker.Ticket getTickets(int index);
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  int getTicketsCount();
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  java.util.List<? extends com.jooms.tickettracker.TicketTracker.TicketOrBuilder> 
      getTicketsOrBuilderList();
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  com.jooms.tickettracker.TicketTracker.TicketOrBuilder getTicketsOrBuilder(
      int index);
}

// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ticket_tracker_service.proto

package com.jooms.tickettracker;

public final class TicketTrackerService {
  private TicketTrackerService() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_HelloMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_HelloMessage_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_GoodbyeMessage_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_GoodbyeMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\034ticket_tracker_service.proto\"\034\n\014HelloM" +
      "essage\022\014\n\004text\030\001 \001(\t\"\036\n\016GoodbyeMessage\022\014" +
      "\n\004text\030\001 \001(\t2=\n\rTicketTracker\022,\n\010SayHell" +
      "o\022\r.HelloMessage\032\017.GoodbyeMessage\"\000B1\n\027c" +
      "om.jooms.tickettrackerB\024TicketTrackerSer" +
      "viceP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_HelloMessage_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_HelloMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_HelloMessage_descriptor,
        new java.lang.String[] { "Text", });
    internal_static_GoodbyeMessage_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_GoodbyeMessage_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_GoodbyeMessage_descriptor,
        new java.lang.String[] { "Text", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}

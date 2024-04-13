// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: ticket_tracker_service.proto

package com.jooms.tickettracker;

/**
 * Protobuf type {@code CreateTicketsRequest}
 */
public  final class CreateTicketsRequest extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:CreateTicketsRequest)
    CreateTicketsRequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use CreateTicketsRequest.newBuilder() to construct.
  private CreateTicketsRequest(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private CreateTicketsRequest() {
    tickets_ = java.util.Collections.emptyList();
  }

  @java.lang.Override
  @SuppressWarnings({"unused"})
  protected java.lang.Object newInstance(
      UnusedPrivateParameter unused) {
    return new CreateTicketsRequest();
  }

  @java.lang.Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private CreateTicketsRequest(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new java.lang.NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          case 10: {
            if (!((mutable_bitField0_ & 0x00000001) != 0)) {
              tickets_ = new java.util.ArrayList<com.jooms.tickettracker.TicketTracker.Ticket>();
              mutable_bitField0_ |= 0x00000001;
            }
            tickets_.add(
                input.readMessage(com.jooms.tickettracker.TicketTracker.Ticket.parser(), extensionRegistry));
            break;
          }
          default: {
            if (!parseUnknownField(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      if (((mutable_bitField0_ & 0x00000001) != 0)) {
        tickets_ = java.util.Collections.unmodifiableList(tickets_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return com.jooms.tickettracker.TicketTrackerService.internal_static_CreateTicketsRequest_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return com.jooms.tickettracker.TicketTrackerService.internal_static_CreateTicketsRequest_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            com.jooms.tickettracker.CreateTicketsRequest.class, com.jooms.tickettracker.CreateTicketsRequest.Builder.class);
  }

  public static final int TICKETS_FIELD_NUMBER = 1;
  private java.util.List<com.jooms.tickettracker.TicketTracker.Ticket> tickets_;
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  public java.util.List<com.jooms.tickettracker.TicketTracker.Ticket> getTicketsList() {
    return tickets_;
  }
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  public java.util.List<? extends com.jooms.tickettracker.TicketTracker.TicketOrBuilder> 
      getTicketsOrBuilderList() {
    return tickets_;
  }
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  public int getTicketsCount() {
    return tickets_.size();
  }
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  public com.jooms.tickettracker.TicketTracker.Ticket getTickets(int index) {
    return tickets_.get(index);
  }
  /**
   * <code>repeated .Ticket tickets = 1;</code>
   */
  public com.jooms.tickettracker.TicketTracker.TicketOrBuilder getTicketsOrBuilder(
      int index) {
    return tickets_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < tickets_.size(); i++) {
      output.writeMessage(1, tickets_.get(i));
    }
    unknownFields.writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < tickets_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, tickets_.get(i));
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof com.jooms.tickettracker.CreateTicketsRequest)) {
      return super.equals(obj);
    }
    com.jooms.tickettracker.CreateTicketsRequest other = (com.jooms.tickettracker.CreateTicketsRequest) obj;

    if (!getTicketsList()
        .equals(other.getTicketsList())) return false;
    if (!unknownFields.equals(other.unknownFields)) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getTicketsCount() > 0) {
      hash = (37 * hash) + TICKETS_FIELD_NUMBER;
      hash = (53 * hash) + getTicketsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static com.jooms.tickettracker.CreateTicketsRequest parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(com.jooms.tickettracker.CreateTicketsRequest prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code CreateTicketsRequest}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:CreateTicketsRequest)
      com.jooms.tickettracker.CreateTicketsRequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return com.jooms.tickettracker.TicketTrackerService.internal_static_CreateTicketsRequest_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return com.jooms.tickettracker.TicketTrackerService.internal_static_CreateTicketsRequest_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              com.jooms.tickettracker.CreateTicketsRequest.class, com.jooms.tickettracker.CreateTicketsRequest.Builder.class);
    }

    // Construct using com.jooms.tickettracker.CreateTicketsRequest.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
        getTicketsFieldBuilder();
      }
    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      if (ticketsBuilder_ == null) {
        tickets_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
      } else {
        ticketsBuilder_.clear();
      }
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return com.jooms.tickettracker.TicketTrackerService.internal_static_CreateTicketsRequest_descriptor;
    }

    @java.lang.Override
    public com.jooms.tickettracker.CreateTicketsRequest getDefaultInstanceForType() {
      return com.jooms.tickettracker.CreateTicketsRequest.getDefaultInstance();
    }

    @java.lang.Override
    public com.jooms.tickettracker.CreateTicketsRequest build() {
      com.jooms.tickettracker.CreateTicketsRequest result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public com.jooms.tickettracker.CreateTicketsRequest buildPartial() {
      com.jooms.tickettracker.CreateTicketsRequest result = new com.jooms.tickettracker.CreateTicketsRequest(this);
      int from_bitField0_ = bitField0_;
      if (ticketsBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          tickets_ = java.util.Collections.unmodifiableList(tickets_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.tickets_ = tickets_;
      } else {
        result.tickets_ = ticketsBuilder_.build();
      }
      onBuilt();
      return result;
    }

    @java.lang.Override
    public Builder clone() {
      return super.clone();
    }
    @java.lang.Override
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.setField(field, value);
    }
    @java.lang.Override
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return super.clearField(field);
    }
    @java.lang.Override
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return super.clearOneof(oneof);
    }
    @java.lang.Override
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, java.lang.Object value) {
      return super.setRepeatedField(field, index, value);
    }
    @java.lang.Override
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        java.lang.Object value) {
      return super.addRepeatedField(field, value);
    }
    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof com.jooms.tickettracker.CreateTicketsRequest) {
        return mergeFrom((com.jooms.tickettracker.CreateTicketsRequest)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(com.jooms.tickettracker.CreateTicketsRequest other) {
      if (other == com.jooms.tickettracker.CreateTicketsRequest.getDefaultInstance()) return this;
      if (ticketsBuilder_ == null) {
        if (!other.tickets_.isEmpty()) {
          if (tickets_.isEmpty()) {
            tickets_ = other.tickets_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureTicketsIsMutable();
            tickets_.addAll(other.tickets_);
          }
          onChanged();
        }
      } else {
        if (!other.tickets_.isEmpty()) {
          if (ticketsBuilder_.isEmpty()) {
            ticketsBuilder_.dispose();
            ticketsBuilder_ = null;
            tickets_ = other.tickets_;
            bitField0_ = (bitField0_ & ~0x00000001);
            ticketsBuilder_ = 
              com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                 getTicketsFieldBuilder() : null;
          } else {
            ticketsBuilder_.addAllMessages(other.tickets_);
          }
        }
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      com.jooms.tickettracker.CreateTicketsRequest parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (com.jooms.tickettracker.CreateTicketsRequest) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private java.util.List<com.jooms.tickettracker.TicketTracker.Ticket> tickets_ =
      java.util.Collections.emptyList();
    private void ensureTicketsIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        tickets_ = new java.util.ArrayList<com.jooms.tickettracker.TicketTracker.Ticket>(tickets_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.jooms.tickettracker.TicketTracker.Ticket, com.jooms.tickettracker.TicketTracker.Ticket.Builder, com.jooms.tickettracker.TicketTracker.TicketOrBuilder> ticketsBuilder_;

    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public java.util.List<com.jooms.tickettracker.TicketTracker.Ticket> getTicketsList() {
      if (ticketsBuilder_ == null) {
        return java.util.Collections.unmodifiableList(tickets_);
      } else {
        return ticketsBuilder_.getMessageList();
      }
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public int getTicketsCount() {
      if (ticketsBuilder_ == null) {
        return tickets_.size();
      } else {
        return ticketsBuilder_.getCount();
      }
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public com.jooms.tickettracker.TicketTracker.Ticket getTickets(int index) {
      if (ticketsBuilder_ == null) {
        return tickets_.get(index);
      } else {
        return ticketsBuilder_.getMessage(index);
      }
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder setTickets(
        int index, com.jooms.tickettracker.TicketTracker.Ticket value) {
      if (ticketsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTicketsIsMutable();
        tickets_.set(index, value);
        onChanged();
      } else {
        ticketsBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder setTickets(
        int index, com.jooms.tickettracker.TicketTracker.Ticket.Builder builderForValue) {
      if (ticketsBuilder_ == null) {
        ensureTicketsIsMutable();
        tickets_.set(index, builderForValue.build());
        onChanged();
      } else {
        ticketsBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder addTickets(com.jooms.tickettracker.TicketTracker.Ticket value) {
      if (ticketsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTicketsIsMutable();
        tickets_.add(value);
        onChanged();
      } else {
        ticketsBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder addTickets(
        int index, com.jooms.tickettracker.TicketTracker.Ticket value) {
      if (ticketsBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureTicketsIsMutable();
        tickets_.add(index, value);
        onChanged();
      } else {
        ticketsBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder addTickets(
        com.jooms.tickettracker.TicketTracker.Ticket.Builder builderForValue) {
      if (ticketsBuilder_ == null) {
        ensureTicketsIsMutable();
        tickets_.add(builderForValue.build());
        onChanged();
      } else {
        ticketsBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder addTickets(
        int index, com.jooms.tickettracker.TicketTracker.Ticket.Builder builderForValue) {
      if (ticketsBuilder_ == null) {
        ensureTicketsIsMutable();
        tickets_.add(index, builderForValue.build());
        onChanged();
      } else {
        ticketsBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder addAllTickets(
        java.lang.Iterable<? extends com.jooms.tickettracker.TicketTracker.Ticket> values) {
      if (ticketsBuilder_ == null) {
        ensureTicketsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, tickets_);
        onChanged();
      } else {
        ticketsBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder clearTickets() {
      if (ticketsBuilder_ == null) {
        tickets_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        ticketsBuilder_.clear();
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public Builder removeTickets(int index) {
      if (ticketsBuilder_ == null) {
        ensureTicketsIsMutable();
        tickets_.remove(index);
        onChanged();
      } else {
        ticketsBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public com.jooms.tickettracker.TicketTracker.Ticket.Builder getTicketsBuilder(
        int index) {
      return getTicketsFieldBuilder().getBuilder(index);
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public com.jooms.tickettracker.TicketTracker.TicketOrBuilder getTicketsOrBuilder(
        int index) {
      if (ticketsBuilder_ == null) {
        return tickets_.get(index);  } else {
        return ticketsBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public java.util.List<? extends com.jooms.tickettracker.TicketTracker.TicketOrBuilder> 
         getTicketsOrBuilderList() {
      if (ticketsBuilder_ != null) {
        return ticketsBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(tickets_);
      }
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public com.jooms.tickettracker.TicketTracker.Ticket.Builder addTicketsBuilder() {
      return getTicketsFieldBuilder().addBuilder(
          com.jooms.tickettracker.TicketTracker.Ticket.getDefaultInstance());
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public com.jooms.tickettracker.TicketTracker.Ticket.Builder addTicketsBuilder(
        int index) {
      return getTicketsFieldBuilder().addBuilder(
          index, com.jooms.tickettracker.TicketTracker.Ticket.getDefaultInstance());
    }
    /**
     * <code>repeated .Ticket tickets = 1;</code>
     */
    public java.util.List<com.jooms.tickettracker.TicketTracker.Ticket.Builder> 
         getTicketsBuilderList() {
      return getTicketsFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilderV3<
        com.jooms.tickettracker.TicketTracker.Ticket, com.jooms.tickettracker.TicketTracker.Ticket.Builder, com.jooms.tickettracker.TicketTracker.TicketOrBuilder> 
        getTicketsFieldBuilder() {
      if (ticketsBuilder_ == null) {
        ticketsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
            com.jooms.tickettracker.TicketTracker.Ticket, com.jooms.tickettracker.TicketTracker.Ticket.Builder, com.jooms.tickettracker.TicketTracker.TicketOrBuilder>(
                tickets_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        tickets_ = null;
      }
      return ticketsBuilder_;
    }
    @java.lang.Override
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFields(unknownFields);
    }

    @java.lang.Override
    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:CreateTicketsRequest)
  }

  // @@protoc_insertion_point(class_scope:CreateTicketsRequest)
  private static final com.jooms.tickettracker.CreateTicketsRequest DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new com.jooms.tickettracker.CreateTicketsRequest();
  }

  public static com.jooms.tickettracker.CreateTicketsRequest getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<CreateTicketsRequest>
      PARSER = new com.google.protobuf.AbstractParser<CreateTicketsRequest>() {
    @java.lang.Override
    public CreateTicketsRequest parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new CreateTicketsRequest(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<CreateTicketsRequest> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<CreateTicketsRequest> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public com.jooms.tickettracker.CreateTicketsRequest getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}


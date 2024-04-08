package com.jooms.tickettracker;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: ticket_tracker_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TicketTrackerGrpc {

  private TicketTrackerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "TicketTracker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.jooms.tickettracker.HelloMessage,
      com.jooms.tickettracker.GoodbyeMessage> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = com.jooms.tickettracker.HelloMessage.class,
      responseType = com.jooms.tickettracker.GoodbyeMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jooms.tickettracker.HelloMessage,
      com.jooms.tickettracker.GoodbyeMessage> getSayHelloMethod() {
    io.grpc.MethodDescriptor<com.jooms.tickettracker.HelloMessage, com.jooms.tickettracker.GoodbyeMessage> getSayHelloMethod;
    if ((getSayHelloMethod = TicketTrackerGrpc.getSayHelloMethod) == null) {
      synchronized (TicketTrackerGrpc.class) {
        if ((getSayHelloMethod = TicketTrackerGrpc.getSayHelloMethod) == null) {
          TicketTrackerGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<com.jooms.tickettracker.HelloMessage, com.jooms.tickettracker.GoodbyeMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.HelloMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.GoodbyeMessage.getDefaultInstance()))
              .setSchemaDescriptor(new TicketTrackerMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jooms.tickettracker.CreateTicketRequest,
      com.jooms.tickettracker.CreateTicketResponse> getCreateTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateTicket",
      requestType = com.jooms.tickettracker.CreateTicketRequest.class,
      responseType = com.jooms.tickettracker.CreateTicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jooms.tickettracker.CreateTicketRequest,
      com.jooms.tickettracker.CreateTicketResponse> getCreateTicketMethod() {
    io.grpc.MethodDescriptor<com.jooms.tickettracker.CreateTicketRequest, com.jooms.tickettracker.CreateTicketResponse> getCreateTicketMethod;
    if ((getCreateTicketMethod = TicketTrackerGrpc.getCreateTicketMethod) == null) {
      synchronized (TicketTrackerGrpc.class) {
        if ((getCreateTicketMethod = TicketTrackerGrpc.getCreateTicketMethod) == null) {
          TicketTrackerGrpc.getCreateTicketMethod = getCreateTicketMethod =
              io.grpc.MethodDescriptor.<com.jooms.tickettracker.CreateTicketRequest, com.jooms.tickettracker.CreateTicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.CreateTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.CreateTicketResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TicketTrackerMethodDescriptorSupplier("CreateTicket"))
              .build();
        }
      }
    }
    return getCreateTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jooms.tickettracker.GetTicketRequest,
      com.jooms.tickettracker.GetTicketResponse> getGetTicketMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTicket",
      requestType = com.jooms.tickettracker.GetTicketRequest.class,
      responseType = com.jooms.tickettracker.GetTicketResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jooms.tickettracker.GetTicketRequest,
      com.jooms.tickettracker.GetTicketResponse> getGetTicketMethod() {
    io.grpc.MethodDescriptor<com.jooms.tickettracker.GetTicketRequest, com.jooms.tickettracker.GetTicketResponse> getGetTicketMethod;
    if ((getGetTicketMethod = TicketTrackerGrpc.getGetTicketMethod) == null) {
      synchronized (TicketTrackerGrpc.class) {
        if ((getGetTicketMethod = TicketTrackerGrpc.getGetTicketMethod) == null) {
          TicketTrackerGrpc.getGetTicketMethod = getGetTicketMethod =
              io.grpc.MethodDescriptor.<com.jooms.tickettracker.GetTicketRequest, com.jooms.tickettracker.GetTicketResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTicket"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.GetTicketRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.GetTicketResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TicketTrackerMethodDescriptorSupplier("GetTicket"))
              .build();
        }
      }
    }
    return getGetTicketMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.jooms.tickettracker.GetTicketsRequest,
      com.jooms.tickettracker.GetTicketsResponse> getGetTicketsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetTickets",
      requestType = com.jooms.tickettracker.GetTicketsRequest.class,
      responseType = com.jooms.tickettracker.GetTicketsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.jooms.tickettracker.GetTicketsRequest,
      com.jooms.tickettracker.GetTicketsResponse> getGetTicketsMethod() {
    io.grpc.MethodDescriptor<com.jooms.tickettracker.GetTicketsRequest, com.jooms.tickettracker.GetTicketsResponse> getGetTicketsMethod;
    if ((getGetTicketsMethod = TicketTrackerGrpc.getGetTicketsMethod) == null) {
      synchronized (TicketTrackerGrpc.class) {
        if ((getGetTicketsMethod = TicketTrackerGrpc.getGetTicketsMethod) == null) {
          TicketTrackerGrpc.getGetTicketsMethod = getGetTicketsMethod =
              io.grpc.MethodDescriptor.<com.jooms.tickettracker.GetTicketsRequest, com.jooms.tickettracker.GetTicketsResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetTickets"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.GetTicketsRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.jooms.tickettracker.GetTicketsResponse.getDefaultInstance()))
              .setSchemaDescriptor(new TicketTrackerMethodDescriptorSupplier("GetTickets"))
              .build();
        }
      }
    }
    return getGetTicketsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static TicketTrackerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TicketTrackerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TicketTrackerStub>() {
        @java.lang.Override
        public TicketTrackerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TicketTrackerStub(channel, callOptions);
        }
      };
    return TicketTrackerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static TicketTrackerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TicketTrackerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TicketTrackerBlockingStub>() {
        @java.lang.Override
        public TicketTrackerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TicketTrackerBlockingStub(channel, callOptions);
        }
      };
    return TicketTrackerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static TicketTrackerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<TicketTrackerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<TicketTrackerFutureStub>() {
        @java.lang.Override
        public TicketTrackerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new TicketTrackerFutureStub(channel, callOptions);
        }
      };
    return TicketTrackerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sayHello(com.jooms.tickettracker.HelloMessage request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GoodbyeMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    default void createTicket(com.jooms.tickettracker.CreateTicketRequest request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.CreateTicketResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateTicketMethod(), responseObserver);
    }

    /**
     */
    default void getTicket(com.jooms.tickettracker.GetTicketRequest request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GetTicketResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTicketMethod(), responseObserver);
    }

    /**
     */
    default void getTickets(com.jooms.tickettracker.GetTicketsRequest request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GetTicketsResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetTicketsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TicketTracker.
   */
  public static abstract class TicketTrackerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TicketTrackerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TicketTracker.
   */
  public static final class TicketTrackerStub
      extends io.grpc.stub.AbstractAsyncStub<TicketTrackerStub> {
    private TicketTrackerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketTrackerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TicketTrackerStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(com.jooms.tickettracker.HelloMessage request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GoodbyeMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void createTicket(com.jooms.tickettracker.CreateTicketRequest request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.CreateTicketResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTicket(com.jooms.tickettracker.GetTicketRequest request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GetTicketResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTicketMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getTickets(com.jooms.tickettracker.GetTicketsRequest request,
        io.grpc.stub.StreamObserver<com.jooms.tickettracker.GetTicketsResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetTicketsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TicketTracker.
   */
  public static final class TicketTrackerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<TicketTrackerBlockingStub> {
    private TicketTrackerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketTrackerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TicketTrackerBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.jooms.tickettracker.GoodbyeMessage sayHello(com.jooms.tickettracker.HelloMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jooms.tickettracker.CreateTicketResponse createTicket(com.jooms.tickettracker.CreateTicketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jooms.tickettracker.GetTicketResponse getTicket(com.jooms.tickettracker.GetTicketRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTicketMethod(), getCallOptions(), request);
    }

    /**
     */
    public com.jooms.tickettracker.GetTicketsResponse getTickets(com.jooms.tickettracker.GetTicketsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetTicketsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TicketTracker.
   */
  public static final class TicketTrackerFutureStub
      extends io.grpc.stub.AbstractFutureStub<TicketTrackerFutureStub> {
    private TicketTrackerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected TicketTrackerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new TicketTrackerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jooms.tickettracker.GoodbyeMessage> sayHello(
        com.jooms.tickettracker.HelloMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jooms.tickettracker.CreateTicketResponse> createTicket(
        com.jooms.tickettracker.CreateTicketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jooms.tickettracker.GetTicketResponse> getTicket(
        com.jooms.tickettracker.GetTicketRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTicketMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.jooms.tickettracker.GetTicketsResponse> getTickets(
        com.jooms.tickettracker.GetTicketsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetTicketsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_CREATE_TICKET = 1;
  private static final int METHODID_GET_TICKET = 2;
  private static final int METHODID_GET_TICKETS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((com.jooms.tickettracker.HelloMessage) request,
              (io.grpc.stub.StreamObserver<com.jooms.tickettracker.GoodbyeMessage>) responseObserver);
          break;
        case METHODID_CREATE_TICKET:
          serviceImpl.createTicket((com.jooms.tickettracker.CreateTicketRequest) request,
              (io.grpc.stub.StreamObserver<com.jooms.tickettracker.CreateTicketResponse>) responseObserver);
          break;
        case METHODID_GET_TICKET:
          serviceImpl.getTicket((com.jooms.tickettracker.GetTicketRequest) request,
              (io.grpc.stub.StreamObserver<com.jooms.tickettracker.GetTicketResponse>) responseObserver);
          break;
        case METHODID_GET_TICKETS:
          serviceImpl.getTickets((com.jooms.tickettracker.GetTicketsRequest) request,
              (io.grpc.stub.StreamObserver<com.jooms.tickettracker.GetTicketsResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSayHelloMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.jooms.tickettracker.HelloMessage,
              com.jooms.tickettracker.GoodbyeMessage>(
                service, METHODID_SAY_HELLO)))
        .addMethod(
          getCreateTicketMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.jooms.tickettracker.CreateTicketRequest,
              com.jooms.tickettracker.CreateTicketResponse>(
                service, METHODID_CREATE_TICKET)))
        .addMethod(
          getGetTicketMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.jooms.tickettracker.GetTicketRequest,
              com.jooms.tickettracker.GetTicketResponse>(
                service, METHODID_GET_TICKET)))
        .addMethod(
          getGetTicketsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.jooms.tickettracker.GetTicketsRequest,
              com.jooms.tickettracker.GetTicketsResponse>(
                service, METHODID_GET_TICKETS)))
        .build();
  }

  private static abstract class TicketTrackerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TicketTrackerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.jooms.tickettracker.TicketTrackerService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("TicketTracker");
    }
  }

  private static final class TicketTrackerFileDescriptorSupplier
      extends TicketTrackerBaseDescriptorSupplier {
    TicketTrackerFileDescriptorSupplier() {}
  }

  private static final class TicketTrackerMethodDescriptorSupplier
      extends TicketTrackerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    TicketTrackerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (TicketTrackerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new TicketTrackerFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getCreateTicketMethod())
              .addMethod(getGetTicketMethod())
              .addMethod(getGetTicketsMethod())
              .build();
        }
      }
    }
    return result;
  }
}

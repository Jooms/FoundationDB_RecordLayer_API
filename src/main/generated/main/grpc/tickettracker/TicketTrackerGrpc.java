package tickettracker;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Interface exported by the server.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.62.2)",
    comments = "Source: ticket_tracker_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class TicketTrackerGrpc {

  private TicketTrackerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "tickettracker.TicketTracker";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<tickettracker.HelloMessage,
      tickettracker.GoodbyeMessage> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = tickettracker.HelloMessage.class,
      responseType = tickettracker.GoodbyeMessage.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<tickettracker.HelloMessage,
      tickettracker.GoodbyeMessage> getSayHelloMethod() {
    io.grpc.MethodDescriptor<tickettracker.HelloMessage, tickettracker.GoodbyeMessage> getSayHelloMethod;
    if ((getSayHelloMethod = TicketTrackerGrpc.getSayHelloMethod) == null) {
      synchronized (TicketTrackerGrpc.class) {
        if ((getSayHelloMethod = TicketTrackerGrpc.getSayHelloMethod) == null) {
          TicketTrackerGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<tickettracker.HelloMessage, tickettracker.GoodbyeMessage>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tickettracker.HelloMessage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  tickettracker.GoodbyeMessage.getDefaultInstance()))
              .setSchemaDescriptor(new TicketTrackerMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
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
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public interface AsyncService {

    /**
     */
    default void sayHello(tickettracker.HelloMessage request,
        io.grpc.stub.StreamObserver<tickettracker.GoodbyeMessage> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service TicketTracker.
   * <pre>
   * Interface exported by the server.
   * </pre>
   */
  public static abstract class TicketTrackerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return TicketTrackerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service TicketTracker.
   * <pre>
   * Interface exported by the server.
   * </pre>
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
    public void sayHello(tickettracker.HelloMessage request,
        io.grpc.stub.StreamObserver<tickettracker.GoodbyeMessage> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service TicketTracker.
   * <pre>
   * Interface exported by the server.
   * </pre>
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
    public tickettracker.GoodbyeMessage sayHello(tickettracker.HelloMessage request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service TicketTracker.
   * <pre>
   * Interface exported by the server.
   * </pre>
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
    public com.google.common.util.concurrent.ListenableFuture<tickettracker.GoodbyeMessage> sayHello(
        tickettracker.HelloMessage request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;

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
          serviceImpl.sayHello((tickettracker.HelloMessage) request,
              (io.grpc.stub.StreamObserver<tickettracker.GoodbyeMessage>) responseObserver);
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
              tickettracker.HelloMessage,
              tickettracker.GoodbyeMessage>(
                service, METHODID_SAY_HELLO)))
        .build();
  }

  private static abstract class TicketTrackerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    TicketTrackerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return tickettracker.TicketTrackerService.getDescriptor();
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
              .build();
        }
      }
    }
    return result;
  }
}

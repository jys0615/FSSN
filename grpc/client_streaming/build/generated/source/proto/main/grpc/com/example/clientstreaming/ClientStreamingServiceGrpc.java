package com.example.clientstreaming;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: client_streaming.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ClientStreamingServiceGrpc {

  private ClientStreamingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "clientstream.ClientStreamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.clientstreaming.NumberRequest,
      com.example.clientstreaming.SummaryResponse> getSendNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendNumbers",
      requestType = com.example.clientstreaming.NumberRequest.class,
      responseType = com.example.clientstreaming.SummaryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.clientstreaming.NumberRequest,
      com.example.clientstreaming.SummaryResponse> getSendNumbersMethod() {
    io.grpc.MethodDescriptor<com.example.clientstreaming.NumberRequest, com.example.clientstreaming.SummaryResponse> getSendNumbersMethod;
    if ((getSendNumbersMethod = ClientStreamingServiceGrpc.getSendNumbersMethod) == null) {
      synchronized (ClientStreamingServiceGrpc.class) {
        if ((getSendNumbersMethod = ClientStreamingServiceGrpc.getSendNumbersMethod) == null) {
          ClientStreamingServiceGrpc.getSendNumbersMethod = getSendNumbersMethod =
              io.grpc.MethodDescriptor.<com.example.clientstreaming.NumberRequest, com.example.clientstreaming.SummaryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.clientstreaming.NumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.clientstreaming.SummaryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ClientStreamingServiceMethodDescriptorSupplier("SendNumbers"))
              .build();
        }
      }
    }
    return getSendNumbersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ClientStreamingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientStreamingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientStreamingServiceStub>() {
        @java.lang.Override
        public ClientStreamingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientStreamingServiceStub(channel, callOptions);
        }
      };
    return ClientStreamingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ClientStreamingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientStreamingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientStreamingServiceBlockingStub>() {
        @java.lang.Override
        public ClientStreamingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientStreamingServiceBlockingStub(channel, callOptions);
        }
      };
    return ClientStreamingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ClientStreamingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ClientStreamingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ClientStreamingServiceFutureStub>() {
        @java.lang.Override
        public ClientStreamingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ClientStreamingServiceFutureStub(channel, callOptions);
        }
      };
    return ClientStreamingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default io.grpc.stub.StreamObserver<com.example.clientstreaming.NumberRequest> sendNumbers(
        io.grpc.stub.StreamObserver<com.example.clientstreaming.SummaryResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getSendNumbersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ClientStreamingService.
   */
  public static abstract class ClientStreamingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ClientStreamingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ClientStreamingService.
   */
  public static final class ClientStreamingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ClientStreamingServiceStub> {
    private ClientStreamingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientStreamingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientStreamingServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.clientstreaming.NumberRequest> sendNumbers(
        io.grpc.stub.StreamObserver<com.example.clientstreaming.SummaryResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getSendNumbersMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ClientStreamingService.
   */
  public static final class ClientStreamingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ClientStreamingServiceBlockingStub> {
    private ClientStreamingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientStreamingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientStreamingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ClientStreamingService.
   */
  public static final class ClientStreamingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ClientStreamingServiceFutureStub> {
    private ClientStreamingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ClientStreamingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ClientStreamingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SEND_NUMBERS = 0;

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
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SEND_NUMBERS:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.sendNumbers(
              (io.grpc.stub.StreamObserver<com.example.clientstreaming.SummaryResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSendNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              com.example.clientstreaming.NumberRequest,
              com.example.clientstreaming.SummaryResponse>(
                service, METHODID_SEND_NUMBERS)))
        .build();
  }

  private static abstract class ClientStreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ClientStreamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.clientstreaming.ClientStreamingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ClientStreamingService");
    }
  }

  private static final class ClientStreamingServiceFileDescriptorSupplier
      extends ClientStreamingServiceBaseDescriptorSupplier {
    ClientStreamingServiceFileDescriptorSupplier() {}
  }

  private static final class ClientStreamingServiceMethodDescriptorSupplier
      extends ClientStreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ClientStreamingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ClientStreamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ClientStreamingServiceFileDescriptorSupplier())
              .addMethod(getSendNumbersMethod())
              .build();
        }
      }
    }
    return result;
  }
}

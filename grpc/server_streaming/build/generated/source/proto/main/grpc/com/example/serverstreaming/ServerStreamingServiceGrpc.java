package com.example.serverstreaming;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: server_streaming.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServerStreamingServiceGrpc {

  private ServerStreamingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "serverstream.ServerStreamingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.serverstreaming.NumberRequest,
      com.example.serverstreaming.NumberResponse> getStreamNumbersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamNumbers",
      requestType = com.example.serverstreaming.NumberRequest.class,
      responseType = com.example.serverstreaming.NumberResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.serverstreaming.NumberRequest,
      com.example.serverstreaming.NumberResponse> getStreamNumbersMethod() {
    io.grpc.MethodDescriptor<com.example.serverstreaming.NumberRequest, com.example.serverstreaming.NumberResponse> getStreamNumbersMethod;
    if ((getStreamNumbersMethod = ServerStreamingServiceGrpc.getStreamNumbersMethod) == null) {
      synchronized (ServerStreamingServiceGrpc.class) {
        if ((getStreamNumbersMethod = ServerStreamingServiceGrpc.getStreamNumbersMethod) == null) {
          ServerStreamingServiceGrpc.getStreamNumbersMethod = getStreamNumbersMethod =
              io.grpc.MethodDescriptor.<com.example.serverstreaming.NumberRequest, com.example.serverstreaming.NumberResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamNumbers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.serverstreaming.NumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.example.serverstreaming.NumberResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ServerStreamingServiceMethodDescriptorSupplier("StreamNumbers"))
              .build();
        }
      }
    }
    return getStreamNumbersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServerStreamingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerStreamingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerStreamingServiceStub>() {
        @java.lang.Override
        public ServerStreamingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerStreamingServiceStub(channel, callOptions);
        }
      };
    return ServerStreamingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServerStreamingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerStreamingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerStreamingServiceBlockingStub>() {
        @java.lang.Override
        public ServerStreamingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerStreamingServiceBlockingStub(channel, callOptions);
        }
      };
    return ServerStreamingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServerStreamingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServerStreamingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServerStreamingServiceFutureStub>() {
        @java.lang.Override
        public ServerStreamingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServerStreamingServiceFutureStub(channel, callOptions);
        }
      };
    return ServerStreamingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void streamNumbers(com.example.serverstreaming.NumberRequest request,
        io.grpc.stub.StreamObserver<com.example.serverstreaming.NumberResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamNumbersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ServerStreamingService.
   */
  public static abstract class ServerStreamingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ServerStreamingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ServerStreamingService.
   */
  public static final class ServerStreamingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ServerStreamingServiceStub> {
    private ServerStreamingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerStreamingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerStreamingServiceStub(channel, callOptions);
    }

    /**
     */
    public void streamNumbers(com.example.serverstreaming.NumberRequest request,
        io.grpc.stub.StreamObserver<com.example.serverstreaming.NumberResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamNumbersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ServerStreamingService.
   */
  public static final class ServerStreamingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServerStreamingServiceBlockingStub> {
    private ServerStreamingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerStreamingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerStreamingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<com.example.serverstreaming.NumberResponse> streamNumbers(
        com.example.serverstreaming.NumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamNumbersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ServerStreamingService.
   */
  public static final class ServerStreamingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServerStreamingServiceFutureStub> {
    private ServerStreamingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServerStreamingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServerStreamingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_STREAM_NUMBERS = 0;

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
        case METHODID_STREAM_NUMBERS:
          serviceImpl.streamNumbers((com.example.serverstreaming.NumberRequest) request,
              (io.grpc.stub.StreamObserver<com.example.serverstreaming.NumberResponse>) responseObserver);
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
          getStreamNumbersMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.example.serverstreaming.NumberRequest,
              com.example.serverstreaming.NumberResponse>(
                service, METHODID_STREAM_NUMBERS)))
        .build();
  }

  private static abstract class ServerStreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServerStreamingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.serverstreaming.ServerStreamingProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServerStreamingService");
    }
  }

  private static final class ServerStreamingServiceFileDescriptorSupplier
      extends ServerStreamingServiceBaseDescriptorSupplier {
    ServerStreamingServiceFileDescriptorSupplier() {}
  }

  private static final class ServerStreamingServiceMethodDescriptorSupplier
      extends ServerStreamingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ServerStreamingServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ServerStreamingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServerStreamingServiceFileDescriptorSupplier())
              .addMethod(getStreamNumbersMethod())
              .build();
        }
      }
    }
    return result;
  }
}

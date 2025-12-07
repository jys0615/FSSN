package com.example.clientstreaming;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class server {

    static class ClientStreamingServiceImpl extends ClientStreamingGrpc.ClientStreamingImplBase {

        @Override
        public StreamObserver<Message> getServerResponse(StreamObserver<Number> responseObserver) {

            return new StreamObserver<Message>() {

                int count = 0;

                @Override
                public void onNext(Message request) {
                    // Python처럼 메시지 수신 시 로그 없음
                    count++;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("[Server] Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {

                    System.out.println("Server processing gRPC client-streaming.");

                    Number response = Number.newBuilder()
                            .setValue(count)
                            .build();

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new ClientStreamingServiceImpl())
                .build()
                .start();


        System.out.println("Starting server. Listening on port 50051.");

        server.awaitTermination();
    }
}
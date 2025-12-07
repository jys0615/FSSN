package com.example.serverstreaming;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class server {

    static class ServerStreamingServiceImpl extends ServerStreamingGrpc.ServerStreamingImplBase {

        @Override
        public void getServerResponse(Number request, StreamObserver<Message> responseObserver) {


            System.out.println("Server processing gRPC server-streaming.");

            // Python과 동일하게 5개의 메시지 전송
            String[] messages = {
                    "message #1",
                    "message #2",
                    "message #3",
                    "message #4",
                    "message #5"
            };

            for (String msg : messages) {
                Message message = Message.newBuilder()
                        .setMessage(msg)
                        .build();

                responseObserver.onNext(message);
            }

            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new ServerStreamingServiceImpl())
                .build()
                .start();


        System.out.println("Starting server. Listening on port 50051.");

        server.awaitTermination();
    }
}
package com.example.bidirectional;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class server {

    static class BidirectionalServiceImpl extends BidirectionalGrpc.BidirectionalImplBase {

        @Override
        public StreamObserver<Message> getServerResponse(StreamObserver<Message> responseObserver) {

            return new StreamObserver<Message>() {

                @Override
                public void onNext(Message request) {
                    // Python처럼 받은 즉시 에코 (yield message)
                    responseObserver.onNext(request);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Server error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {

                    System.out.println("Server processing gRPC bidirectional streaming.");
                    responseObserver.onCompleted();
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new BidirectionalServiceImpl())
                .build()
                .start();


        System.out.println("Starting server. Listening on port 50051.");

        server.awaitTermination();
    }
}
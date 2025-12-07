package com.example.bidirectional;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import java.util.ArrayList;

public class BidirectionalServer {

    static class BidirectionalServiceImpl
            extends BidirectionalServiceGrpc.BidirectionalServiceImplBase {

        @Override
        public StreamObserver<MessageRequest> getServerResponse(
                StreamObserver<MessageResponse> responseObserver) {

            ArrayList<String> buffer = new ArrayList<>();

            return new StreamObserver<MessageRequest>() {

                @Override
                public void onNext(MessageRequest req) {
                    buffer.add(req.getMessage());
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("Server error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    for (String msg : buffer) {
                        MessageResponse resp = MessageResponse.newBuilder()
                                .setMessage(msg)
                                .build();
                        responseObserver.onNext(resp);
                    }
                    responseObserver.onCompleted();
                    System.out.println("[Server] completed");
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = ServerBuilder.forPort(50055)
                .addService(new BidirectionalServiceImpl())
                .build();

        server.start();
        System.out.println("Server processing gRPC bidirectional streaming.");

        server.awaitTermination();
    }
}
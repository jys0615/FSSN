package com.example.clientstreaming;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ClientStreamingServer {

    static class ClientStreamingServiceImpl extends ClientStreamingServiceGrpc.ClientStreamingServiceImplBase {

        @Override
        public StreamObserver<NumberRequest> sendNumbers(StreamObserver<SummaryResponse> responseObserver) {

            return new StreamObserver<NumberRequest>() {

                int sum = 0;

                @Override
                public void onNext(NumberRequest request) {
                    int v = request.getValue();
                    System.out.println("[Server] Received: " + v);
                    sum += v;
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("[Server] Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {

                    SummaryResponse response = SummaryResponse.newBuilder()
                            .setSum(sum)
                            .build();

                    System.out.println("[Server] Sending summary: " + sum);

                    responseObserver.onNext(response);
                    responseObserver.onCompleted();
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Client Streaming gRPC Server starting...");

        Server server = ServerBuilder
                .forPort(50053)
                .addService(new ClientStreamingServiceImpl())
                .build()
                .start();

        System.out.println("Server started on port 50053");

        server.awaitTermination();
    }
}
package com.example.serverstreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class ServerStreamingClient {

    public static void main(String[] args) {

        System.out.println("Server Streaming gRPC Client running...");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50052)
                .usePlaintext()
                .build();

        ServerStreamingServiceGrpc.ServerStreamingServiceBlockingStub stub = ServerStreamingServiceGrpc
                .newBlockingStub(channel);

        NumberRequest request = NumberRequest.newBuilder()
                .setStart(10)
                .build();

        System.out.println("[Client] Request start = 10");

        // 스트림 응답 처리
        stub.streamNumbers(request).forEachRemaining(response -> {
            System.out.println("[Client] Received value: " + response.getValue());
        });

        channel.shutdown();
    }
}
package com.example.serverstreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class client {

    public static void main(String[] args) {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ServerStreamingGrpc.ServerStreamingBlockingStub stub = ServerStreamingGrpc
                .newBlockingStub(channel);

        Number request = Number.newBuilder()
                .setValue(5)
                .build();


        stub.getServerResponse(request).forEachRemaining(response -> {
            System.out.println("[server to client] " + response.getMessage());
        });

        // 채널 종료
        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
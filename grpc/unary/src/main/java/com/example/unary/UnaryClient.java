package com.example.unary;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class UnaryClient {

    public static void main(String[] args) {
        System.out.println("Unary gRPC Client running...");

        // gRPC 채널 생성
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        // Stub 생성
        UnaryServiceGrpc.UnaryServiceBlockingStub stub =
                UnaryServiceGrpc.newBlockingStub(channel);

        // 요청 생성
        NumberRequest request = NumberRequest.newBuilder()
                .setNumber(12)
                .build();

        System.out.println("[Client] Sending number: 12");

        // 서버 호출
        NumberResponse response = stub.getSquare(request);

        System.out.println("[Client] Response from server: " + response.getResult());

        // 채널 종료
        channel.shutdown();
    }
}

package com.example.unary;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class UnaryClient {

        public static void main(String[] args) {
                // gRPC 채널 생성
                ManagedChannel channel = ManagedChannelBuilder
                                .forAddress("localhost", 50051)
                                .usePlaintext()
                                .build();

                // Stub 생성
                UnaryServiceGrpc.UnaryServiceBlockingStub stub = UnaryServiceGrpc.newBlockingStub(channel);

                // 요청 생성
                NumberRequest request = NumberRequest.newBuilder()
                                .setNumber(4)
                                .build();

                // 서버 호출
                NumberResponse response = stub.getSquare(request);

                // 결과 출력 
                System.out.println("gRPC result: " + response.getResult());

                // 채널 종료 (필수 수정: awaitTermination 추가)
                try {
                        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
        }
}
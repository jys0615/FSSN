package com.example.bidirectional;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class BidirectionalClient {

    public static void main(String[] args) {

        System.out.println("Bidirectional Client running...");

        // gRPC 채널 생성
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50054)
                .usePlaintext()
                .build();

        // 비동기 Stub 생성
        BidirectionalServiceGrpc.BidirectionalServiceStub asyncStub = BidirectionalServiceGrpc.newStub(channel);
        // 서버로부터의 응답을 처리할 StreamObserver 구현 예정
    }
}
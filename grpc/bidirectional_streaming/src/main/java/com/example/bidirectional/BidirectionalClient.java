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

        // 서버로부터의 응답을 처리할 StreamObserver 정의
        StreamObserver<ChatMessage> responseObserver = new StreamObserver<ChatMessage>() {
            @Override
            public void onNext(ChatMessage message) {
                System.out.println("[Client] Received from server: " + message.getMessage());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("[Client] Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("[Client] Server stream completed.");
            }
        };

        // 요청 스트림 생성
        StreamObserver<ChatMessage> requestObserver = asyncStub.chat(responseObserver);

        // 실제 메시지 전송 코드
    }
}
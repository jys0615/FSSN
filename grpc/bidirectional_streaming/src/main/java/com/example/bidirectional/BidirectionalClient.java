package com.example.bidirectional;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

public class BidirectionalClient {

    public static void main(String[] args) throws InterruptedException {

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50055)
                .usePlaintext()
                .build();

        BidirectionalServiceGrpc.BidirectionalServiceStub asyncStub = BidirectionalServiceGrpc.newStub(channel);

        StreamObserver<MessageRequest> requestObserver = asyncStub
                .getServerResponse(new StreamObserver<MessageResponse>() {

                    @Override
                    public void onNext(MessageResponse resp) {
                        System.out.println("[server to client] " + resp.getMessage());
                    }

                    @Override
                    public void onError(Throwable t) {
                        System.out.println("Client error: " + t.getMessage());
                    }

                    @Override
                    public void onCompleted() {
                        System.out.println("[Client] completed");
                    }
                });

        // Python 예제처럼 메시지 보내기
        for (int i = 1; i <= 5; i++) {
            String msg = "message #" + i;
            System.out.println("[client to server] " + msg);

            requestObserver.onNext(
                    MessageRequest.newBuilder().setMessage(msg).build());

            // 강의자료 실행 흐름 맞추기 위한 약간의 sleep
            Thread.sleep(150);
        }

        requestObserver.onCompleted();
        System.out.println("[client] stream closed");
        Thread.sleep(500);

        channel.shutdown();
    }
}
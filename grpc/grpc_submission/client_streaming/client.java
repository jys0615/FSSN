package com.example.clientstreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class client {

    public static void main(String[] args) throws Exception {

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        ClientStreamingGrpc.ClientStreamingStub asyncStub = ClientStreamingGrpc.newStub(channel);

        CountDownLatch finishLatch = new CountDownLatch(1);

        StreamObserver<Message> requestObserver = asyncStub.getServerResponse(new StreamObserver<Number>() {

            @Override
            public void onNext(Number response) {

                System.out.println("[server to client] " + response.getValue());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("[Client] Error: " + t.getMessage());
                finishLatch.countDown();
            }

            @Override
            public void onCompleted() {
                finishLatch.countDown();
            }
        });

        // Python과 동일하게 5개의 메시지 전송
        String[] messages = {
                "message #1",
                "message #2",
                "message #3",
                "message #4",
                "message #5"
        };

        for (String msg : messages) {

            System.out.println("[client to server] " + msg);
            requestObserver.onNext(Message.newBuilder().setMessage(msg).build());
        }

        requestObserver.onCompleted();

        // 서버 응답 대기
        finishLatch.await(5, TimeUnit.SECONDS);

        // 채널 종료
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
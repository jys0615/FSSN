package com.example.clientstreaming;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.concurrent.TimeUnit;

public class ClientStreamingClient {

    public static void main(String[] args) throws Exception {

        System.out.println("Client Streaming gRPC Client running...");

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 50053)
                .usePlaintext()
                .build();

        ClientStreamingServiceGrpc.ClientStreamingServiceStub asyncStub = ClientStreamingServiceGrpc.newStub(channel);

        StreamObserver<NumberRequest> requestObserver = asyncStub.sendNumbers(new StreamObserver<SummaryResponse>() {

            @Override
            public void onNext(SummaryResponse summary) {
                System.out.println("[Client] Sum from server = " + summary.getSum());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("[Client] Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("[Client] Completed");
            }
        });

        // 스트리밍으로 여러 숫자 전송
        requestObserver.onNext(NumberRequest.newBuilder().setValue(10).build());
        requestObserver.onNext(NumberRequest.newBuilder().setValue(20).build());
        requestObserver.onNext(NumberRequest.newBuilder().setValue(30).build());

        requestObserver.onCompleted();

        // 서버의 onCompleted() 신호를 받을 충분한 시간 확보
        channel.awaitTermination(5, TimeUnit.SECONDS);

        // 스트림 종료 이후에 채널 닫기
        channel.shutdown();
    }
}
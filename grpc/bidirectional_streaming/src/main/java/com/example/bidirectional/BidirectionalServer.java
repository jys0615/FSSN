package com.example.bidirectional;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

// Proto에서 생성될 클래스: BidirectionalServiceGrpc
// message: ChatMessage
// 이들은 build/generated/... 에서 자동 생성됨

public class BidirectionalServer {

    // gRPC 서비스 구현 뼈대
    static class BidirectionalServiceImpl extends BidirectionalServiceGrpc.BidirectionalServiceImplBase {

        @Override
        public StreamObserver<ChatMessage> chat(StreamObserver<ChatMessage> responseObserver) {

            // 실제 로직은 추후 구현 예정
            return new StreamObserver<ChatMessage>() {

                @Override
                public void onNext(ChatMessage value) {
                    // 구현 예정
                }

                @Override
                public void onError(Throwable t) {
                    // 구현 예정
                }

                @Override
                public void onCompleted() {
                    // 구현 예정
                    responseObserver.onCompleted();
                }
            };
        }
    }

    public static void main(String[] args) throws Exception {

        System.out.println("Bidirectional Server starting...");

        Server server = ServerBuilder
                .forPort(50054)
                .addService(new BidirectionalServiceImpl())
                .build()
                .start();

        System.out.println("Server started on port 50054");

        server.awaitTermination();
    }
}
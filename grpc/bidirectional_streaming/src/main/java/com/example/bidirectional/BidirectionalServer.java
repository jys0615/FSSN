package com.example.bidirectional;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class BidirectionalServer {

    static class BidirectionalServiceImpl extends BidirectionalServiceGrpc.BidirectionalServiceImplBase {

        @Override
        public StreamObserver<ChatMessage> chat(StreamObserver<ChatMessage> responseObserver) {

            return new StreamObserver<ChatMessage>() {

                @Override
                public void onNext(ChatMessage message) {
                    System.out.println("[Server] Received: " + message.getMessage());

                    // 서버에서 받은 메시지를 다시 클라이언트에게 전송 (Echo)
                    ChatMessage reply = ChatMessage.newBuilder()
                            .setMessage("Echo: " + message.getMessage())
                            .build();

                    responseObserver.onNext(reply);
                }

                @Override
                public void onError(Throwable t) {
                    System.out.println("[Server] Error: " + t.getMessage());
                }

                @Override
                public void onCompleted() {
                    System.out.println("[Server] Client stream completed.");
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
package com.example.serverstreaming;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

public class ServerStreamingServer {

    static class ServerStreamingServiceImpl extends ServerStreamingServiceGrpc.ServerStreamingServiceImplBase {

        @Override
        public void streamNumbers(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {

            int start = request.getStart();

            System.out.println("[Server] Received start: " + start);

            // 예: 시작 숫자부터 +5까지 스트림으로 반환
            for (int i = start; i < start + 5; i++) {
                NumberResponse response = NumberResponse.newBuilder()
                        .setValue(i)
                        .build();

                System.out.println("[Server] Sending: " + i);
                responseObserver.onNext(response);

                try {
                    Thread.sleep(500); // 스트리밍 느낌을 위해 (0.5초로 지정)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Server Streaming gRPC Server starting...");

        Server server = ServerBuilder
                .forPort(50052) // 서버 스트리밍용 포트
                .addService(new ServerStreamingServiceImpl()) // 서비스 등록
                .build() // 서버 빌드
                .start(); // 서버 시작

        System.out.println("Server started on port 50052");

        server.awaitTermination();
    }
}
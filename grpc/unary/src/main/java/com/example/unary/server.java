package com.example.unary;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class server {

    // 1) 서비스를 구현한 클래스
    static class UnaryServiceImpl extends UnaryServiceGrpc.UnaryServiceImplBase {
        @Override
        public void getSquare(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {

            int num = request.getNumber();
            int squared = num * num;

            // Python 서버처럼 처리 로그 없이 조용히 처리
            NumberResponse response = NumberResponse.newBuilder()
                    .setResult(squared)
                    .build();

            // 응답 전송
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(50051)
                .addService(new UnaryServiceImpl())
                .build()
                .start();

        // Python 스타일: "Starting server. Listening on port 50051."
        System.out.println("Starting server. Listening on port 50051.");

        server.awaitTermination();
    }
}
package com.example.unary;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;
import com.example.unary.NumberRequest;
import com.example.unary.NumberResponse;
import com.example.unary.UnaryServiceGrpc;

public class UnaryClient {

    // 1) 서비스를 구현한 클래스
    static class UnaryServiceImpl extends UnaryServiceGrpc.UnaryServiceImplBase {
        @Override
        public void getSquare(NumberRequest request, StreamObserver<NumberResponse> responseObserver) {

            int num = request.getNumber();
            int squared = num * num;

            System.out.println("[Server] Received number: " + num);
            System.out.println("[Server] Calculated square: " + squared);

            NumberResponse response = NumberResponse.newBuilder()
                    .setResult(squared)
                    .build();

            // 응답 전송
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Unary gRPC Server starting...");

        Server server = ServerBuilder
                .forPort(50051)
                .addService(new UnaryServiceImpl())
                .build()
                .start();

        System.out.println("Server started on port 50051");
        server.awaitTermination();
    }
}

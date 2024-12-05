package com.nextytech.grpcserver.service;

import com.nextytech.grpcinterface.lib.HelloRequest;
import com.nextytech.grpcinterface.lib.HelloResponse;
import com.nextytech.grpcinterface.lib.MyServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class MyServiceImpl extends MyServiceGrpc.MyServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting("Hola "+ request.getName() + " que tengas buenas noches!")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}

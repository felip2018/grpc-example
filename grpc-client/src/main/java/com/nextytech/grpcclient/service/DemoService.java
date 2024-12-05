package com.nextytech.grpcclient.service;

import com.nextytech.grpcinterface.lib.HelloRequest;
import com.nextytech.grpcinterface.lib.MyServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @GrpcClient("myService")
    private MyServiceGrpc.MyServiceBlockingStub myServiceStub;

    public String receivegreeting(String name) {
        System.out.println("receiving greeting: " + name);
        HelloRequest request = HelloRequest.newBuilder()
                .setName(name).build();
        return myServiceStub.sayHello(request).getGreeting();
    }

}

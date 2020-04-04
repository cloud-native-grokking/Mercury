package com.cloudnative.grokking.mercury.controller.rpc.grpc;

import com.cloudnative.grokking.mercury.GrpcTestApp;
import com.cloudnative.grokking.mercury.proto.api.PingGRpcServiceGrpc;
import com.cloudnative.grokking.mercury.proto.api.PingRequest;
import com.cloudnative.grokking.mercury.proto.api.PingResponse;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;

/**
 * @author nghiatn
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GrpcTestApp.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE, properties = {
//        "grpc.enabled=false",
//        "grpc.inProcessServerName='grpcTestServer'"
})
public class GrpcPingControllerTest extends GrpcServerTestBase {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        // GIVEN
        PingGRpcServiceGrpc.PingGRpcServiceBlockingStub stub = PingGRpcServiceGrpc.newBlockingStub(Optional.ofNullable(channel).orElse(inProcChannel));

        // WHEN
        PingResponse response = stub.ping(PingRequest.newBuilder().build());

        // THEN
        assertThat(response.getResponse(), Is.is("-ServerHandled!"));
        assertThat(response.getReturncode(), Is.is(1));
    }

    //    @Test
//    public void test_out_proccess() {
//        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8072)
//                .usePlaintext()
//                .build();
//
//        PingGRpcServiceGrpc.PingGRpcServiceBlockingStub stub
//                = PingGRpcServiceGrpc.newBlockingStub(channel);
//
//        PingResponse response = stub.ping(PingRequest.newBuilder().build().newBuilder()
//                .setRequest("gRPCsd")
//                .build());
//
//        assertThat(response.getResponse(), Is.is("gRPCsd-ServerHandled!"));
//        channel.shutdown();
//    }
}
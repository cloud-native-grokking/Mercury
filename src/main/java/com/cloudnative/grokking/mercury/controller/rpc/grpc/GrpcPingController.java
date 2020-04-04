package com.cloudnative.grokking.mercury.controller.rpc.grpc;

import com.cloudnative.grokking.mercury.entity.MessageEntity;
import com.cloudnative.grokking.mercury.proto.api.PingGRpcServiceGrpc;
import com.cloudnative.grokking.mercury.proto.api.PingRequest;
import com.cloudnative.grokking.mercury.proto.api.PingResponse;
import com.cloudnative.grokking.mercury.repository.MessageRepository;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author nghiatn
 */

@GRpcService
@Slf4j
public class GrpcPingController extends PingGRpcServiceGrpc.PingGRpcServiceImplBase {
    @Autowired
    MessageRepository messageRepository;

    @Override
    public void ping(PingRequest request, StreamObserver<PingResponse> responseObserver) {
        log.info("Request: " + request.getRequest());

        MessageEntity messageEntity = MessageEntity.builder().content(request.getRequest()).build();
        messageRepository.save(messageEntity);

        responseObserver.onNext(PingResponse.newBuilder()
                .setResponse(request.getRequest() + "-ServerHandled!")
                .setReturncode(1)
                .build());
        responseObserver.onCompleted();
    }
}

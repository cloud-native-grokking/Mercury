package com.cloudnative.grokking.mercury.controller.rpc;


import com.cloudnative.grokking.mercury.entity.MessageEntity;
import com.cloudnative.grokking.mercury.repository.MessageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/message")
@Slf4j
public class MessageController {

    @Autowired
    MessageRepository messageRepository;

    @PostMapping(value = "/addnew")
    public String ping(@RequestParam("content") String message) {
        log.info("Request data: " + message);

        messageRepository.save(MessageEntity.builder().content(message).build());

        return "OK";
    }
}

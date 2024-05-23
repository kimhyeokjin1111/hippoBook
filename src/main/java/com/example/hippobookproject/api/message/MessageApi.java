package com.example.hippobookproject.api.message;

import com.example.hippobookproject.service.message.MessageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageApi {

    private final MessageService messageService;

    @DeleteMapping("/v1/messages")
    public void getLetter(@RequestParam("id") List<Long> idList,
                          HttpSession session){
        log.info("messageId = {}",idList);

        messageService.removeMessage(idList);
    }
}

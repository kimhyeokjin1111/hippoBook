package com.example.hippobookproject.api.chatbot;

import com.example.hippobookproject.service.chatbot.ChatbotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Headers;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatbotApi {
    private final ChatbotService chatbotService;

    @PostMapping("/v1/ai/reply")
    public Map chatbotTest(@RequestBody Map<String, String> msg){
        log.info("msg = " + msg);
        return chatbotService.respMap(msg);
    }
}

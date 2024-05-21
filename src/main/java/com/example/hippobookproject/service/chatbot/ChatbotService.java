package com.example.hippobookproject.service.chatbot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatbotService {

    @Value("${api.ai}")
    String apiKey;

    public Map respMap(Map<String, String> msg){
        String url = "https://api.openai.com/v1/chat/completions";
        Map<String, String> setting = new HashMap<>();
        setting.put("role", "system");
        setting.put("content", "넌 이제부터 우리 사이트 상담사야 사이트 이용자가 질문하는 " +
                "내용에 성실히 답변해줘야 해 우리 사이트는 온라인 책장 사이트이고 책 리뷰를 " +
                "할 수 있는 커뮤니티에서 소통도 할 수 있어");

        Map<String, String> message = new HashMap<>();
        message.put("role", "user");
        message.put("content", msg.get("content"));

        List<Map> messages = List.of(setting, message);

        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("model", "gpt-3.5-turbo");
        reqBody.put("messages", messages);

        WebClient webClient = WebClient.builder()
                .baseUrl(url)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .build();

        Map resp = webClient.post()
                .body(BodyInserters.fromValue(reqBody))
                .retrieve()
                .bodyToMono(Map.class)
                .block();

        return resp;
    }
}

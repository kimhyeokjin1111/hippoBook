package com.example.hippobookproject.controller.message;

import com.example.hippobookproject.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/letter/write")
    public String letterWrite(){
        return "message/letterWrite";
    }

    @GetMapping("/letter/view")
    public String letterView(){
        return "message/letterView";
    }

    @GetMapping("/letter/get")
    public String getLetter(){
        return "message/get_letter";
    }

    @GetMapping("/letter/send")
    public String sendLetter(){
        return "message/send_letter";
    }
}

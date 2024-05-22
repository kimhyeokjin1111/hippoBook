package com.example.hippobookproject.controller.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.service.message.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

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
    public String getLetter(Model model, @SessionAttribute("userId") Long userId){
        List<MessageDto> getMessageList = messageService.findGetMessage(userId);
        model.addAttribute("getMessageList",getMessageList);

        log.info("getMessageList={}", getMessageList);

        return "message/get_letter";
    }

    @GetMapping("/letter/send")
    public String sendLetter(Model model, @SessionAttribute("userId") Long userId){

        List<MessageDto> postMessageList = messageService.findPostMessage(userId);
        model.addAttribute("postMessageList",postMessageList);

        log.info("postMessageList={}", postMessageList);
        return "message/send_letter";
    }
}

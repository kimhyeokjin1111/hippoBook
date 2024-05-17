package com.example.hippobookproject.controller.alarm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequiredArgsConstructor
public class alarmController {

    @GetMapping("/alarm")
    public String alarmPage(@SessionAttribute(value = "userId", required = false)
                            Long userId){
        return userId == null ?
                "redirect:/user/login" : "/alarm/alarmpage";
    }


}

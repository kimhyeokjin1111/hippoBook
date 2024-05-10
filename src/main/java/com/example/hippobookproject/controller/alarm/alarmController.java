package com.example.hippobookproject.controller.alarm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
public class alarmController {
    @GetMapping("/alarm")
    public String alarmPage(){
        return "/alarm/alarmpage";
    }
}

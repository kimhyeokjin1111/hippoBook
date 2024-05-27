package com.example.hippobookproject.controller.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.service.alarm.AlarmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class alarmController {

    private final AlarmService alarmService;
    @GetMapping("/alarm")
    public String alarmPage(@SessionAttribute(value = "userId", required = false)
                            Long userId, Model model){
        List<AlarmDto> alarmId = alarmService.selectById(userId);
        if (alarmId.isEmpty()){
                return "alarm/alarmpage"; // 수정 중
        }
//        model.addAttribute("alarmList", alarmList);

        return userId == null ?
                "redirect:/user/login" : "alarm/alarmpage";
    }




}

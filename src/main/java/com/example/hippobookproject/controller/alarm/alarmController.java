package com.example.hippobookproject.controller.alarm;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.service.alarm.AlarmService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class alarmController {
    private final AlarmService alarmService;

    @GetMapping("/alarm")
    public String alarmPage(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");

        // 로그인 안 하고 알람 페이지 진입시 로그인 페이지로 이동
        if (userId == null) {
            return "redirect:/user/login";
        }

        // 알람 확인 처리
        List<AlarmDto> findAlarms = alarmService.findById(userId);
        if (!findAlarms.isEmpty()) {
            alarmService.updateAlarmCheckByUserId(userId);
        }

        if (findAlarms.isEmpty()) {
            model.addAttribute("hasAlarms", false);
        } else {
            model.addAttribute("hasAlarms", true);
            model.addAttribute("findAlarms", findAlarms);
        }
        return "alarm/alarmpage";
    }
}
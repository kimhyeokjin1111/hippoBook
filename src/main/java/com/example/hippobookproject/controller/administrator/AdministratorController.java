package com.example.hippobookproject.controller.administrator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdministratorController {
    @GetMapping("/user")
    public String adminUser(){
        return "administrator/admin_user";
    }

    @GetMapping("/chart")
    public String adminChart(){
        return "administrator/admin_chart";
    }

    @GetMapping("/declaration")
    public String adminDeclaration(){
        return "administrator/admin_declaration";
    }

    @GetMapping("/follow")
    public String adminFollow(){
        return "administrator/admin_follow";
    }
}

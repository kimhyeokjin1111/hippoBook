package com.example.hippobookproject.controller.mypage;

import com.example.hippobookproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@Controller
@RequestMapping("/my-page")
@RequiredArgsConstructor
public class MyPageController {
    private final UserService userService;


    @GetMapping("/int")
    public String myPageInt(/*@SessionAttribute("userId") Long userId*/){
        Long userId = 1L;

        return "/mypage/myPageInt";
    }

    @GetMapping("/book/container")
    public String bookContainer(){
        return "/mypage/myPageBookContainer";
    }

    @GetMapping("/book/write-content")
    public String bookWriteContent(){
        return "/mypage/myWriteContent";
    }
}

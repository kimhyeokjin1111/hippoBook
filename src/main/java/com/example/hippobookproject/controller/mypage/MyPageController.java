package com.example.hippobookproject.controller.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/my-page")
@RequiredArgsConstructor
public class MyPageController {
    @GetMapping("/int")
    public String myPageInt(){
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

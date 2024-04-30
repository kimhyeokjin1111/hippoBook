package com.example.hippobookproject.controller.mypage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    @GetMapping("/sticker")
    public String myPageSticker(){
        return "mypage/myPageInt_stiker";
    }

    @GetMapping("/manage")
    public String myPageManage(){
        return "mypage/myPageInt_manage";
    }

    @GetMapping("/modify")
    public String myPageModify(){
        return "mypage/myPageInt_modify";
    }

    @GetMapping("/secession")
    public String myPageSecession(){
        return "mypage/myPageInt_secession";
    }
}

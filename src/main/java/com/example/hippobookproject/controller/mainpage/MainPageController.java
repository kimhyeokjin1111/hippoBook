package com.example.hippobookproject.controller.mainpage;

import com.example.hippobookproject.dto.main.ReadListDto;
import com.example.hippobookproject.dto.main.DealListDto;
import com.example.hippobookproject.dto.main.NovelListDto;
import com.example.hippobookproject.service.main.MainService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainPageController {


    @RequestMapping("/search")
    public String searchPage(){
        return "/main/searchpage";
    }

    private final MainService mainService;

    @GetMapping("/")
    public String enterMain(Model model){
        List<NovelListDto> novelList = mainService.findAll();
        List<DealListDto> dealList = mainService.selectByTitle();
        List<ReadListDto> readList = mainService.selectByContent();

        model.addAttribute("readList", readList);
        model.addAttribute("dealList", dealList);
        model.addAttribute("novelList", novelList);
        return "main/mainpage";

    }

    @GetMapping("/logout")
    public RedirectView logout(HttpSession session){
        session.invalidate();

        return new RedirectView("/");
    }



    }





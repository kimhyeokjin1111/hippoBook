package com.example.hippobookproject.controller.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.service.feed.FeedService;
import com.example.hippobookproject.service.follow.FollowService;
import com.example.hippobookproject.service.recommend.RecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;
    private final RecommendService recommendService;
    private final FollowService followService;

    @GetMapping()
    public String feedPage(Model model){
        List<CardDto> feedList = feedService.selectAll();
        model.addAttribute("feedList", feedList);
        return "feed/feedpage";
    }

    @GetMapping("/postwrite")
    public String postwrite(){
        return "feed/postwrite";
    }

    @GetMapping("/readwrite")
    public String readwrite(){
        return "feed/readwrite";
    }
}

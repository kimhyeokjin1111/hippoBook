package com.example.hippobookproject.controller.feed;

import com.example.hippobookproject.service.feed.FeedService;
import com.example.hippobookproject.service.follow.FollowService;
import com.example.hippobookproject.service.recommend.RecommendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;
    private final RecommendService recommendService;
    private final FollowService followService;
}

package com.example.hippobookproject.api.follow;

import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.service.feed.FeedService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class FollowApi {
    private final FeedService feedService;

    @PostMapping("/v1/follows")
    public void follow(@RequestBody FollowDto followDto, HttpSession session){
//        Long userId = (Long) session.getAttribute("userId");
        log.info("followDto = " + followDto);
        Long userId = 1L;
        followDto.setFollowFrom(userId);
        feedService.insertFollow(followDto);
    }

    @DeleteMapping("/v1/unfollows")
    public void unFollow(@RequestBody FollowDto followDto,
                        @RequestBody Long followTo,
                         HttpSession session){
//        Long userId = (Long) session.getAttribute("userId");

        log.info("followTo = " + followTo);
        Long userId = 3L;
        followDto.setFollowFrom(userId);
        feedService.deleteFollow(followTo);


    }
}

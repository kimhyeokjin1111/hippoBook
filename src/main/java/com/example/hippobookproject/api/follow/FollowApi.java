package com.example.hippobookproject.api.follow;

import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.service.feed.FeedService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.*;

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

    @DeleteMapping("/v1/unfollows/{followTo}")
    public void unFollow(@PathVariable("followTo") Long followTo,
                         HttpSession session){
//        Long userId = (Long) session.getAttribute("userId");

        log.info("followTo = " + followTo);
        Long userId = 1L;

        FollowDto followDto = new FollowDto();
        followDto.setFollowTo(followTo);
        followDto.setFollowFrom(userId);

        feedService.deleteFollow(followDto);


    }
}

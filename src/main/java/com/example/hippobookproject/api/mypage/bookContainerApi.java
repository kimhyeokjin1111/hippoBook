package com.example.hippobookproject.api.mypage;

import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.service.mypage.MypageService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class bookContainerApi {
    private final MypageService mypageService;

    @DeleteMapping("/v1/containers/book/{bookHasId}")
    public void bookContainer(@PathVariable("bookHasId") Long bookHasId,
                                HttpSession session){
        log.info("bookHasId = {}",bookHasId);
        mypageService.removeBookContainer(bookHasId);

    }

    




}

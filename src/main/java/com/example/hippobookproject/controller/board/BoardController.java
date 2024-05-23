package com.example.hippobookproject.controller.board;

import com.example.hippobookproject.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/write")
    public String writepage() {
        return "board/writepage";
    }

    @GetMapping("/post/main")
    public String postMain(){
        return "board/post_main";
    }

    @GetMapping("/post/view")
    public String postView(Long postId, String postType){
        log.info("postId = " + postId + ", postType = " + postType);
        return "board/post_view";
    }
}

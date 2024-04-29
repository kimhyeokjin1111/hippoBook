package com.example.hippobookproject.controller.board;

import com.example.hippobookproject.service.board.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;
}

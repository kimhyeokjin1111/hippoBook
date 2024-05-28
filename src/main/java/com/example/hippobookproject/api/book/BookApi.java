package com.example.hippobookproject.api.book;

import com.example.hippobookproject.dto.book.BookCommentWriteDto;
import com.example.hippobookproject.dto.book.BookHasWriteDto;
import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BookApi {
    private final BookService bookService;

    @PostMapping("/book/v1/book/info")
    public void registerBookHas(@RequestBody BookHasWriteDto bookHasWriteDto){
        log.info("bookHasWriteDto = " + bookHasWriteDto);
        bookService.registerBookHas(bookHasWriteDto);
    }

    @PostMapping("/v1/book/info/comment")
    public void registerBookComment(@RequestBody BookCommentWriteDto bookCommentWriteDto){
        log.info("bookCommentWriteDto = " + bookCommentWriteDto);
        bookService.registerBookComment(bookCommentWriteDto);
    }
}

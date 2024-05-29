package com.example.hippobookproject.api.book;

import com.example.hippobookproject.dto.book.BookCommentWriteDto;
import com.example.hippobookproject.dto.book.BookHasWriteDto;
import com.example.hippobookproject.dto.book.BookInfoDto;
import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/v1/search/book/{keyword}")
    public List<BookInfoDto> searchBookByKeyword(@PathVariable("keyword") String keyword){
        return bookService.findBookByKeyword(keyword);
    }
}

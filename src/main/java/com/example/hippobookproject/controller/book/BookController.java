package com.example.hippobookproject.controller.book;

import com.example.hippobookproject.service.book.BookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/info")
    public String bookInfo(Model model){
        model.addAttribute("bookId", 1);
        return "book/book_info_page";
    }

//    SELECT BOOK_ID, BOOK_NAME, BOOK_WRITER, BOOK_DATE, LINK, DESCRIPTION, COVER, PUBLISHER_ID PUB_NAME, ISBN, CATEGORY
//    FROM TBL_BOOK
//    WHERE BOOK_ID = 1
}


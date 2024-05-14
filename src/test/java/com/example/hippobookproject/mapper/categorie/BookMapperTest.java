package com.example.hippobookproject.mapper.categorie;
import com.example.hippobookproject.dto.Categorie.BookDto;
import com.example.hippobookproject.mapper.book.BookMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
class BookMapperTest {
    @Autowired
    private BookMapper bookMapper;
    private BookDto Book;
    @BeforeEach
    void setUp(){
        Book = new BookDto();
        Book.setBookDate(1L);
        Book.setBookId(1L);
        Book.setPublisherId(1L);
    }
    @Test
    void insertBook(){
        bookMapper.insertBook(Book);
        BookDto insertBook = bookMapper.findBookById(Book.getBookId());
//        BookDto insertBook = bookMapper.findBookById(Book.getBookDate());
//        BookDto insertBook = bookMapper.findBookById(Book.getPublisherId());

    }
    @Test
    void updateBook(){
        bookMapper.updateBook(Book);
        BookDto updateBook = bookMapper.findBookById(Book.getBookId());
//        BookDto updateBook = bookMapper.findBookById(Book.getBookDate());
//        BookDto updateBook = bookMapper.findBookById(Book.getPublisherId());
    }
    @Test
    void deleteBook(){
        bookMapper.deleteBook(Book);
        BookDto deleteBook = bookMapper.findBookById(Book.getBookId());
//        BookDto deleteBook = bookMapper.findBookById(Book.getBookDate());
//        BookDto deleteBook = bookMapper.findBookById(Book.getBookDate());
    }
}
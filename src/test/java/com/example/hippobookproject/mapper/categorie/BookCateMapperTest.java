package com.example.hippobookproject.mapper.categorie;
import com.example.hippobookproject.dto.Categorie.BookCateDto;
import com.example.hippobookproject.mapper.book.BookCateMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootTest
@Transactional
class BookCateMapperTest {
    @Autowired
    private BookCateMapper bookCateMapper;
    private BookCateDto BookCate;
    @BeforeEach
    void setUp() {
        BookCate = new BookCateDto();
        BookCate.setBookCateId(1L);
        BookCate.setCateId(1L);
        BookCate.setBookId(1L);
    }
    @Test
    void insertBookCate() {
        bookCateMapper.insertBookCate(BookCate);
        BookCateDto insertBookCate = bookCateMapper.findBookCateById(BookCate.getCateId());
//        BookCateDto insertBookCate = bookCateMapper.findBookCateById(BookCate.getBookId());
//        BookCateDto insertBookCate = bookCateMapper.findBookCateById(BookCate.getBookCateId());
    }
    @Test
    void deleteBookCate(){
        bookCateMapper.deleteBookCate(BookCate);
        BookCateDto deleteBookCate = bookCateMapper.findBookCateById(BookCate.getCateId());
//        BookCateDto deleteBookCate = bookCateMapper.findBookCateById(BookCate.getBookId());
//        BookCateDto deleteBookCate = bookCateMapper.findBookCateById(BookCate.getBookCateId());
    }
    @Test
    void updateBookCate(){
        bookCateMapper.updateBookCate(BookCate);
        BookCateDto updateBookCate = bookCateMapper.findBookCateById(BookCate.getCateId());
//        BookCateDto updateBookCate = bookCateMapper.findBookCateById(BookCate.getBookId());
//        BookCateDto updateBookCate = bookCateMapper.findBookCateById(BookCate.getBookCateId());
    }
}
package com.example.hippobookproject.mapper.book;
import com.example.hippobookproject.dto.Categorie.BookDto;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BookMapper {
    BookDto getBookById(Long bookId);
    void insertBook(BookDto book);
    void updateBook(BookDto book);
    void deleteBookById(Long bookId);
}

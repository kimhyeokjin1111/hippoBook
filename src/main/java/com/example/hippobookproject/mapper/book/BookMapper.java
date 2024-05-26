package com.example.hippobookproject.mapper.book;
import com.example.hippobookproject.dto.Categorie.BookDto;
import com.example.hippobookproject.dto.book.AladinItemDto;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface BookMapper {
    void insertBook(BookDto book);
    void updateBook(BookDto book);
    BookDto findBookById(Long bookId);
    void deleteBook(BookDto book);

    void insertAllBook(AladinItemDto aladinItemDto);
}

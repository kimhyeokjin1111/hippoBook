package com.example.hippobookproject.mapper.book;
import com.example.hippobookproject.dto.Categorie.BookCateDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookCateMapper {
    void BookCateMapper(BookCateDto bookCateDto);

    void updateBookCate(BookCateDto bookCateDto);

    void deleteBookCateById(Long bookCateId);

    BookCateDto BookCateById(Long bookCateId);
}

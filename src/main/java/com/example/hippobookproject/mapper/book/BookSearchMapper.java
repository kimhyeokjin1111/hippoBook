package com.example.hippobookproject.mapper.book;

import com.example.hippobookproject.dto.book.BookInfoDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookSearchMapper {
    List<BookInfoDto> selectBookByKeyword(String keyword);
}

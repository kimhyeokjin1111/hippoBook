package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.apache.ibatis.annotations.Mapper;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Mapper
public interface MypageMapper {
    Optional<IntProfileDto> selectProfile(Long userId);

    void insertIntBoardText(IntBoardDto intBoardDto);

    Optional<IntBoardDto> selectIntBoardText(Long userId);


    void updateIntBoardText(IntBoardDto intBoardDto);

    List<BookContainerDto> selectRecentBook(Long userId);

}

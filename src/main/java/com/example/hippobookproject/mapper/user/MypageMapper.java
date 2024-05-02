package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MypageMapper {
    Optional<IntProfileDto> selectProfile(Long userId);

    void insertIntBoardText(IntBoardDto intBoardDto);

    IntBoardDto selectIntBoardText(Long userId);

}

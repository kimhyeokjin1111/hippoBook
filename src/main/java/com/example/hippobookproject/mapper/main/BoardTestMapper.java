package com.example.hippobookproject.mapper.main;

import com.example.hippobookproject.dto.main.BoardListDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BoardTestMapper {
    List<BoardListDto> selectByContent();
}

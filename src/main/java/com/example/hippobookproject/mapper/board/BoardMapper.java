package com.example.hippobookproject.mapper.board;

import com.example.hippobookproject.dto.board.PostSearchResultDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface BoardMapper {
    PostSearchResultDto selectDeclById(Long postId);
    PostSearchResultDto selectBoardById(Long postId);
    PostSearchResultDto selectNovelById(Long postId);
    PostSearchResultDto selectClaimById(Long postId);
}

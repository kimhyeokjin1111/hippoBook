package com.example.hippobookproject.service.board;

import com.example.hippobookproject.dto.board.PostSearchResultDto;
import com.example.hippobookproject.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public PostSearchResultDto selectPostById(Long postId, String postType){
        switch (postType){
            case "deal":
                return boardMapper.selectDeclById(postId);
            case "board":
                return boardMapper.selectBoardById(postId);
            case "novel":
                return boardMapper.selectNovelById(postId);
            default:
                return boardMapper.selectClaimById(postId);
        }
    }
}

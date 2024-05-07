package com.example.hippobookproject.service.main;

import com.example.hippobookproject.dto.main.BoardListDto;
import com.example.hippobookproject.dto.main.DealListDto;
import com.example.hippobookproject.dto.main.NovelListDto;
import com.example.hippobookproject.mapper.main.BoardTestMapper;
import com.example.hippobookproject.mapper.main.DealMapper;
import com.example.hippobookproject.mapper.main.NovelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MainService {
    private final NovelMapper novelMapper;
    private final DealMapper dealMapper;
    private final BoardTestMapper boardTestMapper;

    public List<NovelListDto> findAll(){
        return novelMapper.selectAll();
    }

    public List<DealListDto> selectByTitle() {
        return dealMapper.selectByTitle();
    }

    public List<BoardListDto> selectByContent(){
        return boardTestMapper.selectByContent();
    }

}

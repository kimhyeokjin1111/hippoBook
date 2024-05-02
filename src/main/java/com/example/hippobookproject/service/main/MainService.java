package com.example.hippobookproject.service.main;

import com.example.hippobookproject.dto.main.NovelListDto;
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

    public List<NovelListDto> findAll(){
        return novelMapper.selectAll();
    }
}

package com.example.hippobookproject.service.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import com.example.hippobookproject.dto.feed.FollowDto;
import com.example.hippobookproject.dto.feed.ReadCardDto;
import com.example.hippobookproject.mapper.feed.FeedMapper;
import com.example.hippobookproject.mapper.feed.ReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ReadService {
    private final ReadMapper readMapper;

    public List<ReadCardDto> selectAll(){
        return readMapper.selectAll(1L);
    }

    public void insertFollow(FollowDto followDto){
        readMapper.insertFollow(followDto);
    }


}

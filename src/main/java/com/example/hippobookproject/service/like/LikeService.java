package com.example.hippobookproject.service.like;

import com.example.hippobookproject.mapper.like.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class LikeService {
    private final LikeMapper likeMapper;
}

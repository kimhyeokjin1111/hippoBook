package com.example.hippobookproject.service.feed;

import com.example.hippobookproject.mapper.feed.FeedMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper feedMapper;
}

package com.example.hippobookproject.mapper.feed;

import com.example.hippobookproject.dto.feed.CardDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class FeedMapperTest {
    @Autowired
    FeedMapper feedMapper;

    @Test
    void selectAll() {
        // given
        // when
        List<CardDto> feedList = feedMapper.selectAll();
        // then
        Assertions.assertThat(feedList).isNotEmpty();
    }
}
package com.example.hippobookproject.mapper.board;

import com.example.hippobookproject.dto.board.PostSearchResultDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;
    @Test
    void selectPostById() {
        PostSearchResultDto postSearchResultDto = boardMapper.selectDeclById(1L);
        assertThat(postSearchResultDto)
                .extracting("userNickname")
                .isEqualTo("usernick");

    }
}
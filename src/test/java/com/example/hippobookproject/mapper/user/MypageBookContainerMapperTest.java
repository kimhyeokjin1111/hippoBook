package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.BookContainerDto;
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
class MypageBookContainerMapperTest {
    @Autowired
    MypageBookContainerMapper mypageBookContainerMapper;

    BookContainerDto bookContainerDto;
    @Test
    void selectBookContainer() {

        List<BookContainerDto> bookContainerList = mypageBookContainerMapper.selectBookContainer(1L);
    }
}
package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class MypageMapperTest {

    @Autowired
    MypageMapper mypageMapper;

    IntProfileDto intProfileDto;

    @Test
    void selectProfile() {

    mypageMapper.selectProfile(1L);

    }




}
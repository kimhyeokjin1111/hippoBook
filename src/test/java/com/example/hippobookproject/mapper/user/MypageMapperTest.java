package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import org.junit.jupiter.api.BeforeEach;
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
    IntBoardDto intBoardDto;
    @Test
    void selectProfile() {

    mypageMapper.selectProfile(1L);

    }



    @Test
    void setUp(){
        intBoardDto = new IntBoardDto();
        intBoardDto = new IntBoardDto();
        intBoardDto.setUserId(1L);
        intBoardDto.setIntBoardContent("안녕하세요!!");
        intBoardDto.setIntBoardId(1L);
        mypageMapper.insertIntBoardText(intBoardDto);
        System.out.println("intBoardDto = " + intBoardDto);
    }

    @Test
    void selectIntBoardText(){
        mypageMapper.selectIntBoardText(1L);
    }


}
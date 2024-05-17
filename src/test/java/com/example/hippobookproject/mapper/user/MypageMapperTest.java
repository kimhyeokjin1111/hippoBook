package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.mypage.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MypageMapperTest {

    @Autowired
    MypageMapper mypageMapper;

    IntProfileDto intProfileDto;
    IntBoardDto intBoardDto;
    BookContainerDto bookContainerDto;
    MyContentDto myContentDto;
    StickerDto stickerDto;

    @Test
    void selectProfile() {

    mypageMapper.selectProfile(1L);

    }



    @Test
    void setUp(){
        intBoardDto = new IntBoardDto();
        intBoardDto = new IntBoardDto();
        intBoardDto.setUserId(1L);
        intBoardDto.setIntBoardContent("안녕하세요!!!!");
        intBoardDto.setIntBoardId(1L);
        mypageMapper.insertIntBoardText(intBoardDto);
        System.out.println("intBoardDto = " + intBoardDto);



    }



    @Test
    void selectIntBoardText(){
        mypageMapper.selectIntBoardText(1L);
    }

    @Test
    void updateIntBoardText(){
        intBoardDto = new IntBoardDto();
        intBoardDto.setUserId(1L);
        intBoardDto.setIntBoardContent("하이");
        mypageMapper.updateIntBoardText(intBoardDto);

    }

    @Test
    void selectRecentBook(){
        List<BookContainerDto> bookRecentList = mypageMapper.selectRecentBook(1L);
        System.out.println("bookRecentList = " + bookRecentList);

    }

    @Test
    void selectMyContent(){
        List<MyContentDto> myContentList = mypageMapper.selectMyContent(1L);
        System.out.println("myContentList = " + myContentList);

    }

    @Test
    void selectReviewCount(){
        Long reviewCount = mypageMapper.selectReviewCount(1L);
    }

    @Test
    void selectPostCount(){
        Long postCount = mypageMapper.selectPostCount(1L);
    }

    @Test
    void selectProfilePhoto(){
        mypageMapper.selectProfilePhoto(21L);
    }

    @Test
    void insertSticker(){
        stickerDto = new StickerDto();
        stickerDto.setUserId(1L);
        stickerDto.setStikerId(1L);
        stickerDto.setStickerPermissionCheck("N");
        stickerDto.setStickerRead("N");
        mypageMapper.insertSticker(stickerDto);
        System.out.println("stickerDto = " + stickerDto);

    }
}
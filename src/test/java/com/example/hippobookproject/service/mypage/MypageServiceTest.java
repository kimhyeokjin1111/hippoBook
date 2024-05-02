package com.example.hippobookproject.service.mypage;

import com.example.hippobookproject.dto.mypage.IntBoardDto;
import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.mapper.user.MypageMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class MypageServiceTest {

    @Mock
    MypageMapper mypageMapper;

    @InjectMocks
    MypageService mypageService;

    @Test
    void findProfile() {
        // given
        doReturn(Optional.of("닉네임")).when(mypageMapper).selectProfile(any());
        // when
        IntProfileDto profileDto = mypageService.findProfile(1L);
        // then
        assertThat(profileDto).extracting("userNickName").isEqualTo("닉네임");

    }

    @Test
    void resisterIntBoardText(){
        //given
        Mockito.doNothing().when(mypageMapper).insertIntBoardText(any());
        // when
        mypageService.registerIntBoardText(new IntBoardDto());
        // then
        Mockito.verify(mypageMapper, Mockito.times(1)).insertIntBoardText(any());
    }

    //@Test
    //void findIntBoardText(){
        // given
        //doReturn("안녕하세요!!").when(mypageMapper).selectIntBoardText(any());
        // when
        //IntBoardDto intBoardDto = mypageService.findIntBoardText(1L);
        // then
       // assertThat(intBoardDto).extracting("intBoardContent").isEqualTo("안녕하세요!!");

    //}

}
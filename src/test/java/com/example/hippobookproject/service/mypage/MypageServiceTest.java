package com.example.hippobookproject.service.mypage;

import com.example.hippobookproject.dto.mypage.IntProfileDto;
import com.example.hippobookproject.mapper.user.MypageMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    void findNickName() {
        // given
        doReturn(Optional.of("닉네임")).when(mypageMapper).selectProfile(any());
        // when
        IntProfileDto profileDto = mypageService.findProfile(1L);
        // then
        assertThat(profileDto).extracting("userNickName").isEqualTo("닉네임");

    }
}
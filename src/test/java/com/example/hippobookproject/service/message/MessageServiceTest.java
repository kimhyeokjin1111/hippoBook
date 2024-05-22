package com.example.hippobookproject.service.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.mapper.message.MessageMapper;
import org.apache.ibatis.annotations.Many;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Mock
    MessageMapper messageMapper;

    @InjectMocks
    MessageService messageService;

    @Test
    void findUserNickname() {

    }

    @Test
    void registerMessageWrite() {

    }

    @Test
    void findGetMessage(){
        doReturn(List.of(new MessageDto())).when(messageMapper).selectGetMessage(any());
        // when
        List<MessageDto> getMessageList = messageService.findGetMessage(any());
        // then
        assertThat(getMessageList).hasSize(1);
    }

    @Test
    void findPostMessage(){
        doReturn(List.of(new MessageDto())).when(messageMapper).selectPostMessage(any());
        // when
        List<MessageDto> postMessageList = messageService.findPostMessage(any());
        // then
        assertThat(postMessageList).hasSize(1);
    }
}
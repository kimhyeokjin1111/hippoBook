package com.example.hippobookproject.mapper.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.user.UserJoinDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@Transactional
class MessageMapperTest {
    @Autowired
    MessageMapper messageMapper;

    MessageDto messageDto;
    UserJoinDto userJoinDto;

    @BeforeEach
    void setUp() {
        messageDto = new MessageDto();
        messageDto.setMessageId(1L);
        messageDto.setMessageTitle("test");
        messageDto.setMessageContent("test-content");
        messageDto.setMessageTo(21L);
        messageDto.setMessageFrom(2L);
        messageMapper.insertMessage(messageDto);
        System.out.println("messageDto = " + messageDto);

    }

    @Test
    void insertMessage() {
        messageMapper.insertMessage(messageDto);
    }

    @Test
    void selectUserNickname(){
        userJoinDto = new UserJoinDto();
        userJoinDto.setUserId(2L);
        userJoinDto.setUserNickname("qwer");
        messageMapper.selectUserNickname("qwer");
    }

    @Test
    void selectGetMessage(){
        List<MessageDto> getMessage = messageMapper.selectGetMessage(2L);
        System.out.println("getMessage = " + getMessage);
    }

    @Test
    void selectPostMessage(){
        List<MessageDto> postMessage = messageMapper.selectPostMessage(21L);
        System.out.println("postMessage = " + postMessage);
    }
}
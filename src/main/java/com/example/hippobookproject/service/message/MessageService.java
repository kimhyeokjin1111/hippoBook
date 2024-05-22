package com.example.hippobookproject.service.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.mapper.message.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;

    public void findUserNickname(String userNickname){
        messageMapper.selectUserNickname(userNickname);
    };

    public void registerMessageWrite(MessageDto messageDto){
        messageMapper.insertMessage(messageDto);
    }

    public List<MessageDto> findGetMessage(Long userId) {

        return messageMapper.selectGetMessage(userId);
    }

    public List<MessageDto> findPostMessage(Long userId) {

        return messageMapper.selectPostMessage(userId);
    }
}

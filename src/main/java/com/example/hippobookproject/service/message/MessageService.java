package com.example.hippobookproject.service.message;

import com.example.hippobookproject.dto.alarm.AlarmDto;
import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.mypage.BookContainerDto;
import com.example.hippobookproject.mapper.alarm.AlarmMapper;
import com.example.hippobookproject.mapper.message.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MessageService {
    private final MessageMapper messageMapper;
    private final AlarmMapper alarmMapper;

    public MessageNicknameDto findUserNickname(String userNickname){
        return messageMapper.selectUserNickname(userNickname)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 닉네임"));
    };

    public void registerMessageWrite(MessageDto messageDto,AlarmDto alarmDto){
        messageMapper.insertMessage(messageDto);
        alarmMapper.insertAlarm(alarmDto);
    }

    public List<MessageDto> findGetMessage(Long userId) {

        return messageMapper.selectGetMessage(userId);
    }

    public List<MessageDto> findPostMessage(Long userId) {

        return messageMapper.selectPostMessage(userId);
    }

    public void removeMessage(List<Long> idList) {

        messageMapper.deleteMessage(idList);

    }

    public MessageDto findMessageView(Long messageId){
        return messageMapper.selectMessageView(messageId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 쪽지"));
    };
}

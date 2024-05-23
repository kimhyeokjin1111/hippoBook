package com.example.hippobookproject.mapper.message;

import com.example.hippobookproject.dto.message.MessageDto;
import com.example.hippobookproject.dto.message.MessageNicknameDto;
import com.example.hippobookproject.dto.user.UserJoinDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MessageMapper {
    void insertMessage(MessageDto messageDto);

    Optional<MessageNicknameDto> selectUserNickname(String userNickname);

    List<MessageDto> selectGetMessage(Long userId);

    List<MessageDto> selectPostMessage(Long userId);

    void deleteMessage(@Param("idList") List<Long> idList);
}

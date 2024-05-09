package com.example.hippobookproject.service.user;

import com.example.hippobookproject.dto.UserJoinDto;
import com.example.hippobookproject.dto.UserPhoneInfoDto;
import com.example.hippobookproject.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void joinUser(UserJoinDto userJoinDto) {
        userMapper.insertJoinUser(userJoinDto);
    }

    //    public void phoneInfo(UserPhoneInfoDto userPhoneInfoDto){
//        userMapper.insertUser(userPhoneInfoDto);
//    }

    public Long findId(String joinId, String joinPassword){
        return userMapper.selectJoinId(joinId, joinPassword)
                .orElseThrow(() -> new IllegalStateException("존재 하지 않는 회원 정보입니다."));
    }
}

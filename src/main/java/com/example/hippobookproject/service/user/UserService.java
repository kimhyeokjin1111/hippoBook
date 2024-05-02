package com.example.hippobookproject.service.user;

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

    public void phoneInfo(UserPhoneInfoDto userPhoneInfoDto) {
        userMapper.insertUser(userPhoneInfoDto);
    }
}

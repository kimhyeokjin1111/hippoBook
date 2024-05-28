package com.example.hippobookproject.service.user;

import com.example.hippobookproject.mapper.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCheckIdService {
    @Autowired
    private UserMapper userMapper;

    public boolean isCheckUserId(String userLoginId){
        int count = userMapper.checkUserId(userLoginId);
        return count > 0;
    }
}

package com.example.hippobookproject.service.user;

import com.example.hippobookproject.mapper.user.UserIdDuplicateMapper;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class UserIdDuplicateServiceImpl implements UserIdDuplicateService{

    @Autowired
    UserIdDuplicateMapper userIdDuplicateMapper;

    @Override
    public boolean selectId(String userLoginId){
        log.info("Service :: selectId...........");
        return userIdDuplicateMapper.selectId(userLoginId);
    }
}

package com.example.hippobookproject.service.user;

import com.example.hippobookproject.dto.user.UserJoinDto;
import com.example.hippobookproject.mapper.user.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;

    public void joinUser(UserJoinDto userJoinDto) {

        String yymmdd = userJoinDto.getYymmdd();
        String genderNum = userJoinDto.getGenderNum();

        String yy = yymmdd.substring(0, 2);
        LocalDate today = LocalDate.now();
        String todayYY = today.format(DateTimeFormatter.ofPattern("yy"));

        int age = Integer.parseInt(todayYY) - Integer.parseInt(yy) + 1;


        String gender = null;

        if(genderNum.equals("1") || genderNum.equals("3")){
            gender = "M";
        }else {
            gender = "F";
        }

        userJoinDto.setUserGender(gender);
        userJoinDto.setUserAge(age);


        userMapper.insertUser(userJoinDto);
    }

    public Long findUserId(String userLoginId, String userPassword) {
        return userMapper.selectId(userLoginId, userPassword)
                .orElseThrow(() -> new IllegalStateException("잘못된 인증 정보입니다."));
    }
}

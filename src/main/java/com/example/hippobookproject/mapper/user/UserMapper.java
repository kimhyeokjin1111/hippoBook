package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.UserPhoneInfoDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    void insertUser(UserPhoneInfoDto userPhoneInfoDto);


}

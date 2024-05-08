package com.example.hippobookproject.mapper.user;

import com.example.hippobookproject.dto.UserJoinDto;
import com.example.hippobookproject.dto.UserPhoneInfoDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

@Mapper
public interface UserMapper {
    Optional<Long> joinSelectId(@Param("joinId") String joinId,
                                @Param("joinPassword") String joinPassword);

//    회원 정보 저장 (회원가입)
    void insertUser(UserJoinDto userJoinDto);


}

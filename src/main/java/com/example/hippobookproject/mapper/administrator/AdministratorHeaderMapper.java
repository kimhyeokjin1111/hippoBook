package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultNoticeDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdministratorHeaderMapper {
    List<ResultNoticeDto> selectDeclAll();
}

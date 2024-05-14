package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultStickerDto;
import com.example.hippobookproject.dto.administrator.SelectStickerDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdministratorStickerMapper {
    List<ResultStickerDto> selectStickerReqList(@Param("selectSticker")SelectStickerDto selectStickerDto);
}

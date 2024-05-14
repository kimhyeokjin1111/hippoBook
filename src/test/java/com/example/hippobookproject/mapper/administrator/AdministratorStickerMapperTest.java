package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultStickerDto;
import com.example.hippobookproject.dto.administrator.SelectStickerDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class AdministratorStickerMapperTest {
    @Autowired
    AdministratorStickerMapper administratorStickerMapper;

    SelectStickerDto selectStickerDto;
    @BeforeEach
    void setUp() {
        selectStickerDto = new SelectStickerDto();
        selectStickerDto.setUserName("test");
        selectStickerDto.setStartFollowDate(LocalDate.parse("2024-05-14", DateTimeFormatter.ISO_DATE));
        selectStickerDto.setEndFollowDate(LocalDate.parse("2024-05-14", DateTimeFormatter.ISO_DATE));
        selectStickerDto.setFPermission("");
    }

    @Test
    void selectStickerReqList() {
        List<ResultStickerDto> resultStickerDtos = administratorStickerMapper.selectStickerReqList(selectStickerDto);
        assertThat(resultStickerDtos)
                .extracting("followCnt")
                .isEqualTo(4);
    }
}
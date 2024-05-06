package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class AdministratorDeclMapperTest {
    @Autowired
    AdministratorDeclMapper administratorDeclMapper;

    SelectDeclAdminDto selectDeclAdminDto;
    AdminUserCriteria criteria;
    @BeforeEach
    void setUp() {
        selectDeclAdminDto = new SelectDeclAdminDto();
        selectDeclAdminDto.setDeclarationContent("test");
        selectDeclAdminDto.setStartDeclarationDate(LocalDate.parse("2024-05-06", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setEndDeclarationDate(LocalDate.parse("2024-05-07", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setStartPocecssDate(LocalDate.parse("2024-05-06", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setEndPocecssDate(LocalDate.parse("2024-05-07", DateTimeFormatter.ISO_DATE));
        selectDeclAdminDto.setDeclarationType("deal");
        selectDeclAdminDto.setProcessType("");

        criteria = new AdminUserCriteria();
        criteria.setPage(1);
        criteria.setAmount(10);
    }

    @Test
    void selectDeclList() {
        List<ResultDeclAdminDto> resultDeclAdminDtos = administratorDeclMapper.selectDeclList(selectDeclAdminDto, criteria);
        assertThat(resultDeclAdminDtos)
                .hasSize(8)
                .extracting("declarationContent")
                .isEqualTo("test");
    }

    @Test
    void selectDeclTotal() {
        int i = administratorDeclMapper.selectDeclTotal(selectDeclAdminDto);
        assertThat(i).isEqualTo(8);
    }
}
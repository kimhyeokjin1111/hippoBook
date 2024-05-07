package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.mapper.administrator.AdministratorDeclMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorDeclService {
    private final AdministratorDeclMapper administratorDeclMapper;
    public List<ResultDeclAdminDto> findDeclList(SelectDeclAdminDto selectDeclAdminDto,
                                            AdminUserCriteria adminDeclCriteria) {
        return administratorDeclMapper.selectDeclList(selectDeclAdminDto, adminDeclCriteria);
    }

    public int selectDeclTotal(SelectDeclAdminDto selectDeclAdminDto) {
        return administratorDeclMapper.selectDeclTotal(selectDeclAdminDto);
    }
}

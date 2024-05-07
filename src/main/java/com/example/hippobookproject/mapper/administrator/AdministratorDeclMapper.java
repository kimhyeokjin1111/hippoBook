package com.example.hippobookproject.mapper.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdministratorDeclMapper {
    List<ResultDeclAdminDto> selectDeclList(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto,
                                            @Param("criteria") AdminUserCriteria adminDeclCriteria);

    int selectDeclTotal(@Param("selectDecl") SelectDeclAdminDto selectDeclAdminDto);
}

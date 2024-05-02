package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultUserAdminDto;
import com.example.hippobookproject.dto.administrator.SelectUserAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.mapper.administrator.AdiministratorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorService {
    private final AdiministratorMapper adiministratorMapper;

    public List<ResultUserAdminDto> findUserAdmin(SelectUserAdminDto selectUserAdminDto, AdminUserCriteria criteria){
        return adiministratorMapper.selectUserAdmin(selectUserAdminDto, criteria);
    }

    public int findUserAdminTotal(SelectUserAdminDto selectUserAdminDto){
        return adiministratorMapper.selectAdminUserTotal(selectUserAdminDto);
    }

}

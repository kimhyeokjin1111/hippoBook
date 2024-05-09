package com.example.hippobookproject.service.administrator;

import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.ResultPostInfoDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.mapper.administrator.AdministratorDeclMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AdministratorDeclService {
    private final AdministratorDeclMapper administratorDeclMapper;
    public List<ResultDeclAdminDto> findDeclList(SelectDeclAdminDto selectDeclAdminDto,
                                            AdminUserCriteria adminDeclCriteria) {
        return administratorDeclMapper.selectDeclList(selectDeclAdminDto, adminDeclCriteria);
    }

    public int findDeclTotal(SelectDeclAdminDto selectDeclAdminDto) {
        return administratorDeclMapper.selectDeclTotal(selectDeclAdminDto);
    }

    public ResultPostInfoDto findPostDecl(Long postId, String cate){
        Optional<ResultPostInfoDto> resultPostInfoDto = Optional.empty();

        if("deal".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectDealDecl(postId);
        }else if("board".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectBoardDecl(postId);
        }else if("novel".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectNovelDecl(postId);
        }else if("claim".equals(cate)){
            resultPostInfoDto = administratorDeclMapper.selectClaimDecl(postId);
        }

        return resultPostInfoDto.orElseThrow(() -> new IllegalStateException("해당 게시물이 존재하지 않음"));
    }
}

package com.example.hippobookproject.api.administrator;

import com.example.hippobookproject.dto.administrator.ResultChartAdminDto;
import com.example.hippobookproject.dto.administrator.ResultDeclAdminDto;
import com.example.hippobookproject.dto.administrator.ResultPostInfoDto;
import com.example.hippobookproject.dto.administrator.SelectDeclAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.AdminUserPage;
import com.example.hippobookproject.service.administrator.AdministratorChartService;
import com.example.hippobookproject.service.administrator.AdministratorDeclService;
import com.example.hippobookproject.service.administrator.AdministratorUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdministratorApi {
    private final AdministratorUserService administratorUserService;
    private final AdministratorChartService administratorChartService;
    private final AdministratorDeclService administratorDeclService;

    @DeleteMapping("/v1/users")
    public void removeUserByIdList(@RequestParam(value="userIdList" , required = false)
                                   List<Integer> userIdList){
        log.info("userIdList = " + userIdList);
        administratorUserService.removeUserAdminById(userIdList);

    }

    @GetMapping("/v1/chart/attendances/{term}")
    public List<ResultChartAdminDto> searchAttendanceList(@PathVariable("term") int term){
        log.info("term = " + term);
        List<ResultChartAdminDto> visitByRange = administratorChartService.findVisitByRange(term);
        log.info("visitByRange = " + visitByRange);
        return visitByRange;
    }

    @GetMapping("/v1/declarations/post")
    public Map<String , Object> searchDeclarationList(SelectDeclAdminDto selectDeclAdminDto,
                                                          AdminUserCriteria adminDeclCriteria) {
        return createDeclMap(selectDeclAdminDto, adminDeclCriteria);
    }

    public Map<String , Object> createDeclMap(SelectDeclAdminDto selectDeclAdminDto,
                                              AdminUserCriteria adminDeclCriteria){
        log.info("selectDeclAdminDto = " + selectDeclAdminDto + ", adminDeclCriteria = " + adminDeclCriteria);
        List<ResultDeclAdminDto> declList = administratorDeclService.findDeclList(selectDeclAdminDto, adminDeclCriteria);
        log.info("declList = {}", declList);
        int declTotal = administratorDeclService.findDeclTotal(selectDeclAdminDto);
        AdminUserPage declPage = new AdminUserPage(adminDeclCriteria, declTotal);

        Map<String , Object> declMap = new HashMap<>();
        declMap.put("declList", declList);
        declMap.put("declPage", declPage);

        return declMap;
    }

    @GetMapping("/v1/post/{postId}")
    public ResultPostInfoDto searchPostInfo(@PathVariable("postId") Long postId,
                                            String cate){
        log.info("postId = " + postId + ", cate = " + cate);
        ResultPostInfoDto postDecl = administratorDeclService.findPostDecl(postId, cate);
        postDecl.setCate(cate);
        return postDecl;
    }

    @DeleteMapping("/v1/declaration/{declId}")
    public void removeDeclById(@PathVariable("declId") Long declId){
        log.info("declId = " + declId);
        administratorDeclService.removeDecl(declId);
    };
}

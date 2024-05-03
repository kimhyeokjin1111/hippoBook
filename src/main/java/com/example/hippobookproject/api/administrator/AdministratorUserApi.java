package com.example.hippobookproject.api.administrator;

import com.example.hippobookproject.service.administrator.AdministratorUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AdministratorUserApi {
    private final AdministratorUserService administratorService;

    @DeleteMapping("/v1/users")
    public void removeUserByIdList(@RequestParam(value="userIdList" , required = false)
                                       List<Integer> userIdList){
        log.info("userIdList = " + userIdList);
        administratorService.removeUserAdminById(userIdList);

    }


}

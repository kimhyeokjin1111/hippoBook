package com.example.hippobookproject.controller.user;

import com.example.hippobookproject.dto.user.UserResponseDto;
import com.example.hippobookproject.service.user.UserIdDuplicateService;
import com.example.hippobookproject.service.user.UserIdDuplicateServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController("/user")
public class UserIdDuplicateController {

    @Autowired
    private UserIdDuplicateService userIdDuplicateService;

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Boolean> confirmId(String userLoginId){
       log.info("register..............");
       log.info("userLoginId:"+userLoginId);
       boolean result = true;

       if(userLoginId.trim().isEmpty()){
           log.info("userLoginId : " + userLoginId);
           result = false;
       }else {
           result = !userIdDuplicateService.selectId(userLoginId);
       }
       return new ResponseEntity<>(result, HttpStatus.OK);
    }
}

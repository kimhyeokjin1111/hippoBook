package com.example.hippobookproject.controller.administrator;

import com.example.hippobookproject.dto.administrator.ResultUserAdminDto;
import com.example.hippobookproject.dto.administrator.SelectUserAdminDto;
import com.example.hippobookproject.dto.page.AdminUserCriteria;
import com.example.hippobookproject.dto.page.AdminUserPage;
import com.example.hippobookproject.service.administrator.AdministratorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdministratorController {
    private final AdministratorService administratorService;

    @GetMapping("/user")
    public String adminUser(@ModelAttribute("selectUserAdminDto") SelectUserAdminDto selectUserAdminDto, Model model,
                            AdminUserCriteria criteria){
        log.info("selectUserAdminDto = " + selectUserAdminDto + ", criteria = " + criteria);

        List<ResultUserAdminDto> userList = administratorService.findUserAdmin(selectUserAdminDto,
                criteria);
        int total = administratorService.findUserAdminTotal(selectUserAdminDto);
        AdminUserPage page = new AdminUserPage(criteria, total);
        log.info("page = " + page, "total = " + total);

//        model.addAttribute("selectUserAdminDto", selectUserAdminDto);
        model.addAttribute("userList", userList);
        model.addAttribute("page", page);

        return "administrator/admin_user";
    }

    @GetMapping("/user/remove")
    public String userRemove(@RequestParam(value="userIdList" , required = false) List<Integer> userIdList ){
        log.info("userIdList = " + userIdList);

        return null;
    }

    @GetMapping("/chart")
    public String adminChart(){
        return "administrator/admin_chart";
    }

    @GetMapping("/declaration")
    public String adminDeclaration(){
        return "administrator/admin_declaration";
    }

    @GetMapping("/follow")
    public String adminFollow(){
        return "administrator/admin_follow";
    }
}

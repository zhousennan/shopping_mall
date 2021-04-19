package com.zsn.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Role;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "api")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping(value = "roles", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<Role> getRoleList(SearchVo searchVo) {
        return roleService.getRoleList(searchVo);
    }

    @GetMapping(value = "roles")
    public List<Role> getRoles() {
        return roleService.getRoles();
    }

    @PostMapping(value = "admins", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<UserInfo> getAdminList(SearchVo searchVo) {
        return roleService.getAdminList(searchVo);
    }

    @PostMapping(value = "insertAdmin", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserInfo> insertAdmin(@RequestBody UserInfo userInfo) {
        return roleService.insertAdmin(userInfo);
    }


}

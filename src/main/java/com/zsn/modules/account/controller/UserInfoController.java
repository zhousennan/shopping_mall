package com.zsn.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.UserInfoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    /**
     * 查询所有userInfo
     * 127.0.0.1:8080/api/userInfos ---- get
     * {"currentPage":"1","pageSize":"5","keyWord":"hu"}
     */
    @PostMapping(value = "userInfos", consumes = MediaType.APPLICATION_JSON_VALUE)
    PageInfo<UserInfo> getUsersBySearchVo(@RequestBody SearchVo searchVo) {
        return userInfoService.getUsersBySearchVo(searchVo);
    }

    /**
     * 新增userInfo
     * 127.0.0.1:8080/api/userInfo ---- post
     * {"user_name":"1"}
     */
    @PostMapping(value = "userInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserInfo> insertUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.insertUserInfo(userInfo);
    }

    /**
     * 删除userInfo
     * 127.0.0.1:8080/api/userInfo/{userId} ---- deleted
     * {"user_name":"1"}
     */
    @DeleteMapping(value = "userInfo/{userId}")
    public Result<Object> deleteUserInfo(@PathVariable int userId) {
        return userInfoService.deleteUserInfo(userId);
    }

    /**
     * 修改userInfo
     * 127.0.0.1:8080/api/userInfo ---- deleted
     * {"nickName":"zsn","userId":2}
     */
    @PutMapping(value = "userInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<UserInfo> updateUserInfo(@RequestBody UserInfo userInfo) {
        return userInfoService.updateUserInfo(userInfo);
    }

    @GetMapping(value = "userInfo/{userId}")
    UserInfo getUserInfoByUserId(@PathVariable int userId) {
        return userInfoService.getUserInfoByUserId(userId);
    }

    @ApiOperation("登录接口")
    @ApiImplicitParam(name="userInfo",value = "对应的userinfo信息",dataType = "json")
    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<UserInfo> login(@RequestBody UserInfo userInfo) {
        return userInfoService.login(userInfo);
    }

    @PostMapping(value = "gradeData")
    public List<List<Object>> getUserGradData() {
        return userInfoService.getUserGradData();
    }
}

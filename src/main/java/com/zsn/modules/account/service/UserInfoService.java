package com.zsn.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.UserInfo;

import java.util.List;

public interface UserInfoService {

    PageInfo<UserInfo> getUsersBySearchVo(SearchVo searchVo);

    Result<UserInfo> insertUserInfo(UserInfo userId);

    Result<Object> deleteUserInfo(int userId);

    Result<UserInfo> updateUserInfo(UserInfo userInfo);

    UserInfo getUserInfoByUserId(int userId);

    Result<UserInfo> login(UserInfo userInfo);

    UserInfo getUserInfoByUserName(String userName);

    List<List<Object>> getUserGradData();
}

package com.zsn.modules.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.dao.UserInfoDao;

import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.UserInfoService;
import com.zsn.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public PageInfo<UserInfo> getUsersBySearchVo(SearchVo searchVo) {

        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<UserInfo>(
                Optional.ofNullable(userInfoDao.getUserInfoList(searchVo))
                        .orElse(Collections.emptyList()));
    }

    @Override
    public Result<UserInfo> insertUserInfo(UserInfo userInfo) {
        UserInfo user=userInfoDao.getUserByUserName(userInfo.getUserName());
        if (user==null)
        {
            userInfoDao.insertUserInfo(userInfo);
            return new Result<UserInfo>(Result.ResultStatus.SUCCESS.status,
                    "注册成功");
        }else {
            return new Result<>(Result.ResultStatus.FAILD.status,"用户已经存在");
        }

    }

    @Override
    public Result<Object> deleteUserInfo(int userId) {
        userInfoDao.deletedUserRoleByUserId(userId);

        userInfoDao.deleteUserInfo(userId);
        return new Result<>(Result.ResultStatus.SUCCESS.status,"删除成功");
    }

    @Override
    public Result<UserInfo> updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
        return new Result<>(Result.ResultStatus.SUCCESS.status,"修改成功");
    }

    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }

    @Override
    public Result<UserInfo> login(UserInfo userInfo) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(userInfo.getUserName(), MD5Util.getMD5(userInfo.getPassword()));

        usernamePasswordToken.setRememberMe(userInfo.isRememberMe());

        try {
            subject.login(usernamePasswordToken);
         //   subject.checkRoles();
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<UserInfo>(Result.ResultStatus.FAILD.status,
                    "username or password error");
        }
        Session session = subject.getSession();
        session.setAttribute("user", (UserInfo) subject.getPrincipal());
        return new Result<UserInfo>(Result.ResultStatus.SUCCESS.status, "Login success");
    }

    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        return userInfoDao.getUserInfoByUserName(userName);
    }

    @Override
    public List<List<Object>> getUserGradData() {
        List<List<Object>> list =  new ArrayList<>();
        List<Object> listGtad  = new ArrayList<>();
        List<Object> mapList = new ArrayList<>();


        List<UserInfo> userInfoList = userInfoDao.getUserGradData();
        for (UserInfo userInfo : userInfoList) {
            listGtad.add(userInfo.getGrade());
            Map<String ,Object> map = new HashMap<>();
            map.put("value",userInfo.getGradeCount());
            map.put("name",userInfo.getGrade());
            mapList.add(map);
        }
        list.add(listGtad);
        list.add(mapList);

        return list;
    }
}

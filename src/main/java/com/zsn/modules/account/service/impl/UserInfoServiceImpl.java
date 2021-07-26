package com.zsn.modules.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.dao.UserInfoDao;

import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.RoleService;
import com.zsn.modules.account.service.UserInfoService;
import com.zsn.utils.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Autowired
    UserInfoDao userInfoDao;

    @Autowired
    private RoleService roleService;

    /*获取用户列表*/
    @Override
    public PageInfo<UserInfo> getUsersBySearchVo(SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<UserInfo>(
                Optional.ofNullable(userInfoDao.getUserInfoList(searchVo))
                        .orElse(Collections.emptyList()));
    }

    /*删除一个用户*/
    @Override
    @Transactional
    public Result<Object> deleteUserInfo(int userId) {
        userInfoDao.deletedUserRoleByUserId(userId);
        userInfoDao.deleteUserInfo(userId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功");
    }

    /*修改用户信息*/
    @Override
    @Transactional
    public Result<UserInfo> updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "修改成功");
    }

    /*通过用户id查询*/
    @Override
    public UserInfo getUserInfoByUserId(int userId) {
        return userInfoDao.getUserInfoByUserId(userId);
    }

    @Override
    public Result<UserInfo> login(UserInfo userInfo) {
       /* if (!"supper_admain".equals(roleService.getRoleByUserName(userInfo.getUserName()))){
          return new Result<UserInfo>(Result.ResultStatus.FAILD.status,
                    "用户角色权限不够");
        }else if (!"admain".equals(roleService.getRoleByUserName(userInfo.getUserName()))){
            return new Result<UserInfo>(Result.ResultStatus.FAILD.status,
                    "用户角色权限不够");
        }else {*/
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
    public Result<UserInfo> insertUserInfo(UserInfo userInfo) {
        UserInfo user = userInfoDao.getUserByUserName(userInfo.getUserName());
        if (user == null) {
            userInfoDao.insertUserInfo(userInfo);
            return new Result<UserInfo>(Result.ResultStatus.SUCCESS.status,
                    "注册成功");
        } else {
            return new Result<>(Result.ResultStatus.FAILD.status, "用户已经存在");
        }
    }

    /*通过用户信息进行查询*/
    @Override
    public UserInfo getUserInfoByUserName(String userName) {
        return userInfoDao.getUserInfoByUserName(userName);
    }

    /*echat图表的数据封装*/
    @Override
    public List<List<Object>> getUserGradData() {
        List<List<Object>> list = new ArrayList<>();
        List<Object> listGtad = new ArrayList<>();
        List<Object> mapList = new ArrayList<>();
        List<UserInfo> userInfoList = userInfoDao.getUserGradData();
        for (UserInfo userInfo : userInfoList) {
            listGtad.add(userInfo.getGrade());
            Map<String, Object> map = new HashMap<>();
            map.put("value", userInfo.getGradeCount());
            map.put("name", userInfo.getGrade());
            mapList.add(map);
        }
        list.add(listGtad);
        list.add(mapList);
        return list;
    }
}

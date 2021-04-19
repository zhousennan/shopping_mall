package com.zsn.modules.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.dao.RoleDao;
import com.zsn.modules.account.dao.UserInfoDao;
import com.zsn.modules.account.entity.Role;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.RoleService;
import com.zsn.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleDao roleDao;
    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public PageInfo<Role> getRoleList(SearchVo searchVo) {

        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<>(Optional.ofNullable(roleDao.getRoleList()).orElse(Collections.emptyList()));
    }

    @Override
    public PageInfo<UserInfo> getAdminList(SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<>(Optional.ofNullable(roleDao.getAdminList()).orElse(Collections.emptyList()));
    }

    @Override
    public Result<UserInfo> insertAdmin(UserInfo userInfo) {

        UserInfo userByUserName = userInfoDao.getUserByUserName(userInfo.getUserName());
        if (userByUserName != null) {
            return new Result<>(Result.ResultStatus.FAILD.status, "用户名已经存在");
        }

        String pwd = userInfo.getPassword();
        String md5 = MD5Util.getMD5(pwd);
        userInfo.setPassword(md5);
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        userInfo.setBirthday(sdf.format(new Date()));
        roleDao.insertAdmin(userInfo);
        List<Role> roleList = userInfo.getRoleList();

        UserInfo user = userInfoDao.getUserByUserName(userInfo.getUserName());

        int userId = (Integer) user.getUserId();

        for (Role role : roleList) {
            roleDao.insertRoleUser(userId, role.getRoleId());
        }

        return new Result<>(Result.ResultStatus.SUCCESS.status, "新增管理员成功");
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }
}

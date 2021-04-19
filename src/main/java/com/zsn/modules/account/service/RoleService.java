package com.zsn.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Role;
import com.zsn.modules.account.entity.UserInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RoleService {

    PageInfo<Role> getRoleList(SearchVo searchVo);

    PageInfo<UserInfo> getAdminList(SearchVo searchVo);

    Result<UserInfo> insertAdmin(UserInfo userInfo);

    List<Role> getRoles();
}

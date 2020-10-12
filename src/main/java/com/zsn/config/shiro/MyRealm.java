package com.zsn.config.shiro;

import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.UserInfoService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    UserInfoService userInfoService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken Token) throws AuthenticationException {
        String userName=(String) Token.getPrincipal();
        UserInfo user = userInfoService.getUserInfoByUserName(userName);
        if (user==null){
            throw  new UnknownAccountException("The account do not exit");
        }
        //getName获取MyRealm
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}

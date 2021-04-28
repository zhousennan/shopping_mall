package com.zsn.modules.account.service.impl;

import com.zsn.modules.account.entity.SystemInfo;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.SystemInfoService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {


    @Override
    public SystemInfo getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setCharacterEncoding("UTF-8");
        systemInfo.setOsName(System.getProperties().getProperty("os.name"));
        systemInfo.setMysql("8.0");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        systemInfo.setNowDate(df.format(new Date()));
        systemInfo.setIp("10.12.4.8");
     UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        systemInfo.setUserName(userInfo.getUserName());
        return systemInfo;
    }
}

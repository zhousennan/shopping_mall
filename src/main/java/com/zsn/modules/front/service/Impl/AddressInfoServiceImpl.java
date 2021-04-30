package com.zsn.modules.front.service.Impl;

import com.zsn.commons.entity.Result;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.front.dao.AddressInfoDao;
import com.zsn.modules.front.entity.AddressInfo;
import com.zsn.modules.front.service.AddressInfoService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AddressInfoServiceImpl implements AddressInfoService {

    @Autowired
    AddressInfoDao addressInfoDao;

    @Override
    public List<AddressInfo> getAddressByUser() {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return Optional.ofNullable(addressInfoDao.getAddressByUser(user.getUserName())).orElse(Collections.emptyList());
    }

    @Override
    @Transactional
    public Result<Object> insertAddress(AddressInfo addressInfo) {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        addressInfo.setUserName(user.getUserName());
        addressInfo.setStatus(0);
        addressInfoDao.insertAddress(addressInfo);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "新增地址成功");
    }

    @Override
    public List<AddressInfo> getAddress() {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return addressInfoDao.getAddress(user.getUserName());
    }
}

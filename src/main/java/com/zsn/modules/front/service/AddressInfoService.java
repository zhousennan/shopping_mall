package com.zsn.modules.front.service;

import com.zsn.commons.entity.Result;
import com.zsn.modules.front.entity.AddressInfo;

import java.util.List;

public interface AddressInfoService {

    List<AddressInfo> getAddressByUser();

    Result<Object> insertAddress(AddressInfo addressInfo);

    List<AddressInfo> getAddress();

    void  deletedAddress(int id);
}

package com.zsn.modules.front.controller;

import com.zsn.commons.entity.Result;
import com.zsn.modules.front.entity.AddressInfo;
import com.zsn.modules.front.service.AddressInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class AddressInfoController {
    @Autowired
    AddressInfoService addressInfoService;

    @GetMapping(value = "address")
    public List<AddressInfo> getAddressByUser() {
        return addressInfoService.getAddressByUser();
    }


    @PostMapping(value = "insertAddress", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Object> insertAddress(@RequestBody AddressInfo addressInfo) {
        return addressInfoService.insertAddress(addressInfo);
    }

    @GetMapping(value = "getAddress")
    public List<AddressInfo> getAddress() {
        return addressInfoService.getAddress();
    }

}

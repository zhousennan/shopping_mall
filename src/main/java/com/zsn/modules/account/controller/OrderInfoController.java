package com.zsn.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.service.OrderInfoService;
import org.apache.ibatis.javassist.bytecode.analysis.MultiType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class OrderInfoController {
    @Autowired
   private OrderInfoService orderInfoService;

    /*
     * 127.0.0.1:8080/api/OrderInfos  Post
     * {"currentPage":"1","pageSize":"5"}
     * */
    @PostMapping(value = "OrderInfos", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<OrderInfo> getOrderInfoList(@RequestBody SearchVo searchVo) {
        return orderInfoService.getOrderInfoList(searchVo);
    }

    /*
     * 127.0.0.1:8080/api/OrderInfo/1  deleted
     * */
    @DeleteMapping(value = "OrderInfo/{orderId}")
    public Result<Object> deletedOrderInfo(@PathVariable int orderId) {
        return orderInfoService.deletedOrderInfo(orderId);
    }

    /*
     * 127.0.0.1:8080/api/OrderInfo/1  put
     * */
    @PutMapping(value = "OrderInfo", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<OrderInfo> updateProduct(@RequestBody OrderInfo orderInfo) {
        return orderInfoService.updateProduct(orderInfo);
    }

    @PutMapping(value = "saveCourierNumber", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<OrderInfo> saveCourierNumber(@RequestBody OrderInfo orderInfo) {
        return orderInfoService.saveCourierNumber(orderInfo);
    }

    /*
     * 127.0.0.1:8080/api/orderInfo/1  get
     * */
    @GetMapping(value = "orderInfo/{orderId}")
    public OrderInfo getOrderInfo(@PathVariable int orderId) {
        return orderInfoService.getOrderInfo(orderId);
    }

    @PostMapping(value = "transationDate")
    public List<List<String>> transationDate() {
        return orderInfoService.getTransaionData();
    }

    @PostMapping(value = "infoTotal")
    public List<Object> getInfoTotal() {
        return orderInfoService.getInfoData();
    }
}

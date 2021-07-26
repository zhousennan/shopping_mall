package com.zsn.modules.account.service;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.OrderInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface OrderInfoService {

    PageInfo<OrderInfo> getOrderInfoList(SearchVo searchVo);

    Result<Object> deletedOrderInfo(String orderId);

    Result<OrderInfo> updateProduct(OrderInfo orderInfo);

    OrderInfo getOrderInfo(String orderId);

    Result<OrderInfo> saveCourierNumber(OrderInfo orderInfo);

    List<List<String>> getTransaionData();

    List<Object> getInfoData();
    List<OrderInfo> getAllOrderInfo();

    List<OrderInfo> getOrderInfoNoPay();

    List<OrderInfo> getOrderInfoNofh();
}

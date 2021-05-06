package com.zsn.modules.front.service;


import com.zsn.commons.entity.Result;
import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.front.entity.IndexInfo;

import java.util.List;

public interface FrontService {

    List<Product> hotProduct();

    List<Product> manProductList();

    List<Product> womanProductList();

    List<Product> childProductList();

    Product getProductById(int id);

    Result<OrderInfo> insertOrderInfo(OrderInfo orderInfo);

    List<OrderInfo> initPayPage();

    int getUserInfoAccountByUserName();

    Result<Object> payOrder(int payMoney);

    public IndexInfo getIndexInfo();
}

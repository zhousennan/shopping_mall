package com.zsn.modules.front.controller;

import com.zsn.commons.entity.Result;
import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.account.service.OrderInfoService;
import com.zsn.modules.front.entity.IndexInfo;
import com.zsn.modules.front.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api")
public class indexController {
    @Autowired
    FrontService frontService;
    @Autowired
    OrderInfoService orderInfoService;

    @GetMapping(value = "hotProduct")
    List<Product> hotProduct() {
        return frontService.hotProduct();
    }

    @GetMapping(value = "manProductList")
    List<Product> manProductList() {
        return frontService.manProductList();
    }

    @GetMapping(value = "womanProductList")
    List<Product> womanProductList() {
        return frontService.womanProductList();
    }

    @GetMapping(value = "childProductList")
    List<Product> childProductList() {
        return frontService.childProductList();
    }

    @GetMapping(value = "getProduct/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return frontService.getProductById(productId);
    }

    @PostMapping(value = "immediatelyProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<OrderInfo> insertOrderInfo(@RequestBody OrderInfo orderInfo) {
        return frontService.insertOrderInfo(orderInfo);
    }

    @GetMapping(value = "initPayPage")
    public List<OrderInfo> initPayPage() {
        return frontService.initPayPage();
    }

    @GetMapping(value = "InfoAccount")
    public int getUserInfoAccountByUserName() {
        return frontService.getUserInfoAccountByUserName();
    }

    @PutMapping(value = "payOrder/{payMoney}")
    public Result<Object> payOrder(@PathVariable int payMoney) {
        return frontService.payOrder(payMoney);
    }

    @GetMapping(value = "getIndexInfo")
    public IndexInfo getIndexInfo() {
        return frontService.getIndexInfo();
    }

    @GetMapping(value = "pay")
    public int getPay() {
        return frontService.pay();
    }

    @GetMapping(value = "getUserInfo")
    public UserInfo getUserInfo(){
        return frontService.getUserInfo();
    }
    @GetMapping(value = "getAllOrderInfo")
    public List<OrderInfo> getAllOrderInfo(){
     return    orderInfoService.getAllOrderInfo();
    }
    @GetMapping(value = "getOrderInfoNoPay")
    public List<OrderInfo> getOrderInfoNoPay(){
        return    orderInfoService.getAllOrderInfo();
    }
    @GetMapping(value = "getOrderInfoNofh")
    public List<OrderInfo> getOrderInfoNofh(){
        return    orderInfoService.getOrderInfoNofh();
    }

}

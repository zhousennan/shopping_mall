package com.zsn.modules.shoppingCart.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;

import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.shoppingCart.entities.ShoppingCartInfo;
import com.zsn.modules.shoppingCart.service.Impl.ShoppingCartInfoServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShoppingCartInfoController {

    @Autowired
    private ShoppingCartInfoServiceImpl shoppingCartInfoService;

    @PostMapping(value = "shoppingCart/insert",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<ShoppingCartInfo> insert(@RequestBody ShoppingCartInfo shoppingCartInfo) {
        return shoppingCartInfoService.insert(shoppingCartInfo);
    }

    @PutMapping(value = "shoppingCart/update",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<ShoppingCartInfo> update(ShoppingCartInfo shoppingCartInfo) {
        return shoppingCartInfoService.update(shoppingCartInfo);
    }

    @DeleteMapping(value = "shoppingCart/deleted/{userName}/{productId}")
    public Result<Object> deleted(@PathVariable String userName,@PathVariable int productId) {
        return shoppingCartInfoService.deleted(userName, productId);
    }

    @GetMapping(value = "shoppingCart/selectAll")
    public List<ShoppingCartInfo> selectAll(String userName) {
        return shoppingCartInfoService.selectAll(userName);
    }

    @PostMapping(value = "shopping/commitOrders",consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Object> commitOrders(@RequestBody List<OrderInfo> orderList){

        return shoppingCartInfoService.commitOrders(orderList);
    }



}

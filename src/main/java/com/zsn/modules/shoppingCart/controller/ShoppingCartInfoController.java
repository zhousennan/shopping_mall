package com.zsn.modules.shoppingCart.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.shoppingCart.entities.ShoppingCartInfo;
import com.zsn.modules.shoppingCart.service.Impl.ShoppingCartInfoServiceImpl;
import com.zsn.modules.shoppingCart.service.ShoppingCartInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartInfoController {

@Autowired
    private ShoppingCartInfoServiceImpl shoppingCartInfoService;

@PostMapping(value = "shopping/insert")
public Result<ShoppingCartInfo> insert(@RequestBody ShoppingCartInfo shoppingCartInfo){
  return shoppingCartInfoService.insert( shoppingCartInfo);
}

    public Result<ShoppingCartInfo> update (ShoppingCartInfo shoppingCartInfo){
    return shoppingCartInfoService.update(shoppingCartInfo);
    }

    public Result<Object> deleted (String userName, int productId){
    return shoppingCartInfoService.deleted(userName,productId);
    }

    public PageInfo<ShoppingCartInfo> selectAll(String userName, SearchVo searchVo){
    return shoppingCartInfoService.selectAll(userName,searchVo);
    }


}

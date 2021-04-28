package com.zsn.modules.shoppingCart.service;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.shoppingCart.entities.ShoppingCartInfo;

import java.util.List;

public interface ShoppingCartInfoService {
   public Result<ShoppingCartInfo>  insert(ShoppingCartInfo shoppingCartInfo);

   public Result<ShoppingCartInfo> update (ShoppingCartInfo shoppingCartInfo);

   public Result<Object> deleted (String userName, int productId);

   public PageInfo<ShoppingCartInfo> selectAll(String userName, SearchVo searchVo);
}

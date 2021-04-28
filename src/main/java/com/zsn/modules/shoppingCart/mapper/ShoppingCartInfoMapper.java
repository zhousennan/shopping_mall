package com.zsn.modules.shoppingCart.mapper;

import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.shoppingCart.entities.ShoppingCartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface ShoppingCartInfoMapper {

   public int insert (ShoppingCartInfo  shoppingCartInfo);

   public int update (ShoppingCartInfo shoppingCartInfo);

   public int deleted (String userName, int productId);

   public List<ShoppingCartInfo>  selectAll(SearchVo searchVo);

}

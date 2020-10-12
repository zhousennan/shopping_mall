package com.zsn.modules.account.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.entity.UserInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    PageInfo<Product> getProductList(SearchVo searchVo);

    Result<Product> insertProduct(Product product);

    Result<Object> deleteProduct(int productId);

    Result<Product> updateProduct(Product product);

    Product getProductByProductName(String productName);

    Product getProductByProductId(int productId);

    public Result<String> uploadUserImg(MultipartFile file);
}

package com.zsn.modules.account.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "api")
@Slf4j
public class productController {
    @Autowired
    ProductService productService;

    /**
     * 查询product
     * 127.0.0.1:8080/api/product/1 ---- get
     */
    @GetMapping(value = "product/{productId}")
    public Product getProductByProductId(@PathVariable int productId) {
        return productService.getProductByProductId(productId);
    }

    /**
     * 查询所有product
     * 127.0.0.1:8080/api/products ---- post
     * {"currentPage":"1","pageSize":"5"}
     */
    @PostMapping(value = "products", consumes = MediaType.APPLICATION_JSON_VALUE)
    public PageInfo<Product> getProductList(@RequestBody SearchVo searchVo) {
        return productService.getProductList(searchVo);
    }

    /**
     * 插入product
     * 127.0.0.1:8080/api/product ---- post
     */
    @PostMapping(value = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Product> insertProduct(@RequestBody Product product) {

        log.info("====================="+product.getProductMainimage()+"+++++++++");
        return productService.insertProduct(product);
    }

    /**
     * 删除product
     * 127.0.0.1:8080/api/product/2 ---- deleted
     */
    @DeleteMapping(value = "product/{productId}")
    public Result<Object> deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }

    /**
     * 修改product
     * 127.0.0.1:8080/api/product ---- put
     */
    @PutMapping(value = "product", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Result<Product> updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    @PostMapping(value = "profile")
    public String profile(String image) {
        return image;
    }

    @PostMapping(value = "productImage", consumes = "multipart/form-data")
    public Result<String> uploadFile(@RequestParam MultipartFile file) {
        return productService.uploadUserImg(file);
    }

    @PutMapping(value = "profile", consumes = "application/json")
    public Result<Product> updateUserProfile(@RequestBody Product product) {
        // System.out.println(product);
        productService.insertProduct(product);
        return null;
    }


}

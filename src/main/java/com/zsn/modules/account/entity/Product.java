package com.zsn.modules.account.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * (Product)实体类
 *
 * @author makejava
 * @since 2020-09-05 15:23:08
 */
public class Product implements Serializable {
    private static final long serialVersionUID = -93541174339272398L;
    /**
    * 商品id
    */
    private Integer productId;
    /**
    * 商品名称
    */
    private String productName;
    /**
    * 商品副标题
    */
    private String productTitle;
    /**
    * 产品主图名称
    */
    private String productMainimage;
    /**
    * 商品详情
    */
    private String productDetail;
    /**
    * 商品品牌
    */
    private String productBrand;
    /**
    * 价格,单位-元保留两位小数
    */
    private Double productPrice;
    /**
    * 库存数量
    */
    private Integer productStock;
    /**
    * 商品状态.1-在售 2-下架
    */
    private Integer productStatus;
    /**
    * 上架时间
    */
    private String productCreatetime;
    
    private String productType;


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductMainimage() {
        return productMainimage;
    }

    public void setProductMainimage(String productMainimage) {
        this.productMainimage = productMainimage;
    }

    public Object getProductDetail() {
        return productDetail;
    }


    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductStock() {
        return productStock;
    }

    public void setProductStock(Integer productStock) {
        this.productStock = productStock;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Object getProductCreatetime() {
        return productCreatetime;
    }

    public void setProductDetail(String productDetail) {
        this.productDetail = productDetail;
    }

    public void setProductCreatetime(String productCreatetime) {
        this.productCreatetime = productCreatetime;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

}
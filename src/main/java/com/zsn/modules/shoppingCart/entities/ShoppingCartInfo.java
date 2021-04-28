package com.zsn.modules.shoppingCart.entities;

import java.io.Serializable;

public class ShoppingCartInfo  implements Serializable {

    private String userName;
    private String productName;
    private int productNumber;
    private float productTotalPrice;
    private String productMainImage;
    private int productId;
    private float productPrice;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public float getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(float productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getProductMainImage() {
        return productMainImage;
    }

    public void setProductMainImage(String productMainImage) {
        this.productMainImage = productMainImage;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCartInfo{" +
                "userName='" + userName + '\'' +
                ", productName='" + productName + '\'' +
                ", productNumber=" + productNumber +
                ", productTotalPrice=" + productTotalPrice +
                ", productMainImage='" + productMainImage + '\'' +
                ", productId=" + productId +
                ", productPrice=" + productPrice +
                '}';
    }
}

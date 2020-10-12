package com.zsn.modules.front.entity;

import java.io.Serializable;

/**
 * (AddressInfo)实体类
 *
 * @author makejava
 * @since 2020-09-22 16:18:09
 */
public class AddressInfo implements Serializable {
    private static final long serialVersionUID = -53349662034903977L;
    /**
    * 地址的id用来区分地址
    */
    private int addressId;
    
    private String address;
    
    private String userName;
    /**
    * 是否为默认地址,1为默认地址,0为非默认地址
    */
    private Integer status;
    /**
    * 联系电话
    */
    private String telPhone;
    /**
    * 接受者姓名
    */
    private String receiverName;


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

}
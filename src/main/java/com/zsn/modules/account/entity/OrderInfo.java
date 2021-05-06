package com.zsn.modules.account.entity;


import java.io.Serializable;

/**
 * (OrderInfo)实体类
 *
 * @author makejava
 * @since 2020-09-10 10:57:26
 */
public class OrderInfo implements Serializable {
    private static final long serialVersionUID = -54213657196934687L;
    /**
     * 订单id
     */
    private Integer orderId;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品价格
     */
    private Double productTotalPrice;
    /**
     * 快递公司
     */
    private String expressDeliveryCompany;
    /**
     * 收货地址
     */
    private String address;
    /**
     * 买家的用户名
     */
    private String userName;
    /**
     * 订单的支付情况：0-->未支付  1-->已支付
     */
    private String orderPaymentStatus;
    /**
     * 交易时间
     */
    private Object tradingTime;
    /**
     * 数量
     */
    private String orderNumber;
    /**
     * 是否评价：0-->未评价 1-->已评价
     */
    private Integer orderStatus;
    /**
     * 产品id
     */
    private Integer orderProductId;
    /**
     * 0未发货1发货
     */
    private Integer orderDeliverGoodsStatus;
    /*
     * 收货人电话
     * */
    private String userPhone;
    /*
     * 收货人姓名
     * */
    private String consignee;
    /*
     *删除的状态 1表示展示 0 不展示；
     */
    private String deletedStatus;
    /*
     * 快递单号
     *
     * */

    private String imageMain;

    public String getImageMain() {
        return imageMain;
    }

    public void setImageMain(String imageMain) {
        this.imageMain = imageMain;
    }

    private String courierNumber;

    private Integer refundStatus;

    private String days;

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    private String count;
    private String countPays;
    private String countNoPays;

    public String getCountPays() {
        return countPays;
    }

    public void setCountPays(String countPays) {
        this.countPays = countPays;
    }

    public String getCountNoPays() {
        return countNoPays;
    }

    public void setCountNoPays(String countNoPays) {
        this.countNoPays = countNoPays;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber;
    }

    public String getDeletedStatus() {
        return deletedStatus;
    }

    public void setDeletedStatus(String deletedStatus) {
        this.deletedStatus = deletedStatus;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Double getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(Double productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    public String getExpressDeliveryCompany() {
        return expressDeliveryCompany;
    }

    public void setExpressDeliveryCompany(String expressDeliveryCompany) {
        this.expressDeliveryCompany = expressDeliveryCompany;
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

    public String getOrderPaymentStatus() {
        return orderPaymentStatus;
    }

    public void setOrderPaymentStatus(String orderPaymentStatus) {
        this.orderPaymentStatus = orderPaymentStatus;
    }

    public Object getTradingTime() {
        return tradingTime;
    }

    public void setTradingTime(Object tradingTime) {
        this.tradingTime = tradingTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public Integer getOrderDeliverGoodsStatus() {
        return orderDeliverGoodsStatus;
    }

    public void setOrderDeliverGoodsStatus(Integer orderDeliverGoodsStatus) {
        this.orderDeliverGoodsStatus = orderDeliverGoodsStatus;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Override
    public String toString() {
        return "OrderInfo{" +
                "orderId=" + orderId +
                ", productName='" + productName + '\'' +
                ", productTotalPrice=" + productTotalPrice +
                ", expressDeliveryCompany='" + expressDeliveryCompany + '\'' +
                ", address='" + address + '\'' +
                ", userName='" + userName + '\'' +
                ", orderPaymentStatus='" + orderPaymentStatus + '\'' +
                ", tradingTime=" + tradingTime +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderProductId=" + orderProductId +
                ", orderDeliverGoodsStatus=" + orderDeliverGoodsStatus +
                ", userPhone='" + userPhone + '\'' +
                ", consignee='" + consignee + '\'' +
                ", deletedStatus='" + deletedStatus + '\'' +
                ", imageMain='" + imageMain + '\'' +
                ", courierNumber='" + courierNumber + '\'' +
                ", refundStatus=" + refundStatus +
                ", days='" + days + '\'' +
                ", count='" + count + '\'' +
                ", countPays='" + countPays + '\'' +
                ", countNoPays='" + countNoPays + '\'' +
                '}';
    }
}
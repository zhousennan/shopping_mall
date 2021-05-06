package com.zsn.modules.front.entity;

public class IndexInfo {

    private int productSum;
    private int brandSum;
    //代发货订单  已完成订单 未完成订单 待处理订单 待退款订单   待支付


    public int getProductSum() {
        return productSum;
    }

    public void setProductSum(int productSum) {
        this.productSum = productSum;
    }

    public int getBrandSum() {
        return brandSum;
    }

    public void setBrandSum(int brandSum) {
        this.brandSum = brandSum;
    }
}

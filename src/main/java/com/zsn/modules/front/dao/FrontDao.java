package com.zsn.modules.front.dao;

import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.List;

@Mapper
@Repository
public interface FrontDao {

    @Select("select * from product ORDER BY  RAND() LIMIT 6")
    List<Product> hotProduct();

    @Select("select * from product where product_type='男装' ORDER BY  RAND() LIMIT 8")
    List<Product> manProductList();

    @Select("select * from product where product_type='女装' ORDER BY  RAND() LIMIT 8")
    List<Product> womanProductList();

    @Select("select * from product where product_type='童装' ORDER BY  RAND() LIMIT 8")
    List<Product> childProductList();

    @Select("select * from product where product_id=#{id}")
    Product getProductById(int id);

    @Insert("insert into order_info   (product_name,product_total_price,order_number,order_product_id,user_name,order_payment_status,trading_time,image_main,express_delivery_company,deleted_status,order_deliver_goods_status,order_status,order_id) values " +
            "(#{productName},#{productTotalPrice},#{orderNumber},#{orderProductId},#{userName},#{orderPaymentStatus},#{tradingTime},#{imageMain},#{expressDeliveryCompany},#{deletedStatus},#{orderDeliverGoodsStatus},#{orderStatus},#{orderId})")
    void insertOrderInfo(OrderInfo orderInfo);

    @Select("select * from order_info where order_payment_status='0' and user_name=#{userName} ")
    List<OrderInfo> initPayPage(String userName);

    @Select("select count from user_info where user_name=#{userName}")
    int getUserInfoAccountByUserName(String userName);

    @Update("update user_info set count=count-#{payMoney} where user_name=#{userName} ")
    void updataUserMoney(String userName, int payMoney);

    @Update("update order_info set order_payment_status=1 where order_payment_status=0 and user_name=#{userName}")
    void updateOrderStatuePay(String userName);
}

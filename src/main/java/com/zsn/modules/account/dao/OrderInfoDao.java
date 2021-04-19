package com.zsn.modules.account.dao;

import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderInfoDao {

    @Select("<script>" +
            "select * from order_info "
            + "<where>" +
            "deleted_status=1 "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (order_id like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by order_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<OrderInfo> getOrderInfoList(SearchVo searchVo);


//    @Insert("insert into product (user_name,nick_name,real_name," +
//            "birthday,tel_phone,email,address,grade,password) values (#{userName},#{nickName}," +
//            "#{realName},#{birthday},#{telPhone},#{email},#{address},#{grade},#{password})")
//    void insertOrder(OrderInfo orderInfo);

    @Delete("update order_info set deleted_status=0 where order_id = #{orderId}")
    void deletedOrderInfo(int orderId);

    @Update("update order_info set address=#{address},user_phone=#{userPhone},consignee=#{consignee},express_delivery_company=#{expressDeliveryCompany}" +
            " where order_id=#{orderId}")
    void updateProduct(OrderInfo orderInfo);

    @Select("select * from order_info where order_id=#{orderId}")
    OrderInfo getOrderInfo(int orderId);

    @Update("update order_info set courier_number=#{courierNumber},order_deliver_goods_status=1 " +
            " where order_id=#{orderId} and order_deliver_goods_status=0")
    void saveCourierNumber(OrderInfo orderInfo);

    //查近七天的订单量
    @Select("select a.days,IFNULL(b.count,0) as count\n" +
            "from (\n" +
            "    SELECT curdate() as days\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 1 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 2 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 3 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 4 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 5 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 6 day) as click_date\n" +
            ") a left join (\n" +
            "\tSELECT DATE_FORMAT( trading_time, '%Y-%m-%d' ) days, count(*) count FROM ( SELECT * FROM order_info\n" +
            "            WHERE DATE_SUB( CURDATE(), INTERVAL 7 DAY ) <= date( trading_time) ) as days GROUP BY days\n" +
            ") b on a.days = b.days ORDER BY a.days\n" +
            "\n")
    List<OrderInfo> getTransationData();

    //查询近7天已经支付的订单量
    @Select("select a.days,IFNULL(b.count,0) as countPays\n" +
            "from (\n" +
            "    SELECT curdate() as days\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 1 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 2 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 3 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 4 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 5 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 6 day) as click_date\n" +
            ") a left join (\n" +
            "\tSELECT DATE_FORMAT( trading_time, '%Y-%m-%d' ) days, count(*) count FROM ( SELECT * FROM order_info\n" +
            "            WHERE DATE_SUB( CURDATE(), INTERVAL 7 DAY ) <= date( trading_time) and order_payment_status=1) as days GROUP BY days\n" +
            ") b on a.days = b.days ORDER BY a.days\n" +
            "\n")
    List<OrderInfo> getPayOrders();

    @Select("select a.days,IFNULL(b.count,0) as countNoPays\n" +
            "from (\n" +
            "    SELECT curdate() as days\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 1 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 2 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 3 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 4 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 5 day) as click_date\n" +
            "    union all\n" +
            "    SELECT date_sub(curdate(), interval 6 day) as click_date\n" +
            ") a left join (\n" +
            "\tSELECT DATE_FORMAT( trading_time, '%Y-%m-%d' ) days, count(*) count FROM ( SELECT * FROM order_info\n" +
            "            WHERE DATE_SUB( CURDATE(), INTERVAL 7 DAY ) <= date( trading_time) and order_payment_status=0) as days GROUP BY days\n" +
            ") b on a.days = b.days ORDER BY a.days\n" +
            "\n")
    List<OrderInfo> getNoPayOrders();

    //订单总数
    @Select("select count(*) from order_info")
    int getInfoTotal();

    //成交的钱
    @Select("select SUM(product_total_price) from order_info where order_payment_status=1 and refund_status=1")
    Double getPriceAll();

    //完成的订单，已评价代表完成
    @Select("select count(*) from order_info where order_status=1")
    int getSuccessInfo();

    //交易失败数量
    @Select("select count(*) from order_info where refund_status=-1")
    int getFailTotal();

    //退款的钱
    @Select("select sum(product_total_price)  from order_info where refund_status=-1")
    Double getRefundMoney();

}

package com.zsn.modules.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.dao.OrderInfoDao;
import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    OrderInfoDao orderInfoDao;

     /*获取所有订单，对订单进行查询并分页*/
    @Override
    public PageInfo<OrderInfo> getOrderInfoList(SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<OrderInfo>(Optional.ofNullable(orderInfoDao.getOrderInfoList(searchVo)).
                orElse(Collections.emptyList()));
    }
    /*根据orderId进行删除*/
    @Override
    public Result<Object> deletedOrderInfo(int orderId) {
        orderInfoDao.deletedOrderInfo(orderId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功");
    }
    /*修改订单*/
    @Override
    public Result<OrderInfo> updateProduct(OrderInfo orderInfo) {
        orderInfoDao.updateProduct(orderInfo);
        return new Result<OrderInfo>(Result.ResultStatus.SUCCESS.status, "修改成功");
    }
    /*获取订单，根据订单orderId*/
    @Override
    public OrderInfo getOrderInfo(int orderId) {
        return orderInfoDao.getOrderInfo(orderId);
    }
    @Override
    public Result<OrderInfo> saveCourierNumber(OrderInfo orderInfo) {
        orderInfoDao.saveCourierNumber(orderInfo);
        return new Result<OrderInfo>(Result.ResultStatus.SUCCESS.status, "发货成功");
    }
    @Override
    public List<List<String>> getTransaionData() {
        List<List<String>> list = new ArrayList();
        List<String> days = new ArrayList<>();
        //总订单 //支付的数量
        List<String> counts = new ArrayList<>();
        List<OrderInfo> orderInfoList = orderInfoDao.getTransationData();
        for (OrderInfo orderInfo : orderInfoList) {
            days.add(orderInfo.getDays());
            counts.add(orderInfo.getCount());
        }
        list.add(days);
        list.add(counts);
        //支付订单
        List<String> payCounts = new ArrayList<>();
        List<OrderInfo> orderInfoPays = orderInfoDao.getPayOrders();
        for (OrderInfo orderInfoPay : orderInfoPays) {
            payCounts.add(orderInfoPay.getCountPays());
        }
        list.add(payCounts);
        //未支付订单
        List<String> NoPayCounts = new ArrayList<>();
        List<OrderInfo> noPays = orderInfoDao.getNoPayOrders();
        for (OrderInfo noPay : noPays) {
            NoPayCounts.add(noPay.getCountNoPays());
        }
        list.add(NoPayCounts);
        return list;
    }
    @Override
    public List<Object> getInfoData() {
        List<Object> list = new ArrayList<>();
        list.add(orderInfoDao.getPriceAll());
        list.add(orderInfoDao.getInfoTotal());
        list.add(orderInfoDao.getSuccessInfo());
        list.add(orderInfoDao.getFailTotal());
        list.add(orderInfoDao.getRefundMoney());
        return list;
    }
}

package com.zsn.modules.front.service.Impl;

import com.zsn.commons.entity.Result;
import com.zsn.modules.account.dao.BrandDao;
import com.zsn.modules.account.dao.ProductDao;
import com.zsn.modules.account.dao.UserInfoDao;
import com.zsn.modules.account.entity.OrderInfo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.front.dao.FrontDao;
import com.zsn.modules.front.entity.IndexInfo;
import com.zsn.modules.front.service.FrontService;
import com.zsn.utils.OrderIdUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FrontServiceImpl implements FrontService {
    @Autowired
    private FrontDao frontDao;

    @Autowired
    private ProductDao productDao;
    @Autowired
    private BrandDao brandDao;
    @Autowired
    private UserInfoDao userInfoDao;


    @Override
    public List<Product> hotProduct() {
        return Optional.ofNullable(frontDao.hotProduct()).orElse(Collections.emptyList());
    }
    @Override
    public List<Product> manProductList() {
        return Optional.ofNullable(frontDao.manProductList()).orElse(Collections.emptyList());
    }
    @Override
    public List<Product> womanProductList() {
        return Optional.ofNullable(frontDao.womanProductList()).orElse(Collections.emptyList());
    }
    @Override
    public List<Product> childProductList() {
        return Optional.ofNullable(frontDao.childProductList()).orElse(Collections.emptyList());
    }
    @Override
    public Product getProductById(int id) {
        return frontDao.getProductById(id);
    }
    @Override
    public Result<OrderInfo> insertOrderInfo(OrderInfo orderInfo) {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        String orderID=OrderIdUtil.getOrderId();

        orderInfo.setUserName(user.getUserName());
        //未支付
        orderInfo.setOrderPaymentStatus("0");
        //时间
        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        orderInfo.setTradingTime(sdf.format(new Date()));
        orderInfo.setExpressDeliveryCompany("京东快递");
        orderInfo.setDeletedStatus("1");
        orderInfo.setOrderStatus(1);
        orderInfo.setOrderDeliverGoodsStatus(0);
        orderInfo.setAddress("四川省甘孜州康定市姑咱镇四川民族学院");
        orderInfo.setConsignee("周森楠");
        orderInfo.setUserPhone("18381719043");
        //生成订单id
        orderInfo.setOrderId(orderID);
        frontDao.insertOrderInfo(orderInfo);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "立即购买");
    }

    @Override
    public List<OrderInfo> initPayPage() {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return Optional.ofNullable(frontDao.initPayPage(user.getUserName())).orElse(Collections.emptyList());
    }

    @Override
    public int getUserInfoAccountByUserName() {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        return frontDao.getUserInfoAccountByUserName(user.getUserName());
    }


    @Override
    @Transactional
    public Result<Object> payOrder(int payMoney) {
        //1 改变用户的钱   2改变库存 3改变订单状态
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if (user.getCount() < payMoney) {
            return new Result<>(Result.ResultStatus.FAILD.status, "余额不足");
        } else {
            frontDao.updataUserMoney(user.getUserName(), payMoney);
            frontDao.updateOrderStatuePay(user.getUserName());
            return new Result<>(Result.ResultStatus.SUCCESS.status, "支付成功");
        }
    }

    @Override
    public IndexInfo getIndexInfo() {
        IndexInfo indexInfo = new IndexInfo();
        indexInfo.setProductSum(productDao.getAllProducts());
        indexInfo.setBrandSum(brandDao.getAllBrand());
        return indexInfo;
    }

    @Override
    public int pay() {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        UserInfo user1 = userInfoDao.getUserByUserName(user.getUserName());

        return user1.getCount();
    }

    @Override
    public UserInfo getUserInfo() {
        UserInfo user = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        UserInfo user1 = userInfoDao.getUserByUserName(user.getUserName());

        return user1;
    }




}

package com.zsn.modules.shoppingCart.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.entity.UserInfo;
import com.zsn.modules.shoppingCart.entities.ShoppingCartInfo;
import com.zsn.modules.shoppingCart.mapper.ShoppingCartInfoMapper;
import com.zsn.modules.shoppingCart.service.ShoppingCartInfoService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class ShoppingCartInfoServiceImpl implements ShoppingCartInfoService {

    @Resource
     ShoppingCartInfoMapper shoppingCartInfoMapper;
    private String userName =null;

    @Override
    public Result<ShoppingCartInfo> insert(ShoppingCartInfo shoppingCartInfo) {
        UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if (userInfo==null){
            new Result<ShoppingCartInfo>(Result.ResultStatus.FAILD.status,"请登录");
        }

        String userName = userInfo.getUserName();
        System.out.println(userName);
        System.out.println(shoppingCartInfo.getUserName());
        if (userName.equals(shoppingCartInfo.getUserName())){
            shoppingCartInfoMapper.insert(shoppingCartInfo);
            return new Result<ShoppingCartInfo>(Result.ResultStatus.SUCCESS.status,"加入购物车成功");
        }else {
            return new Result<ShoppingCartInfo>(Result.ResultStatus.FAILD.status,"加入购物车失败");
        }
    }

    @Override
    public Result<ShoppingCartInfo> update(ShoppingCartInfo shoppingCartInfo) {
        UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if (userInfo==null){
            new Result<ShoppingCartInfo>(Result.ResultStatus.FAILD.status,"请登录");
        }
          userName = userInfo.getUserName();
        if (userName.equals(shoppingCartInfo.getUserName())){
            shoppingCartInfoMapper.update(shoppingCartInfo);
            return new Result<ShoppingCartInfo>(Result.ResultStatus.SUCCESS.status,"修改成功");
        }else {
            return new Result<ShoppingCartInfo>(Result.ResultStatus.FAILD.status,"修改失败");
        }
    }

    @Override
    public Result<Object> deleted(String userName, int productId) {
        UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if (userInfo==null){
            new Result<ShoppingCartInfo>(Result.ResultStatus.FAILD.status,"请登录");
        }
       userName = userInfo.getUserName();


        if (userName.equals(userName)){
            shoppingCartInfoMapper.deleted(userName,productId);
            return new Result(Result.ResultStatus.SUCCESS.status,"删除成功");
        }else {
            return new Result(Result.ResultStatus.FAILD.status,"删除失败");
        }

    }

    @Override
    public List<ShoppingCartInfo> selectAll(String userName) {
        UserInfo userInfo = (UserInfo)SecurityUtils.getSubject().getPrincipal();
        if (userInfo==null){
            new Result<ShoppingCartInfo>(Result.ResultStatus.FAILD.status,"请登录");
        }
        userName = userInfo.getUserName();
        if (userName.equals(userName)){

        return shoppingCartInfoMapper.selectAll();
    }
    return null;
    }


}

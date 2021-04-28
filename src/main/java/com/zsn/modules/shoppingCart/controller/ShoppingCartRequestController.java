package com.zsn.modules.shoppingCart.controller;

import com.zsn.modules.account.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartRequestController {

    @GetMapping(value = "goCartPage")
    public String goCartPage(String userName) {
        UserInfo userInfo = (UserInfo) SecurityUtils.getSubject().getPrincipal();
        if (userInfo.getUserName().equals(userName)) {
            return "frontPage/item/shopCart";
        }else {
            return "frontPage/frontLogin";
        }

    }

}

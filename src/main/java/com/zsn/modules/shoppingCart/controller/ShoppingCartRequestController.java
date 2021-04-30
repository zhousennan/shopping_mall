package com.zsn.modules.shoppingCart.controller;

import com.zsn.modules.account.entity.UserInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShoppingCartRequestController {

    @GetMapping(value = "goCartPage")
    public String goCartPage() {

        return "frontPage/item/shopCart";


    }

}

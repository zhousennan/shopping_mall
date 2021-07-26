package com.zsn.modules.front.controller;

import com.zsn.modules.account.entity.Product;
import com.zsn.modules.front.service.FrontService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "front")
public class FrontController {
    @Autowired
    FrontService frontService;

    @GetMapping(value = "index")
    public String index() {
        return "frontPage/index";
    }

    @GetMapping(value = "itemShow")
    public String itemShow() {
        return "frontPage/item/item_show";
    }

    @GetMapping(value = "shopCart")
    public String shopCart() {
        return "frontPage/item/shopCart";
    }

    @GetMapping(value = "toItem/{id}")
    public String toItem(@PathVariable int id, ModelMap modelMap) {
        modelMap.addAttribute("productId", id);
        return "frontPage/item/item_show";
    }

    @GetMapping(value = "toFrontLogin")
    public String login() {
        return "frontPage/frontLogin";
    }

    @GetMapping(value = "shopCartPay")
    public String shopCartPay() {
        return "frontPage/item/shopCart_pay";
    }

    @GetMapping(value = "addressEdit")
    public String address() {
        return "frontPage/item/addressEdit";
    }

    @GetMapping(value = "toInfo")
    public String goInfo() {
        return "frontPage/udai_setting";
    }

    @GetMapping(value = "treasurer")
    public String treasurer() {
        return "frontPage/udai_treasurer";
    }

    @GetMapping(value = "traditional")
    public String traditional() {
        return "frontPage/udai_article10";
    }

    @GetMapping(value = "article")
    public String article() {
        return "frontPage/udai_article12";
    }

    @GetMapping(value = "refund")
    public String refund() {
        return "frontPage/udai_refund";
    }

    @GetMapping(value = "order")
    public String order() {
        return "frontPage/udai_order";
    }
    @GetMapping(value = "about")
    public String about(){
        return "frontPage/udai_about";
    }


}

package com.zsn.modules.account.controller;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "account")
public class AccountController {


/**
 * @api {Get} /account/login 添加User的接口
 * @apiName 登录
 * @apiGroup login
 * @apiDescription 登录接口
 * @apiParam name null
 * @apiSuccess null
 */
    @GetMapping(value = "login")
    public String login() {
        return "login";
    }
    /*
     * to index.html
     * 127.0.0.1:8080/account/index
     * */

    @GetMapping(value = "index")
    public String toIndex() {
        return "index";
    }

    /*
     * to index_home.html
     * 127.0.0.1:8080/account/index_home
     * */
    @GetMapping(value = "index_home")
    public String index_home() {
        return "index_home";
    }

    @GetMapping(value = "userGrading")
    public String userGrading() {
        return "account/user/userGrading";
    }

    /*
     * to product_list.html
     * 127.0.0.1:8080/account/products
     * */
    @GetMapping(value = "products")
    public String products() {
        return "account/product/product_list";
    }


    /*
     * to user_list.html
     * 127.0.0.1:8080/account/users
     * */
    @GetMapping(value = "users")
    public String users() {
        return "account/user/user_list";
    }
/** 
   * @api {POST} path 接口描述
   * @apiDescription 接口描述
   * @apiGroup AccountController 
   * @apiHeader {String} key=desc
   * @apiParam {type} name desc
   *
   * @apiParamExample {json} 请求示例:
   * {
   *   
   * }
   * @apiSuccessExample {json} 成功响应:
   * HTTP/1.1 200 OK
   * {
   *   "code":"0",
   *    "desc":"success",
   *    "data":{
   *       
   *     }
   * }
   * @apiVersion 1.0.5
   */ 
    public String t(){
        return "";
    }
    @GetMapping(value = "addProduct")
    public String addProduct() {
        return "account/product/addProduct";
    }

    @GetMapping(value = "orderList")
    public String orderList() {
        return "account/order/orderList";
    }

    @GetMapping(value = "brandList")
    public String brand() {
        return "account/brand/brand_list";
    }

    @GetMapping(value = "brandData")
    public String brandData() {
        return "account/brand/brandData";
    }

    @GetMapping(value = "transation")
    public String goTransation() {
        return "account/order/transation";
    }



    @GetMapping(value = "roles")
    public String roleList() {
        return "account/role/roleList";
    }

    @GetMapping(value = "Admins")
    public String adminList() {
        return "account/role/adminList";
    }
}

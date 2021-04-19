package com.zsn.modules.account.controller;

import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Brand;
import com.zsn.modules.account.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api")
public class BrandController {
    @Autowired
    BrandService brandService;

    /*
     * 127.0.0.1:8080/api/brands  post
     *  {"currentPage":"1","pageSize":"5"}
     * */
    @PostMapping(value = "brands", consumes = MediaType.APPLICATION_JSON_VALUE)
    PageInfo<Brand> getBrandList(@RequestBody SearchVo searchVo) {
        return brandService.getBrandList(searchVo);
    }

    /*
     * 127.0.0.1:8080/api/brand  post
     * */
    @PostMapping(value = "brand", consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<Brand> insertOrder(@RequestBody Brand brand) {
        return brandService.insertOrder(brand);
    }

    /*
     * 127.0.0.1:8080/api/brand/  post
     * */
    @DeleteMapping(value = "brand/{brandId}")
    Result<Object> deletedBrand(@PathVariable int brandId) {
        return brandService.deletedBrand(brandId);
    }

    /*
     * 127.0.0.1:8080/api/brand/  put
     * */
    @PutMapping(value = "brand", consumes = MediaType.APPLICATION_JSON_VALUE)
    Result<Brand> updateBrand(@RequestBody Brand brand) {
        return brandService.updateBrand(brand);
    }

    @GetMapping(value = "brand/{brandId}")
    Brand getBrand(@PathVariable int brandId) {
        return brandService.getBrand(brandId);
    }


    @PostMapping(value = "brandDate")
    List<List<String>> getBrandDate() {
        return brandService.getBrandDate();
    }

    @PostMapping(value = "brandPieChart")
    List<List<Object>> getBrandPieChartData() {
        return brandService.getBrandPieChartData();
    }

    @GetMapping(value = "brands")
    List<Brand> brandList() {
        return brandService.getBrands();
    }
}

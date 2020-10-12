package com.zsn.modules.account.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Brand;
import com.zsn.modules.account.entity.OrderInfo;

import java.util.List;

public interface BrandService {

    PageInfo<Brand> getBrandList(SearchVo searchVo);

    Result<Brand> insertOrder(Brand brand);

    Result<Object> deletedBrand(int brandId);

    Result<Brand> updateBrand(Brand brand);

    Brand getBrand(int brand);

    List<List<String>> getBrandDate();

    List<List<Object>> getBrandPieChartData();

    List<Brand> getBrands();
}

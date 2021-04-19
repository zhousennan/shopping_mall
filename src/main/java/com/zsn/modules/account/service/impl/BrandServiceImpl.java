package com.zsn.modules.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.dao.BrandDao;
import com.zsn.modules.account.entity.Brand;
import com.zsn.modules.account.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
     BrandDao brandDao;
    /*获取品牌列表并进行分页*/
    @Override
    public PageInfo<Brand> getBrandList(SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<>(Optional.ofNullable(brandDao.getBrandList(searchVo)).orElse(Collections.emptyList()));
    }
    /*新增品牌*/
    @Override
    public Result<Brand> insertOrder(Brand brand) {
        brandDao.insertOrder(brand);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "插入成功");
    }
    /*更加品牌id进行删除*/
    @Override
    public Result<Object> deletedBrand(int brandId) {
        brandDao.deletedBrand(brandId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功");
    }
    /*品牌的修改*/
    @Override
    public Result<Brand> updateBrand(Brand brand) {
        brandDao.updateBrand(brand);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "修改成功");
    }
   /*根据品牌id进行查询*/
    @Override
    public Brand getBrand(int brandId) {
        return brandDao.getBrand(brandId);
    }
    /*echat图表进行的一个数据封装*/
    @Override
    public List<List<String>> getBrandDate() {
        List<List<String>> lists = new ArrayList<>();
        List<Brand> brandProductCount = brandDao.getBrandProductCount();
        List<String> brandNames = new ArrayList<>();
        List<String> brandCount = new ArrayList<>();
        for (Brand brand : brandProductCount) {
            brandNames.add(brand.getBrandName());
            brandCount.add(brand.getCount() + "");
        }
        lists.add(brandNames);
        lists.add(brandCount);

        return lists;
    }
    /*echat图表进行的一个数据封装*/
    @Override
    public List<List<Object>> getBrandPieChartData() {
        List<List<Object>> lists = new ArrayList<>();
        List<Brand> brandProductCount = brandDao.getBrandProductCount();
        List<Object> brandNames = new ArrayList<>();
        List<Object> brandMap = new ArrayList<>();
        for (Brand brand : brandProductCount) {
            brandNames.add(brand.getBrandName());
            Map<String, Object> map = new HashMap<>();
            map.put("name", brand.getBrandName());
            map.put("value", brand.getCount());
            brandMap.add(map);
        }
        lists.add(brandNames);
        lists.add(brandMap);
        return lists;
    }
    @Override
    public List<Brand> getBrands() {
        return brandDao.getBrands();
    }
}

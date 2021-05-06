package com.zsn.modules.account.dao;

import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Brand;
import com.zsn.modules.account.entity.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BrandDao {

    @Select("<script>" +
            "select * from brand "
            + "<where>"
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (brand_id like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by brand_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<Brand> getBrandList(SearchVo searchVo);

    @Insert("insert into brand (brand_description,brand_name) values (#{brandDescription},#{brandName})  ")
    void insertOrder(Brand brand);

    @Delete("delete from brand   where brand_id = #{brandId}")
    void deletedBrand(int brandId);

    @Update("update brand set brand_name=#{brandName}, brand_description=#{brandDescription}" +
            " where brand_id=#{brandId}")
    void updateBrand(Brand brand);

    @Select("select * from brand where brand_id=#{brandId}")
    Brand getBrand(int brandId);

    @Select("select product_brand as brandName , count(*) as count from product group by product_brand")
    List<Brand> getBrandProductCount();

    @Select("select product_brand as brandName , count(*) as count from product group by product_brand")
    List<Brand> getBrandPieChartData();

    @Select("select * from brand ")
    List<Brand> getBrands();

    @Select("select count(*) from brand")
    int getAllBrand();
}

package com.zsn.modules.account.dao;

import com.zsn.commons.entity.SearchVo;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ProductDao {

    @Select("<script>" +
            "select *   from product "
            + "<where> "
            + "<if test='keyWord != \"\" and keyWord != null'>"
            + " and (product_name like '%${keyWord}%') "
            + "</if>"
            + "</where>"
            + "<choose>"
            + "<when test='orderBy != \"\" and orderBy != null'>"
            + " order by ${orderBy} ${sort}"
            + "</when>"
            + "<otherwise>"
            + " order by product_id desc"
            + "</otherwise>"
            + "</choose>"
            + "</script>")
    List<Product> getProductList(SearchVo searchVo);

    @Insert("insert into product (product_name,product_title,product_price," +
            "product_stock,product_type,product_brand,product_detail,product_mainimage)" +
            " values (#{productName},#{productTitle}," +
            "#{productPrice},#{productStock},#{productType},#{productBrand},#{productDetail},#{productMainimage})")
    void insertProduct(Product product);

    @Delete("delete from product where product_id = #{productId}")
    void deleteProduct(int productId);

    @Update("update product set product_name=#{productName},product_title=#{productTitle}," +
            "product_detail=#{productDetail},product_price=#{productPrice}," +
            "product_stock=#{productStock}  where product_Id=#{productId}")
    void updateProduct(Product product);

    @Select("select * from product where product_name=#{productName} ")
    Product getProductByProductName(String productName);

    @Select("select * from product where product_Id=#{productId}")
    Product getProductByProductId(int productId);

    @Select("select count(*) from product")
    int getAllProducts();
}

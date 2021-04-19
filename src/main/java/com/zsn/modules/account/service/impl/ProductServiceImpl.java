package com.zsn.modules.account.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zsn.commons.entity.Result;
import com.zsn.commons.entity.SearchVo;
import com.zsn.config.ResourceConfigBean;
import com.zsn.modules.account.dao.ProductDao;
import com.zsn.modules.account.entity.Product;
import com.zsn.modules.account.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;
    @Autowired
    ResourceConfigBean resourceConfigBean;

    @Override
    public PageInfo<Product> getProductList(SearchVo searchVo) {
        PageHelper.startPage(searchVo.getCurrentPage(), searchVo.getPageSize());
        return new PageInfo<Product>(Optional.ofNullable(productDao.getProductList(searchVo)).
                orElse(Collections.emptyList()));
    }


    @Override
    public Result<Object> deleteProduct(int productId) {
        productDao.deleteProduct(productId);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "删除成功");
    }

    @Override
    public Result<Product> updateProduct(Product product) {
        productDao.updateProduct(product);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "修改成功");
    }

    @Override
    public Product getProductByProductName(String productName) {
        return productDao.getProductByProductName(productName);

    }

    @Override
    public Product getProductByProductId(int productId) {
        return productDao.getProductByProductId(productId);
    }

    public Result<String> uploadUserImg(MultipartFile file) {
        if (file.isEmpty()) {
            return new Result<String>(
                    Result.ResultStatus.FAILD.status, "Please select img.");
        }
        String relativePath = "";
        String destFilePath = "";
        try {
            String osName = System.getProperty("os.name");
            if (osName.toLowerCase().startsWith("win")) {
                destFilePath = resourceConfigBean.getLocationPathForWindows() +
                        file.getOriginalFilename();
            } else {
                destFilePath = resourceConfigBean.getLocationPathForLinux()
                        + file.getOriginalFilename();
            }
            relativePath = resourceConfigBean.getRelativePath() +
                    file.getOriginalFilename();
            File destFile = new File(destFilePath);
            file.transferTo(destFile);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result<String>(
                    Result.ResultStatus.FAILD.status, "Upload failed.");
        }

        return new Result<String>(
                Result.ResultStatus.SUCCESS.status, "Upload success.", relativePath);
    }

    @Override
    public Result<Product> insertProduct(Product product) {
        productDao.insertProduct(product);
        return new Result<>(Result.ResultStatus.SUCCESS.status, "新增成功");
    }
}

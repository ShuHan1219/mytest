package com.bjpowernode.service.impl;

import com.bjpowernode.dao.ProductDao;
import com.bjpowernode.pojo.Product;
import com.bjpowernode.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    public void save(Product product) {
        //System.out.println(username);
        productDao.save(product);
    }

    public List queryList() {
        return productDao.queryList();
    }
}

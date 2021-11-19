package com.bjpowernode.dao.impl;

import com.bjpowernode.dao.ProductDao;
import com.bjpowernode.pojo.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    private QueryRunner qr;

    public void setQr(QueryRunner qr) {
        this.qr = qr;
    }

    public void save(Product product) {
        String sql = "insert into product values(?,?,?,?,?)";
        try {
            qr.update(sql, product.getId(), product.getName(), product.getPrice(), product.getNum(), product.getDescription());
        } catch (SQLException e) {
            e.printStackTrace(); // 打印异常

            // 调用者可以捕获到异常，以便进行事务处理
            throw new RuntimeException(e);
        }
    }

    public List queryList() {
        String sql = "select * from product";
        try {
            return qr.query(sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}

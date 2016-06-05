package com.tshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tshop.dao.ProductMapper;
import com.tshop.service.ProductService;
import com.tshop.entity.Product;
import com.tshop.page.*;

import java.util.List;

/**
 * author: Han, Tixiang
 * createDate: 2016-06-05
 */

@Service("productService")
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    public int updateProduct(Product product) {
        return productMapper.updateProduct(product);
    }

    public int updateProductBySelective(Product product) {
        return productMapper.updateProductBySelective(product);
    }

    public int deleteProductById(Object id) {
        return productMapper.deleteProductById(id);
    }

    public int deleteProductByIds(Object ids) {
        return productMapper.deleteProductByIds(ids);
    }

    public Page queryProductForPage(Criteria criteria) {
        PageHelper.newPage(criteria);
        productMapper.queryProductForList(criteria);
        return PageHelper.endPage();
    }

    public int queryProductByCount(Criteria criteria) {
        return productMapper.queryProductByCount(criteria);
    }

    public List queryProductForList(Criteria criteria) {
        return productMapper.queryProductForList(criteria);
    }

    public Product queryProductById(Object id) {
        return productMapper.queryProductById(id);
    }

}

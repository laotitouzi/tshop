package com.tshop.service;

import com.tshop.dao.ProductMapper;
import com.tshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by laot on 2016/5/8.
 */
@Service("productService")
public class ProductService {
    @Autowired
    private ProductMapper productMapper;

    public Product getProduct(String productId) {
        return productMapper.getProduct(productId);
    }

    public List<Product> getHotProducts(){
        return productMapper.getHotProducts();
    }

    public List<Product> getProductsByCategorId(String id){
        return productMapper.getProductListByCategory(id);
    }

    public void insertProduct(Product product){
        productMapper.insertProduct(product);
    }

    public void updateProduct(Product product){
        productMapper.updateProduct(product);
    }
    public List<Product> getProductListByCategory(String categoryId) {
        return productMapper.getProductListByCategory(categoryId);
    }

    public List<Product> searchProductList(String keywords) {
        List<Product> products = new ArrayList<Product>();
        for(String keyword : keywords.split("\\s+")){
            products.addAll(productMapper.searchProductList("%" + keyword.toLowerCase() + "%"));
        }
        return products;
    }
}

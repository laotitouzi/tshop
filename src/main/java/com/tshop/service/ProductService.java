package com.tshop.service;
import com.tshop.entity.Product;
import com.tshop.page.*;
import java.util.List;
/**
* author: Han, Tixiang
* createDate: 2016-06-05
*/

public interface ProductService {

    public void addProduct(Product product);

    public int updateProduct(Product product);

    public int updateProductBySelective(Product product);

    public int deleteProductById(Object id);

    public int deleteProductByIds(Object ids);

    public int queryProductByCount(Criteria criteria);

    public List queryProductForList(Criteria criteria);

    public Product queryProductById(Object id);

    public Page queryProductForPage(Criteria criteria) ;

}

package com.tshop.dao;

import org.springframework.stereotype.Service;
import org.apache.ibatis.annotations.Param;
import com.tshop.entity.Product;
import com.tshop.page.*;
import java.util.List;
import com.tshop.page.Criteria;

/**
 * author: Han, Tixiang
 * createDate: 2016-06-05
 */

@Service("productMapper")
public interface ProductMapper  {

    public void addProduct(Product product);

    public int updateProduct(Product product);

    public int updateProductBySelective(Product product);

    public int deleteProductById(@Param("id") Object id);

    public int deleteProductByIds(@Param("ids") Object ids);

    public int queryProductByCount(Criteria criteria);

    public List queryProductForList(Criteria criteria);

    public Product queryProductById(@Param("id") Object id);

}

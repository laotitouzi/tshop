package com.tshop.dao;
import com.tshop.entity.Product;
import java.util.List;
/**
 * @author  Han, Tixiang
 *
 */
public interface ProductMapper {

  List<Product> getProductListByCategory(String categoryId);

  Product getProduct(String productId);

  List<Product> searchProductList(String keywords);

  void insertProduct(Product product);

  void updateProduct(Product product);

  List<Product> getHotProducts();
}

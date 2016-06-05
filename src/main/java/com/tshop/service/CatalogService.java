package com.tshop.service;

import java.util.ArrayList;
import java.util.List;

import com.tshop.dao.CategoryMapper;
import com.tshop.dao.ItemMapper;
import com.tshop.dao.ProductMapper;
import com.tshop.entity.Category;
import com.tshop.entity.Item;
import com.tshop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Eduardo Macarron
 *
 */
@Service("catelogService")
public class CatalogService {

  @Autowired
  private CategoryMapper categoryMapper;
  @Autowired
  private ItemMapper itemMapper;


  public List<Category> getCategoryList() {
    return categoryMapper.getCategoryList();
  }

  public Category getCategory(String categoryId) {
    return categoryMapper.getCategory(categoryId);
  }

  public List<Item> getItemListByProduct(String productId) {
    return itemMapper.getItemListByProduct(productId);
  }

  public Item getItem(String itemId) {
    return itemMapper.getItem(itemId);
  }

  public boolean isItemInStock(String itemId) {
    return itemMapper.getInventoryQuantity(itemId) > 0;
  }
}
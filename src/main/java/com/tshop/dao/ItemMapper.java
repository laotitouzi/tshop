package com.tshop.dao;

import com.tshop.entity.Item;

import java.util.List;
import java.util.Map;

/**
 * @author Han, Tixiang
 *
 */
public interface ItemMapper {

  void updateInventoryQuantity(Map<String, Object> param);

  int getInventoryQuantity(String itemId);

  List<Item> getItemListByProduct(String productId);

  Item getItem(String itemId);

}

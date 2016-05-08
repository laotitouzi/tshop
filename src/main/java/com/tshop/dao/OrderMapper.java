package com.tshop.dao;

import com.tshop.entity.Order;
import java.util.List;

/**
 * @author Han, Tixiang
 *
 */
public interface OrderMapper {

  List<Order> getOrdersByUsername(String username);

  Order getOrderById(int orderId);
  
  void insertOrder(Order order);
  
  void updateOrderStatus(Order order);

}

package com.tshop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.tshop.dao.ItemMapper;
import com.tshop.dao.LineItemMapper;
import com.tshop.dao.OrderMapper;
import com.tshop.entity.Item;
import com.tshop.entity.LineItem;
import com.tshop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Eduardo Macarron
 *
 */
@Service("orderService")
public class OrderService {

  @Autowired
  private ItemMapper itemMapper;
  @Autowired
  private OrderMapper orderMapper;

  @Autowired
  private LineItemMapper lineItemMapper;

  @Transactional
  public void insertOrder(Order order) {
    order.setOrderId(getNextId());
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      String itemId = lineItem.getItemId();
      Integer increment = new Integer(lineItem.getQuantity());
      Map<String, Object> param = new HashMap<String, Object>(2);
      param.put("itemId", itemId);
      param.put("increment", increment);
      itemMapper.updateInventoryQuantity(param);
    }

    orderMapper.insertOrder(order);

    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItem.setOrderId(order.getOrderId());
      lineItemMapper.insertLineItem(lineItem);
    }
  }

  @Transactional
  public Order getOrder(int orderId) {
    Order order = orderMapper.getOrderById(orderId);
    order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));

    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      Item item = itemMapper.getItem(lineItem.getItemId());
      item.setQuantity(itemMapper.getInventoryQuantity(lineItem.getItemId()));
      lineItem.setItem(item);
    }

    return order;
  }

  public List<Order> getOrdersByUsername(String username) {
    return orderMapper.getOrdersByUsername(username);
  }

  public String getNextId( ){
    return UUID.randomUUID().toString();
  }

}

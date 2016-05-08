package com.tshop.dao;
import com.tshop.entity.LineItem;
import java.util.List;

/**
 * @author Eduardo Macarron
 *
 */
public interface LineItemMapper {

  List<LineItem> getLineItemsByOrderId(int orderId);

  void insertLineItem(LineItem lineItem);

}

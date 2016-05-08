package com.tshop.entity;

import com.tshop.utils.OrderStatus;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author Han, Tixiang
 */

public class Order implements Serializable {

    private static final long serialVersionUID = 6321792448424424931L;

    private String orderId;
    private String username;
    private Date createDate;
    private String shipAddress;
    private String shipCountry;
    private String shipState;
    private String shipCity;
    private String shipZip;
    private String userPhone;
    private BigDecimal totalPrice;
    private String payType; //微信、支付宝。银行卡、账户余额等
    private BigDecimal totalBenefit;
    private String status;//已下单，已付款，已取消，已发货，已确认收货
    private List<LineItem> lineItems = new ArrayList<LineItem>();

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setTotalBenefit(BigDecimal totalBenefit) {
        this.totalBenefit = totalBenefit;
    }

    public BigDecimal getTotalBenefit() {

        return totalBenefit;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipState() {
        return shipState;
    }

    public void setShipState(String shipState) {
        this.shipState = shipState;
    }

    public String getShipZip() {
        return shipZip;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public void setShipZip(String shipZip) {
        this.shipZip = shipZip;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public String getPayType() {
        return payType;
    }

    public void initOrder(User user, Cart cart) {
        username = user.getUsername();
        createDate = new Date();
        shipAddress = user.getAddress();
        shipCity = user.getCity();
        shipState = user.getState();
        shipZip = user.getZip();
        shipCountry = user.getCountry();
        totalPrice = cart.getTotalPrice();
        userPhone = user.getPhone();
        status = OrderStatus.NEW.getValue();

        Iterator<CartItem> i = cart.getAllCartItems();
        while (i.hasNext()) {
            CartItem cartItem = (CartItem) i.next();
            addLineItem(cartItem);
        }
    }

    public void addLineItem(CartItem cartItem) {
        LineItem lineItem = new LineItem(lineItems.size() + 1, cartItem);
        addLineItem(lineItem);
    }

    public void addLineItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

}

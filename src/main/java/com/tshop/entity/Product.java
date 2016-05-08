package com.tshop.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Han, Tixiang 2016年5月7日
 */
public class Product implements Serializable {

    private static final long serialVersionUID = -7492639752670189553L;

    private String productId;
    private String categoryId;
    private String productName;
    private BigDecimal price;
    private String description;
    private BigDecimal discount;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId.trim();
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getProductName();
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

}

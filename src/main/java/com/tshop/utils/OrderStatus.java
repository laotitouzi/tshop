package com.tshop.utils;

/**
 * Created by laot on 2016/5/7.
 */
public enum OrderStatus {
    NEW("N"), PAY("P"), CANCEL("C"), DELIVER("D"), FINISH("F");

    private  OrderStatus(String status) {
        this.status = status;
    }

    private String status;

    public String getValue() {
        return status;
    }
}
package com.zc.entity;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/14 15:11
 * @desc
 */
public class Order {
    private Integer orderId;
    private Integer userId;
    private Integer productId;

    public Order() {
    }

    public Order(Integer orderId, Integer userId, Integer productId) {
        this.orderId = orderId;
        this.userId = userId;
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", userId=" + userId +
                ", productId=" + productId +
                '}';
    }
}

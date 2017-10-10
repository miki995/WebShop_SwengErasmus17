package miki.uni.sarajevo.webshop.model;

import java.util.*;

public class Order {

    private Customer customer;
    private Product product;
    private Date orderDate;
    private final int orderNum;
    private int quantity;
    private final float amount;


    public Order(Customer customer, Product product, Date orderDate, int orderNum, int quantity) {
        this.customer = customer;
        this.product = product;
        this.orderDate = orderDate;
        this.orderNum = orderNum;
        this.quantity = quantity;
        this.amount = quantity * product.getPrice();
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getOrderNum() {
        return orderNum;
    }



    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "customer=" + customer +
                ", product=" + product +
                ", orderDate=" + orderDate +
                ", orderNum=" + orderNum +
                ", quantity=" + quantity +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Order && orderNum == ((Order) obj).getOrderNum();
    }
}

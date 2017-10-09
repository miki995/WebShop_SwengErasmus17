package miki.uni.sarajevo.webshop.service;


import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.Order;
import miki.uni.sarajevo.webshop.model.Product;

import java.util.Collection;
import java.util.Date;

/**
 * Created by miki995 on 2017.10.09..
 */
public interface OrderManagerService {

    void createOrder(Customer customer, Product product, Date orderDate, int orderNum, int quantity);


    Collection<Order> listOrders();

}

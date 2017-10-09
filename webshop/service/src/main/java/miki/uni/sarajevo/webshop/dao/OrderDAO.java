package miki.uni.sarajevo.webshop.dao;


import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.CustomerNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.DateNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderAlreadyExsistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderNumNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.PriceNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.Order;
import miki.uni.sarajevo.webshop.model.Product;

import java.util.Collection;
import java.util.Date;

/**
 * Created by miki995 on 2017.10.08..
 */
public interface OrderDAO {

    void createOrder(Order order) throws OrderAlreadyExsistsException;

    void updateOrder(Order order) throws OrderNotFoundException;

    void deleteOrder(Order Order) throws OrderNotFoundException;

    Collection<Order> readOrders();

    Collection<Order> readOrdersByCustomer(Customer customer) throws CustomerNotFoundException;

    Collection<Order> readOrdersByProduct(Product product) throws ProductNotFoundException;

    Collection<Order> readOrdersByDate(Date date) throws DateNotFoundException;

    Order readByOrderNum(int orderNum) throws OrderNumNotFoundException;

}

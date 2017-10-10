package miki.uni.sarajevo.webshop.service.impl;

import miki.uni.sarajevo.webshop.dao.OrderDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.CustomerNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.DateNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderAlreadyExistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderNumNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.Order;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.service.OrderManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class OrderManagerServiceImpl implements OrderManagerService
{


    private static Logger LOG = LogManager.getLogger(OrderManagerServiceImpl.class);
    private OrderDAO orderDAO;

    public OrderManagerServiceImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder(Customer customer, Product product, Date orderDate, int orderNum, int quantity){
        Order order = new Order(customer, product, orderDate, orderNum, quantity);
        try {
            orderDAO.createOrder(order);
        } catch (OrderAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateOrder(Customer customer, Product product, Date orderDate, int orderNum, int quantity){
        Order order = new Order(customer, product, orderDate, orderNum, quantity);
        try {
            orderDAO.updateOrder(order);
        } catch (OrderNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public void deleteOrder(Order order) {
        try {
            orderDAO.deleteOrder(order);
        } catch (OrderNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Order> listOrders() {
        return orderDAO.readOrders();
    }



    public Collection<Order> listOrdersByCustomer(Customer customer) throws CustomerNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getCustomer() == customer){
                result.add(order);
            }
        }
        return result;
    }



    public Collection<Order> readOrdersByProduct(Product product) throws ProductNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getProduct() == product){
                result.add(order);
            }
        }
        return result;
    }

    public Collection<Order> readOrdersByDate(Date date) throws DateNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getOrderDate() == date){
                result.add(order);
            }
        }
        return result;
    }


    public Order readByOrderNum(int orderNum) throws OrderNumNotFoundException {
        return  orderDAO.readByOrderNum(orderNum);
    }
    
}

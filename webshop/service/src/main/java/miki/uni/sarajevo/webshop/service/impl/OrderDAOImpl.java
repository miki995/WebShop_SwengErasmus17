package miki.uni.sarajevo.webshop.service.impl;

import miki.uni.sarajevo.webshop.dao.OrderDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.CustomerNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.PhoneNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.DateNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderAlreadyExsistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderNumNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.PriceNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.Order;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.Availability;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class OrderDAOImpl implements OrderDAO
{


    private static Logger LOG = LogManager.getLogger(OrderDAOImpl.class);
    private OrderDAO orderDAO;

    public OrderDAOImpl(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder(Customer customer, Product product, Date orderDate, int orderNum, int quantity) throws OrderAlreadyExsistsException {
        try {
            orderDAO.createOrder(customer, product, orderDate, orderNum, quantity);
        } catch (OrderAlreadyExsistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateOrder(Customer customer, Product product, Date orderDate, int orderNum, int quantity) throws OrderNotFoundException {
        try {
            orderDAO.updateOrder(customer, product, orderDate, orderNum, quantity);
        } catch (OrderNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public void deleteOrder(Order order) throws OrderNotFoundException {
        try {
            orderDAO.deleteOrder(order);
        } catch (OrderNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Order> readOrders() {
        return orderDAO.readOrders();
    }



    public Collection<Order> readOrdersByCustomer(Customer customer) throws CustomerNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getCustomer().equals(customer)){
                result.add(order);
            }
        }
        return result;
    }



    public Collection<Order> readOrdersByProduct(Product product) throws ProductNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getProduct().equals(product)){
                result.add(order);
            }
        }
        return result;
    }

    public Collection<Order> readOrdersByDate(Date date) throws DateNotFoundException {
        Collection<Order> result = new HashSet<Order>();
        for(Order order : orderDAO.readOrders()){
            if(order.getOrderDate().equals(date)){
                result.add(order);
            }
        }
        return result;
    }


    public Order readByOrderNum(int orderNum) throws OrderNumNotFoundException {
        try {
            return orderDAO.readByOrderNum(orderNum);
        } catch (OrderNumNotFoundException e) {
            LOG.warn(e.getMessage());
        }
        return null;
    }
    
}

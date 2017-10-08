package miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class OrderNotFoundException extends PersistenceException {

    public OrderNotFoundException() {
    }

    public OrderNotFoundException(String message) {
        super(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

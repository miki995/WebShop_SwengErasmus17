package miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class OrderNumNotFoundException extends PersistenceException {

    public OrderNumNotFoundException() {
    }

    public OrderNumNotFoundException(String message) {
        super(message);
    }

    public OrderNumNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

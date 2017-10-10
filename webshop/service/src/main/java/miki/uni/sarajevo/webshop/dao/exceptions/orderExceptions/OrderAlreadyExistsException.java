package miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class OrderAlreadyExistsException extends PersistenceException {

    public OrderAlreadyExistsException() {
    }

    public OrderAlreadyExistsException(String message) {
        super(message);
    }

    public OrderAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

package miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class OrderAlreadyExsistsException extends PersistenceException {

    public OrderAlreadyExsistsException() {
    }

    public OrderAlreadyExsistsException(String message) {
        super(message);
    }

    public OrderAlreadyExsistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

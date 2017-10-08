package miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class DateNotFoundException extends PersistenceException {

    public DateNotFoundException() {
    }

    public DateNotFoundException(String message) {
        super(message);
    }

    public DateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class CustomerAlreadyExistsException extends PersistenceException {

    public CustomerAlreadyExistsException() {
    }

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }

    public CustomerAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

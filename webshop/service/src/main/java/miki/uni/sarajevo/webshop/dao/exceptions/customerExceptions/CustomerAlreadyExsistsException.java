package miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class CustomerAlreadyExsistsException extends PersistenceException {

    public CustomerAlreadyExsistsException() {
    }

    public CustomerAlreadyExsistsException(String message) {
        super(message);
    }

    public CustomerAlreadyExsistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

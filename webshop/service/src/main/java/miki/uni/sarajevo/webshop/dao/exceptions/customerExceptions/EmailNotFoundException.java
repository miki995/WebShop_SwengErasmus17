package miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class EmailNotFoundException extends PersistenceException {

    public EmailNotFoundException() {
    }

    public EmailNotFoundException(String message) {
        super(message);
    }

    public EmailNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

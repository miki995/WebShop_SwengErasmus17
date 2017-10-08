package miki.uni.sarajevo.webshop.dao.exceptions.productExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class NameNotFoundException extends PersistenceException {

    public NameNotFoundException() {
    }

    public NameNotFoundException(String message) {
        super(message);
    }

    public NameNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

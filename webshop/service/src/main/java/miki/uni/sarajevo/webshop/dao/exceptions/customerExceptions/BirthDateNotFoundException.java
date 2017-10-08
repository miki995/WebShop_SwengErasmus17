package miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class BirthDateNotFoundException extends PersistenceException {

    public BirthDateNotFoundException() {
    }

    public BirthDateNotFoundException(String message) {
        super(message);
    }

    public BirthDateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

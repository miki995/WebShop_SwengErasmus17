package miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class PhoneNotFoundException extends PersistenceException {

    public PhoneNotFoundException() {
    }

    public PhoneNotFoundException(String message) {
        super(message);
    }

    public PhoneNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

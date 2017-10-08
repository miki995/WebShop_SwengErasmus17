package miki.uni.sarajevo.webshop.dao.exceptions.productExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class PriceNotFoundException extends PersistenceException {

    public PriceNotFoundException() {
    }

    public PriceNotFoundException(String message) {
        super(message);
    }

    public PriceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

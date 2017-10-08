package miki.uni.sarajevo.webshop.dao.exceptions.productExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class ProductNotFoundException extends PersistenceException {

    public ProductNotFoundException() {
    }

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}

package miki.uni.sarajevo.webshop.dao.exceptions.productExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class ProductAlreadyExistsException extends PersistenceException {

    public ProductAlreadyExistsException() {
    }

    public ProductAlreadyExistsException(String message) {
        super(message);
    }

    public ProductAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

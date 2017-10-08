package miki.uni.sarajevo.webshop.dao.exceptions.productExceptions;


import miki.uni.sarajevo.webshop.dao.exceptions.PersistenceException;

public class ProductAlreadyExsistsException extends PersistenceException {

    public ProductAlreadyExsistsException() {
    }

    public ProductAlreadyExsistsException(String message) {
        super(message);
    }

    public ProductAlreadyExsistsException(String message, Throwable cause) {
        super(message, cause);
    }
}

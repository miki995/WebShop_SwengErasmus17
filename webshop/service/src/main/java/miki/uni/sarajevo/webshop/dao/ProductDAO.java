package miki.uni.sarajevo.webshop.dao;

import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.NameNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.PriceNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductAlreadyExistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.Availability;

import java.util.Collection;

/**
 * Created by miki995 on 2017.10.08..
 */
public interface ProductDAO {

    void createProduct(Product product) throws ProductAlreadyExistsException;

    void updateProduct(Product product) throws ProductNotFoundException;

    void deleteProduct(Product product) throws ProductNotFoundException;

    Collection<Product> readProducts();

    Collection<Product> readProductsByAvailability(Availability available);

    Collection<Product> readProductsByPrice(float price) throws PriceNotFoundException;

    Product readProductByPrice(float price) throws PriceNotFoundException;

    Product readProductByName(String name) throws NameNotFoundException;

}

package miki.uni.sarajevo.webshop.dao;

import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.NameNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.PriceNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductAlreadyExsistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.Availability;

import java.util.Collection;

/**
 * Created by miki995 on 2017.10.08..
 */
public interface ProductDAO {

    void createProduct(String name, String description, float price, Availability available) throws ProductAlreadyExsistsException;

    void updateProduct(String name, String description, float price, Availability available) throws ProductNotFoundException, ProductAlreadyExsistsException;

    void deleteProduct(Product product) throws ProductNotFoundException;

    Collection<Product> readProducts();

    Collection<Product> readProductsByPrice(float price) throws PriceNotFoundException;

    Product readProductByPrice(float price) throws PriceNotFoundException;

    Product findProductByName(String name) throws NameNotFoundException;

    Collection<Product> readProductsByAvailability(Availability available);



}

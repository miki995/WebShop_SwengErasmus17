package miki.uni.sarajevo.webshop.service;

import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.Availability;

import javax.naming.NameNotFoundException;
import java.util.Collection;

/**
 * Created by miki995 on 2017.10.09..
 */
public interface ProductManagerService {

    void createProduct(String name, String description, float price, Availability available);



    Collection<Product> listProducts();

    Collection<Product> listProductsByAvailability(Availability available);



}

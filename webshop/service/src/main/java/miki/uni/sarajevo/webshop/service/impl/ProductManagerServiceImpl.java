package miki.uni.sarajevo.webshop.service.impl;

import miki.uni.sarajevo.webshop.dao.ProductDAO;import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.NameNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.PriceNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductAlreadyExsistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.*;
import miki.uni.sarajevo.webshop.service.ProductManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashSet;


public class ProductManagerServiceImpl implements ProductManagerService
{


    private static Logger LOG = LogManager.getLogger(ProductManagerServiceImpl.class);
    private ProductDAO productDAO;

    public ProductManagerServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void createProduct(String name, String description, float price, Availability available) {
       Product product = new Product(name, description, price, available);
        try {
            productDAO.createProduct(product);
        } catch (ProductAlreadyExsistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateProduct(String name, String description, float price, Availability available) {
        Product product = new Product(name, description, price, available);
        try {
            productDAO.updateProduct(product);
        } catch (ProductNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public void deleteProduct(Product Product){
        try {
            productDAO.deleteProduct(Product);
        } catch (ProductNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Product> listProducts() {
        return productDAO.readProducts();
    }


    public Collection<Product> readProductsByPrice (float price) throws PriceNotFoundException {

        return productDAO.readProductsByPrice(price);
      }

    public Product readProductByPrice(float price) throws PriceNotFoundException {
        return productDAO.readProductByPrice(price);
    }

    public Product findProductByName(String name) throws NameNotFoundException {
        return productDAO.readProductByName(name);
    }

    public Collection<Product> listProductsByAvailability(Availability available) {
        return productDAO.readProductsByAvailability(available);
    }

}

package miki.uni.sarajevo.webshop.service.impl;

import jdk.internal.jline.internal.Log;
import miki.uni.sarajevo.webshop.dao.ProductDAO;import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.NameNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.PriceNotFoundException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductAlreadyExsistsException;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductNotFoundException;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.HashSet;


public class ProductDAOImpl implements ProductDAO
{


    private static Logger LOG = LogManager.getLogger(ProductDAOImpl.class);
    private ProductDAO productDAO;

    public ProductDAOImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void createProduct(String name, String description, float price, Availability available) throws ProductAlreadyExsistsException {
        try {
            productDAO.createProduct(name,description,price,available);
        } catch (ProductAlreadyExsistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateProduct(String name, String description, float price, Availability available) throws ProductAlreadyExsistsException {
        try {
            productDAO.updateProduct(name,description,price,available);
        } catch (ProductNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public void deleteProduct(Product Product) throws ProductNotFoundException {
        try {
            productDAO.deleteProduct(Product);
        } catch (ProductNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Product> readProducts() {
        return productDAO.readProducts();
    }


    public Collection<Product> readProductsByPrice (float price) throws PriceNotFoundException {

        Collection<Product> result = new HashSet<Product>();
            for(Product product : productDAO.readProducts()){
                if(product.getPrice() == price){
                    result.add(product);
                }
            }
            return result;
      }

    public Product readProductByPrice(float price) throws PriceNotFoundException {
       try {
           return productDAO.readProductByPrice(price);
       }
        catch (PriceNotFoundException e){
            LOG.info(e.getMessage());
        }
        return null;
    }

    public Product findProductByName(String name) throws NameNotFoundException {
        try {
            return productDAO.findProductByName(name);
        }
        catch (NameNotFoundException e){
            LOG.info(e.getMessage());
        }
        return null;
    }

    public Collection<Product> readProductsByAvailability(Availability available) {
        Collection<Product> result = new HashSet<Product>();
        for(Product product : productDAO.readProducts()){
            if(product.isAvailable() == Availability.YES){
                result.add(product);
            }
        }
        return result;
    }

}

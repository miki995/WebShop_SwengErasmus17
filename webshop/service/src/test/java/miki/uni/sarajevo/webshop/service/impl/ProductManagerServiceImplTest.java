package miki.uni.sarajevo.webshop.service.impl;


import miki.uni.sarajevo.webshop.dao.ProductDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.productExceptions.ProductAlreadyExistsException;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.service.ProductManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

import static miki.uni.sarajevo.webshop.model.helpClasses.Availability.YES;

/**
 * Created by miki995 on 2017.10.09..
 */
public class ProductManagerServiceImplTest {


    Logger LOG = LogManager.getLogger(ProductManagerServiceImpl.class);
    private ProductManagerService service;

    @Before
    public void  setUp() throws ParseException, ProductAlreadyExistsException {
        ProductDAO productDAO = EasyMock.createMock(ProductDAO.class);

        Product book = new Product(
                "Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                151,
                YES);
        Product laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                2999,
                YES);
        Product iphone = new Product(
                "Apple Iphone X",
                "Best phone ever.",
                2999,
                YES);

        EasyMock.expect(productDAO.readProducts()).andReturn(Arrays.asList(book,laptop));
        productDAO.createProduct(book);
        EasyMock.expectLastCall().andThrow(new ProductAlreadyExistsException("Game of Thrones already already exists!"));
        productDAO.createProduct(iphone);
        EasyMock.replay(productDAO);
        service = new ProductManagerServiceImpl(productDAO);
    }
    @Test
    public void testLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void testListAllProducts() throws ParseException {
        Product book = new Product(
                "Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                150,
                YES);
        Product laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                29299,
                YES);
        Collection<Product> expected = Arrays.asList(book,laptop);
        Collection<Product> actual = service.listProducts();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
    @Test
    public void testListAllProductsByAvailability() throws ParseException {
        Product book = new Product(
                "Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                150,
                YES);
        Product laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                3000,
                YES);

        Collection<Product> expected = Arrays.asList(laptop,book);
        Collection<Product> actual = service.listProductsByAvailability(YES);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }



    @Test
    public void createProductWhichExists() throws ParseException {

        service.createProduct("Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                150,
                YES);
    }
    @Test
    public void createNewProduct() throws ParseException {
        service.createProduct( "Apple Iphone X",
                "Best phone ever.",
                2999,
                YES);
    }
}

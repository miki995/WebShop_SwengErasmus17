package miki.uni.sarajevo.webshop.service.impl;


import miki.uni.sarajevo.webshop.dao.OrderDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.orderExceptions.OrderAlreadyExistsException;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.Order;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.Address;
import miki.uni.sarajevo.webshop.model.helpClasses.City;
import miki.uni.sarajevo.webshop.model.helpClasses.Gender;
import miki.uni.sarajevo.webshop.service.OrderManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;

import static miki.uni.sarajevo.webshop.model.helpClasses.Availability.YES;
import static miki.uni.sarajevo.webshop.model.helpClasses.Country.BOSNIA;

/**
 * Created by miki995 on 2017.10.10..
 */
public class OrderManagerServiceImplTest {


    private Logger LOG = LogManager.getLogger(OrderManagerServiceImpl.class);
    private OrderManagerService service;

    @Before
    public void  setUp() throws ParseException, OrderAlreadyExistsException {
        OrderDAO orderDAO = EasyMock.createMock(OrderDAO.class);

        Address sa = new Address("73000", City.SARAJEVO, BOSNIA);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Customer miroslav = new Customer("Miroslav",
                "Maksimovic",
                Gender.MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        Customer tomo = new Customer("Tomo",
                "Klacar",
                Gender.MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);

        Product book = new Product(
                "Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                150,
                YES);
        Product laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                2999,
                YES);

        Order order1 = new Order(miroslav, laptop, dateFormat.parse("2017-10-05"),1,3);
        Order order2 = new Order(tomo, book, dateFormat.parse("2017-10-06"),2,1);
        Order order3 = new Order(miroslav, laptop, dateFormat.parse("2017-10-06"),3,1);


        EasyMock.expect(orderDAO.readOrders()).andReturn(Arrays.asList(order1,order2));
        orderDAO.createOrder(order1);
        EasyMock.expectLastCall().andThrow(new OrderAlreadyExistsException("Game of Thrones already already exists!"));
        orderDAO.createOrder(order3);
        EasyMock.replay(orderDAO);
        service = new OrderManagerServiceImpl(orderDAO);
    }
    @Test
    public void testLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void testListAllOrders() throws ParseException {

        Address sa = new Address("73000", City.SARAJEVO, BOSNIA);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Customer miroslav = new Customer("Miroslav",
                "Maksimovic",
                Gender.MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        Customer tomo = new Customer("Tomo",
                "Klacar",
                Gender.MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);

        Product book = new Product(
                "Game of Thrones",
                "Nine noble families fight for control over the mythical lands of Westeros.",
                150,
                YES);
        Product laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                2999,
                YES);

        Order order1 = new Order(miroslav, laptop, dateFormat.parse("2017-10-05"),1,3);
        Order order2 = new Order(tomo, book, dateFormat.parse("2017-10-06"),2,1);


        Collection<Order> expected = Arrays.asList(order1,order2);
        Collection<Order> actual = service.listOrders();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }




    @Test
    public void createOrderWhichExists() throws ParseException {
        Address sa = new Address("73000", City.SARAJEVO, BOSNIA);
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Customer miroslav = new Customer("Miroslav",
                "Maksimovic",
                Gender.MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        Product laptop = new Product(
                "Apple MacBook Pro",
                "Intel i7,16GB RAM, NVIDIA GTX1080.",
                2999,
                YES);
        service.createOrder(miroslav, laptop, dateFormat.parse("2017-10-05"),1,3);
    }

}

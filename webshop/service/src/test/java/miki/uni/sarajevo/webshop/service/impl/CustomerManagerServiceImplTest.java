package miki.uni.sarajevo.webshop.service.impl;


import miki.uni.sarajevo.webshop.dao.CustomerDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.CustomerAlreadyExistsException;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.helpClasses.Address;
import miki.uni.sarajevo.webshop.service.CustomerManagerService;
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

import static miki.uni.sarajevo.webshop.model.helpClasses.City.SARAJEVO;
import static miki.uni.sarajevo.webshop.model.helpClasses.City.TARGU_MURES;
import static miki.uni.sarajevo.webshop.model.helpClasses.Country.BOSNIA;
import static miki.uni.sarajevo.webshop.model.helpClasses.Country.ROMANIA;
import static miki.uni.sarajevo.webshop.model.helpClasses.Gender.FEMALE;
import static miki.uni.sarajevo.webshop.model.helpClasses.Gender.MALE;

/**
 * Unit test for customer
 */
public class CustomerManagerServiceImplTest {
    private Address sa;
    private Address tm;

    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Logger LOG = LogManager.getLogger(CustomerManagerServiceImpl.class);
    private CustomerManagerService service;

    @Before
    public void  setUp() throws ParseException, CustomerAlreadyExistsException {
        CustomerDAO customerDAO = EasyMock.createMock(CustomerDAO.class);

         sa = new Address("73000", SARAJEVO, BOSNIA);
         tm = new Address("6593", TARGU_MURES, ROMANIA);

        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);

        Customer aki = new Customer(
                "Albert",
                "Akos",
                FEMALE,
                dateFormat.parse("1996-07-05"),
                "albertakos@gmail.com",
                "066/224-415",
                tm);

        EasyMock.expect(customerDAO.readCustomers()).andReturn(Arrays.asList(miroslav,tomo));
        customerDAO.createCustomer(miroslav);
        EasyMock.expectLastCall().andThrow(new CustomerAlreadyExistsException("Miroslav Maksimovic already exists!"));
        customerDAO.createCustomer(aki);
        EasyMock.replay(customerDAO);
        service = new CustomerManagerServiceImpl(customerDAO);
    }
    @Test
    public void testLogging(){
        LOG.info("info");
        LOG.warn("warning");
        LOG.error("error");
        LOG.fatal("fatal");
    }

    @Test
    public void testListAllCustomers() throws ParseException {

        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "066/140-150",
                sa);
        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);
        Collection<Customer> expected = Arrays.asList(miroslav,tomo);
        Collection<Customer> actual = service.listCustomers();

        Assert.assertArrayEquals(expected.toArray(), actual.toArray());
    }
    @Test
    public void testListAllCustomersByGender() throws ParseException {
        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "026/140-150",
                sa);
        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);

        Collection<Customer> expected = Arrays.asList(miroslav,tomo);
        Collection<Customer> actual = service.listCustomersByGender(MALE);
        Assert.assertArrayEquals(expected.toArray(),actual.toArray());
    }

    @Test
    public void testListAllCustomersByCity() throws ParseException {
        Customer miroslav = new Customer(
                "Miroslav",
                "Maksimovic",
                MALE,
                dateFormat.parse("1995-09-04"),
                "miroslavmaksimovic95@gmail.com",
                "064/140-150",
                sa);
        Customer tomo = new Customer(
                "Tomo",
                "Klacar",
                MALE,
                dateFormat.parse("1994-10-05"),
                "tomoklacar@gmail.com",
                "066/234-435",
                sa);

        Collection<Customer> expected = Arrays.asList(miroslav,tomo);
        Collection<Customer> actual = service.listCustomersByGender(MALE);
        Assert.assertNotEquals(expected,actual);
    }


    @Test
    public void createCustomerWhichExists() throws ParseException {

        service.createCustomer("Miroslav","Maksimovic", MALE, dateFormat.parse("1995-09-04"), "miroslavmaksimovic95@gmail.com", "066/140-150", sa);
    }
    @Test
    public void createNewCustomer() throws ParseException {
        service.createCustomer("Albert", "Akos", MALE, dateFormat.parse("1996-07-05"), "albertakos@gmail.com", "066/234-435", tm);
    }
}

package miki.uni.sarajevo.webshop.service.impl;

import miki.uni.sarajevo.webshop.dao.CustomerDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.*;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.helpClasses.*;
import miki.uni.sarajevo.webshop.service.CustomerManagerService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class CustomerManagerServiceImpl implements CustomerManagerService
{


    private static Logger LOG = LogManager.getLogger(CustomerManagerServiceImpl.class);
    private CustomerDAO customerDAO;

    public CustomerManagerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Collection<Customer> listCustomers() {
        LOG.info("List All Customers");
        return customerDAO.readCustomers();
    }

    public Collection<Customer> listCustomersByCity(City city) {
        return  customerDAO.readCustomersByCity(city);
    }


    public Collection<Customer> listCustomersByCountry(Country country) {
        return customerDAO.readCustomersByCountry(country);
    }

    public Collection<Customer> listCustomersByGender(Gender gender) {
        return customerDAO.readCustomersByGender(gender);
    }

    public void createCustomer(String firstName, String lastName, Gender gender, Date birthDate, String emailAddress, String phoneNumber, Address address) {
        Customer customer = new Customer(firstName, lastName, gender, birthDate, emailAddress, phoneNumber, address);
        try {
            customerDAO.createCustomer(customer);
        } catch (CustomerAlreadyExistsException e) {
            LOG.warn(e.getMessage());
        }
    }

}

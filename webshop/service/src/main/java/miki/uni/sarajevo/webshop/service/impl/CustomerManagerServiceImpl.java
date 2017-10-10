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

import static miki.uni.sarajevo.webshop.model.helpClasses.Gender.MALE;


public class CustomerManagerServiceImpl implements CustomerManagerService
{


    private static Logger LOG = LogManager.getLogger(CustomerManagerServiceImpl.class);
    private CustomerDAO customerDAO;

    public CustomerManagerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public Collection<Customer> listCustomers() {
        return customerDAO.readCustomers();
    }

    public Collection<Customer> listCustomersByCity(City city) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getCity().equals(city)){
                result.add(customer);
            }
        }
        return result;
    }


    public Collection<Customer> listCustomersByCountry(Country country) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getCountry().equals(country)){
                result.add(customer);
            }
        }
        return result;
    }

    public Collection<Customer> listCustomersByGender(Gender gender) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getGender().equals(gender)){
                result.add(customer);
            }
        }
        return result;

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

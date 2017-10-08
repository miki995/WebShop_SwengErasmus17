package miki.uni.sarajevo.webshop.service.impl;

import miki.uni.sarajevo.webshop.dao.CustomerDAO;
import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.*;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.Product;
import miki.uni.sarajevo.webshop.model.helpClasses.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;


public class CustomerDAOImpl implements CustomerDAO
{


    private static Logger LOG = LogManager.getLogger(CustomerDAOImpl.class);
    private CustomerDAO customerDAO;

    public CustomerDAOImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public void createCustomer(String firstName, String lastName, Gender gender, Date birthDate, String emailAddress, String phoneNumber, Address address) throws CustomerAlreadyExsistsException {
        try
        {
            customerDAO.createCustomer(firstName, lastName, gender, birthDate, emailAddress, phoneNumber, address);
        } catch (CustomerAlreadyExsistsException e) {
            LOG.warn(e.getMessage());
        }

    }

    public void updateCustomer(String firstName, String lastName, Gender gender,Date birthDate, String emailAddress, String phoneNumber, Address address) throws CustomerNotFoundException {
        try
        {
            customerDAO.updateCustomer(firstName,lastName,gender,birthDate,emailAddress,phoneNumber,address);
        } catch (CustomerNotFoundException e) {
            LOG.warn(e.getMessage());
        }
    }

    public void deleteCustomer(Customer customer) throws CustomerNotFoundException {
        try
        {
            customerDAO.deleteCustomer(customer);
        } catch (CustomerNotFoundException e) {
            LOG.warn(e.getMessage());
        }

    }


    public Collection<Customer> readCustomers() {
        Collection<Customer> result = new HashSet<Customer>();
        result.addAll(customerDAO.readCustomers());
        return result;
    }


    public Collection<Customer> readCustomersByCity(City city) {

        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getCity().equals(city))
            {
                result.add(customer);
            }
        }
        return result;
    }


    public Collection<Customer> readCustomersByCountry(Country country) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getCountry().equals(country))
            {
                result.add(customer);
            }
        }
        return result;
    }

    public Collection<Customer> readCustomersByGender(Gender gender) {
        Collection<Customer> result = new HashSet<Customer>();
        for(Customer customer : customerDAO.readCustomers()){
            if(customer.getGender().equals(gender))
            {
                result.add(customer);
            }
        }
        return result;}

    public Customer readCustomerByBirthDate(Date date) throws BirthDateNotFoundException {
        try {
            return customerDAO.readCustomerByBirthDate(date);
        } catch (BirthDateNotFoundException e) {
            LOG.warn(e.getMessage());
        }
        return null;
    }

    public Customer readCustomerByEmail(String email) throws EmailNotFoundException {
        try {
            return customerDAO.readCustomerByEmail(email);
        } catch (EmailNotFoundException e) {
            LOG.warn(e.getMessage());
        }
        return null;
    }

    public Customer readCustomerByPhone(String phone) throws PhoneNotFoundException {
        try {
            return customerDAO.readCustomerByPhone(phone);
        } catch (PhoneNotFoundException e) {
            LOG.warn(e.getMessage());
        }
        return null;
    }
}

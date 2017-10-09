package miki.uni.sarajevo.webshop.dao;

import miki.uni.sarajevo.webshop.dao.exceptions.customerExceptions.*;
import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.helpClasses.City;
import miki.uni.sarajevo.webshop.model.helpClasses.Country;
import miki.uni.sarajevo.webshop.model.helpClasses.Gender;

import java.util.Collection;
import java.util.Date;

/**
 * Created by miki995 on 2017.10.08..
 */
public interface CustomerDAO {

    void createCustomer(Customer customer) throws CustomerAlreadyExistsException;

    void updateCustomer(Customer customer) throws CustomerNotFoundException;

    void deleteCustomer(Customer customer) throws CustomerNotFoundException;

    Collection<Customer> readCustomers();

    Collection<Customer> readCustomersByCity(City city);

    Collection<Customer> readCustomersByCountry(Country country);

    Collection<Customer> readCustomersByGender(Gender gender);

    Customer readCustomerByBirthDate(Date date) throws BirthDateNotFoundException;

    Customer readCustomerByEmail(String email) throws EmailNotFoundException;

    Customer readCustomerByPhone(String phone) throws PhoneNotFoundException;
}

package miki.uni.sarajevo.webshop.service;

import miki.uni.sarajevo.webshop.model.Customer;
import miki.uni.sarajevo.webshop.model.helpClasses.Address;
import miki.uni.sarajevo.webshop.model.helpClasses.City;
import miki.uni.sarajevo.webshop.model.helpClasses.Country;
import miki.uni.sarajevo.webshop.model.helpClasses.Gender;

import java.util.Collection;
import java.util.Date;

/**
 * Created by miki995 on 2017.10.09..
 */
public interface CustomerManagerService {


    public Collection<Customer> listCustomers();
    public Collection<Customer> listCustomersByCity(City city);
    public Collection<Customer> listCustomersByCountry(Country country);
    public Collection<Customer> listCustomersByGender(Gender gender);


    public void createCustomer(String firstName, String lastName, Gender gender, Date birthDate, String emailAddress, String phoneNumber, Address address);

}

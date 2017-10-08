package miki.uni.sarajevo.webshop.model.helpClasses;

public class Address {

    private  String zipCode;
    private City city;
    private Country country;

    public Address(String zipCode, City city, Country country) {
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", city=" + city +
                ", country=" + country +
                '}';
    }
}

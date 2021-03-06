package miki.uni.sarajevo.webshop.model;

import miki.uni.sarajevo.webshop.model.helpClasses.Availability;

public class Product {

    private final String name;
    private final String description;
    private float price;
    private Availability available;

    public Product(String name, String description, float price, Availability available) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Availability isAvailable() {
        return available;
    }

    public void setAvailable(Availability available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Product && name.equals(((Product) obj).name) && description.equals(((Product) obj).description);
    }
}

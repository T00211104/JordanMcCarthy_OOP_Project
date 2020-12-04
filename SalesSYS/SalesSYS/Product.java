package SalesSYS;

//Product.java
/*a simple instantiable class definition for a Product*/

import java.io.Serializable;

public class Product implements Serializable {
    private int productID;
    private String name;
    private String manufacturer;
    private int quantity;
    private String description;
    private int price;

    public Product(int productID,String name,String manufacturer,int quantity,String description,int price){
        setProductID(productID);
        setName(name);
        setManufacturer(manufacturer);
        setQuantity(quantity);
        setDescription(description);
        setPrice(price);
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }



    public void setProductID(int productID) {
        this.productID = productID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setQuantity(int quantity) {
        if (quantity>0)
            this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(int price) {
        if (price>0)
            this.price = price;
    }

    public String toString() {
        return  "Product ID: " + getProductID() +
                "\nName: " + getName()  +
                "  Manufacturer: " + getManufacturer() +
                "\nQuantity: " + getQuantity() +
                "  Description: " + getDescription() +
                "  Price: " + getPrice();

    }
}

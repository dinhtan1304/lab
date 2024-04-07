package Entry;

import java.util.Date;

public class Product {

    String id;
    String name;
    String Loacation;
    double price;
    Date expiryDate;
    Date dateOfMan;
    String Category;
    String Storekeeper;
    Date recDate;

    public Product(String id, String name, String Loacation, double price, Date expiryDate, Date dateOfMan, String Category, String Storekeeper, Date recDate) {
        this.id = id;
        this.name = name;
        this.Loacation = Loacation;
        this.price = price;
        this.expiryDate = expiryDate;
        this.dateOfMan = dateOfMan;
        this.Category = Category;
        this.Storekeeper = Storekeeper;
        this.recDate = recDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoacation() {
        return Loacation;
    }

    public void setLoacation(String Loacation) {
        this.Loacation = Loacation;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getDateOfMan() {
        return dateOfMan;
    }

    public void setDateOfMan(Date dateOfMan) {
        this.dateOfMan = dateOfMan;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getStorekeeper() {
        return Storekeeper;
    }

    public void setStorekeeper(String Storekeeper) {
        this.Storekeeper = Storekeeper;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }
    
}

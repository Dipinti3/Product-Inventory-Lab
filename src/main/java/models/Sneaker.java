package models;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private float size;
    private int quantity;
    private float price;

    public Sneaker(){}

    public Sneaker(int id, String name, String brand, String sport, int quantity,
                   float price) {
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.sport=sport;
        this.quantity=quantity;
        this.price=price;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getSport() {
        return sport;
    }

    public float getSize() {
        return size;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }



    public void setName(String name) {
        this.name=name;
    }

    public String getName() {
       return this.name;
    }
}

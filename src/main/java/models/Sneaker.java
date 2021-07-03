package models;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private float size;
    private int quantity;
    private float price;

   public void setName(String name) {
        this.name=name;
    }

    public String getName() {
       return this.name;
    }
}

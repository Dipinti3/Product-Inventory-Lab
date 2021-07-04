package models;

import services.SneakerService;

public class Sneaker {
    private int id;
    private String name;
    private String brand;
    private String sport;
    private float size;
    private int quantity;
    private float price;

    public Sneaker(){
    }


    public Sneaker(String name, String brand, String sport, int size, int quantity, float price){
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Sneaker(int id, String name, String brand, String sport, int quantity,
                   float price) {
        this.id=id;
        this.name=name;
        this.brand=brand;
        this.sport=sport;
        this.quantity=quantity;
        this.price=price;
    }

    public Sneaker(String name, String brand, String sport, float size, int quantity, float price) {
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    public Sneaker(int i, String name, String brand, String sport, float size, int quantity, float price) {
        this.name = name;
        this.brand = brand;
        this.sport = sport;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
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

    SneakerService service=new SneakerService();
    //read
    public Sneaker findSneaker(int id) {
        // should take an int and return an object with that id, if exists
        return service.getSneaker(id);
    }

    //read all
    public String[] findAll() {
        // should return a basic array copy of the ArrayList
        return service.getAll();
    }

    //delete
    public boolean delete(int id) {
        // should remove the object with this id from the ArrayList if exits and return true.
        // Otherwise return false
        if(service.findSneakerInInventory(id)){
        service.removeSneaker(id);
        return true;}
        else
            return false;
    }
}

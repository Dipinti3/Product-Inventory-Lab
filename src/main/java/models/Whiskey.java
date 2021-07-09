package models;

public class Whiskey implements Product{
    private int id;
    private String name;
    private String brand;
    private int labelNumber;
    private Float size;
    private int qty;
    private Float price;

    public Whiskey(int id, String name, String brand, int labelNumber, Float size, int qty, Float price) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.labelNumber = labelNumber;
        this.size = size;
        this.qty = qty;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Whiskey{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", labelNumber=" + labelNumber +
                ", size=" + size +
                ", qty=" + qty +
                ", price=" + price +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getLabelNumber() {
        return labelNumber;
    }

    public void setLabelNumber(int labelNumber) {
        this.labelNumber = labelNumber;
    }

    public Float getSize() {
        return size;
    }

    public void setSize(Float size) {
        this.size = size;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public Float getTotalPrice() {
        return getQty() * getPrice();
    }
}

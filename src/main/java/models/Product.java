package models;
public interface Product {
    public String getName();
    public void setName(String name);
    public Float getPrice();
    public void setPrice(Float name);
    public Float getTotalPrice();
    public int getQty();
    public void setQty(int quantity);
    public String getBrand();
    public void setBrand(String name);
    public int getId();
    public Float getSize();
    public void setSize(Float size);
}

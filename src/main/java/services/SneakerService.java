package services;

import models.Sneaker;

import java.util.ArrayList;

public class SneakerService {
    private static int nextId = 1;
    private ArrayList<Sneaker> inventory = new ArrayList<>();


    public Sneaker create(String name, String brand, String sport, float size, int quantity,
                          float price) {
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
        inventory.add(createdSneaker);
        return createdSneaker;

    }

    public Sneaker getSneaker(int id){
        return inventory.get(nextId);
    }

    public String[] getAll() {
        String[] array= inventory.toArray(new String[0]);
        return array;
    }

    public void removeSneaker(int id) {
        inventory.remove(id);
    }

    public boolean findSneakerInInventory(int id) {
        if(inventory.contains(id)){
            return true;
        }
        return false;
    }
}


package services;
import models.Sneaker;
import utils.CSVUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SneakerService {
    private static int nextId = 1;
    private static List<Sneaker> inventory = new ArrayList<>();
    public  Sneaker create(String name, String brand, String sport, float size, int quantity, float price) {
        Sneaker createdSneaker = new Sneaker(nextId++, name, brand, sport, size, quantity, price);
        inventory.add(createdSneaker);
        return createdSneaker;
    }

    public Sneaker findSneaker(int id) {
        for(Sneaker element : inventory){
            if(element.getId() == id){
                return element;
            }
        }
        return null;
    }

    public Sneaker[] findAll() {
        // to convert ArrayList to array
        return inventory.toArray(new Sneaker[0]);
    }

    public boolean delete(int id) {
        for(Sneaker element: inventory){
            if(element.getId() == id){
                inventory.remove(element);
                return true;
            }
        }
        return false;
    }

    public static void csvFileSaver() throws IOException {
        String csvFile = "/Users/dipinti/Desktop/Sneaker.csv";
        FileWriter writer = new FileWriter(csvFile);
        CSVUtils.writeLine(writer, new ArrayList<String>(Arrays.asList(String.valueOf(nextId))));
        for (Sneaker s : inventory) {
            List<String> list = new ArrayList<>();
            list.add(String.valueOf(s.getId()));
            list.add(s.getName());
            list.add(s.getBrand());
            list.add(s.getSport());
            list.add(String.valueOf(s.getSize()));
            list.add(String.valueOf(s.getQty()));
            list.add(String.valueOf(s.getPrice()));
            CSVUtils.writeLine(writer, list);
        }
        writer.flush();
        writer.close();
    }
    public static void loadData(){

        String csvFile = "/Users/dipinti/Desktop/Sneaker.csv";
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            nextId = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                String[] beer = line.split(csvSplitBy);
                int id = Integer.parseInt(beer[0]);
                String name = beer[1];
                String brand = beer[2];
                String sport = beer[3];
                float size = Float.parseFloat(beer[4]);
                int qty = Integer.parseInt(beer[5]);
                float price = Float.parseFloat(beer[6]);
                inventory.add(new Sneaker(id, name, brand, sport, size, qty, price));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

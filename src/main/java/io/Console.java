package io;
import models.Inventory;
import models.Product;
import models.Sneaker;
import models.Whiskey;
import services.SneakerService;
import services.WhiskeyService;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Console<decimalFormatter> {
    private static Inventory inventory = new Inventory();
    private static DecimalFormat decimalFormatter = new DecimalFormat("0.00");
public static void initializeSampleInventory(){
        SneakerService sneakerService = inventory.getSneakerService();
        WhiskeyService whiskeyService = inventory.getWhiskeyService();

        sneakerService.create("GoForIt", "Biba", "Hockey", 12.5f,
        39, 39.99f);
        sneakerService.create("Casual Wear", "Bata", "Kabaddi", 5.5f,
        28, 45.99f);
        sneakerService.create("KeepRunning", "KBrand", "RelayRace", 12.5f,
        15, 34.99f);

        whiskeyService.create("Strong", "Glenfidich", 12, 44.0f,
        125, 45.50f);
        whiskeyService.create("DoubleMalt", "BlackLabel", 76, 42.9f,
        99, 55.50f);
        whiskeyService.create("SingleMalt", "Bourbon", 59, 60.09f,
        22, 89.95f);
        }
    public static void print(String input){
        System.out.println(input);
    }
    public static void printWelcome(){
        System.out.println("" +
                "**************************************************\n" +
                "***           Welcome and Bienvenue            ***\n" +
                "***                    to                      ***\n" +
                "***          ZipCo Inventory Manager           ***\n" +
                "**************************************************");
    }

public static void mainMenu(){
    Scanner scanner = new Scanner(System.in);
    print("Do you want report on Inventory? Press 1: ");
    print("2. Do you want to edit Inventory? Press 2: ");
    print("3. Do you want to delete a product? Press 3: ");
    print("Press a number>3 to QUIT: ");
    print("Please enter your option now: ");
    Integer input = scanner.nextInt();

    switch(input){
        case 1:
            inventoryReportMenu();
            break;
        case 2:
            editInventoryMenu();
            break;
        case 3:
            deleteInventoryMenu();
        default:
            print("Quitting....GoodBye!");
    }
    }


    public static void inventoryReportMenu(){
        Scanner scanner = new Scanner(System.in);
        Integer input;
        print("Select report to generate");
        print("1. Sneaker");
        print("2. Whiskey");
        print("3. All Products");
        print("4. Go Back to Top Menu");

        input = scanner.nextInt();
        if(input >= 4){
            mainMenu();
        } else {
            inventoryReportOptions(input);
        }
    }

    public static void printInventoryMenu(){
        print("Select an option to edit");
        print("1. Sneakers");
        print("2. Whiskey");
        print("3. Return to menu");
    }

    public static void editInventoryMenu(){
        Scanner scanner = new Scanner(System.in);
        Integer input;
        printInventoryMenu();
        input = scanner.nextInt();
        switch (input){
            case 1:
                selectSneakerMenu();
                break;
            case 2:
                selectWhiskeyMenu();
                break;
            case 3:
            default:
                mainMenu();
        }
    }

    public static void inventoryReportOptions(Integer option){
        switch(option){
            case 1:
                printList(inventory.getSneakerService().findAll());
                break;
            case 2:
                printList(inventory.getWhiskeyService().findAll());
                break;
            case 3:
                printList(inventory.getAllProductsArrayList());
        }
        inventoryReportMenu();
    }

    public static void selectSneakerMenu(){
        print("Select product to edit");
        Sneaker[] sneakerList = inventory.getSneakerService().findAll();
        printList(sneakerList);
        Scanner scanner = new Scanner(System.in);
        Integer menuSelection = scanner.nextInt();
        editSneakerMenu(sneakerList[menuSelection - 1]);
    }

    public static void selectWhiskeyMenu(){
        print("Select product to edit");
        Whiskey[] whiskeyList = inventory.getWhiskeyService().findAll();
        printList(whiskeyList);
        Scanner scanner = new Scanner(System.in);
        Integer menuSelection = scanner.nextInt();
        editWhiskeyMenu(whiskeyList[menuSelection - 1]);
    }

    public static void printCommonPropertyOptions(){
        print("Select menu option number to edit property");
        print("1: Name");
        print("2: Brand");
        print("3: Size");
        print("4: Price");
        print("5: Quantity");
    }

    public static void editSneakerMenu(Sneaker sneaker){
        Scanner scanner = new Scanner(System.in);
        Integer menuSelectionNumber;
        Integer integerInput;
        String stringInput;
        Float floatInput;
        print("You Selected: " + sneaker.toString());
        printCommonPropertyOptions();
        print("6: Sport");
        print("7: Previous menu");
        menuSelectionNumber = scanner.nextInt();
        switch (menuSelectionNumber){
            case 1:
                print("Enter another name for product");
                scanner.nextLine();
                stringInput = scanner.nextLine();
                sneaker.setName(stringInput);
                editSneakerMenu(sneaker);
                break;
            case 2:
                print ("Enter another brand name for product");
                scanner.nextLine();
                stringInput = scanner.nextLine();
                sneaker.setBrand(stringInput);
                editSneakerMenu(sneaker);
                break;
            case 3:
                print ("Enter another size for product");
                scanner.nextLine();
                floatInput = scanner.nextFloat();
                sneaker.setSize(floatInput);
                editSneakerMenu(sneaker);
            case 4:
                print ("Enter another price for product");
                scanner.nextLine();
                floatInput = scanner.nextFloat();
                sneaker.setPrice(floatInput);
                editSneakerMenu(sneaker);
            case 5:
                print ("Enter another quantity for product");
                scanner.nextLine();
                integerInput = scanner.nextInt();
                sneaker.setQty(integerInput);
                editSneakerMenu(sneaker);
            case 6:
                print ("Enter another Sport for product");
                scanner.nextLine();
                stringInput = scanner.nextLine();
                sneaker.setSport(stringInput);
                editSneakerMenu(sneaker);
            default: //Input 7 or any number not listed above
                editInventoryMenu();
        }
    }

    public static void editWhiskeyMenu(Whiskey whiskey){
        Scanner scanner = new Scanner(System.in);
        Integer menuSelectionNumber;
        Integer integerInput;
        String stringInput;
        Float floatInput;
        print("you chose: " + whiskey.toString());
        printCommonPropertyOptions();
        print("6: LabelNumber");
        print("7: Go to menu");
        menuSelectionNumber = scanner.nextInt();
        switch (menuSelectionNumber){
            case 1:
                print("Enter another name for product");
                scanner.nextLine();
                stringInput = scanner.nextLine();
                whiskey.setName(stringInput);
                editWhiskeyMenu(whiskey);
                break;
            case 2:
                print ("Enter another brand name for product");
                scanner.nextLine();
                stringInput = scanner.nextLine();
                whiskey.setBrand(stringInput);
                editWhiskeyMenu(whiskey);
                break;
            case 3:
                print ("Enter another size for product");
                scanner.nextLine();
                floatInput = scanner.nextFloat();
                whiskey.setSize(floatInput);
                editWhiskeyMenu(whiskey);
            case 4:
                print ("Enter another price for product");
                scanner.nextLine();
                floatInput = scanner.nextFloat();
                whiskey.setPrice(floatInput);
                editWhiskeyMenu(whiskey);
            case 5:
                print ("Enter another quantity for product");
                scanner.nextLine();
                integerInput = scanner.nextInt();
                whiskey.setQty(integerInput);
                editWhiskeyMenu(whiskey);
            case 6:
                print ("Enter another LabelNo. for product");
                scanner.nextLine();
                integerInput = scanner.nextInt();
                whiskey.setLabelNumber(integerInput);
                editWhiskeyMenu(whiskey);
            default:
                editInventoryMenu();
        }
    }

    public static void deleteInventoryMenu(){
        Scanner scanner = new Scanner(System.in);
        Integer input;
        print("Select Category to delete from");
        print("1: Sneakers");
        print("2: Whiskey");
        print("3: Return to previous menu");
        input = scanner.nextInt();
        Product[] productList;
        switch(input){
            case 1:
                productList = inventory.getSneakerService().findAll();
                deleteProductMenu(productList);
            case 2:
                productList = inventory.getWhiskeyService().findAll();
                deleteProductMenu(productList);
            default:
                mainMenu();
        }

    }

    public static void deleteProductMenu(Product[] productList){
        Scanner scanner = new Scanner(System.in);
        Integer input;
        print("Enter product to delete");
        print("0: Return to menu");

        if(productList.length < 2)
            mainMenu();

        printList(productList);
        input = scanner.nextInt();
        if(input == 0){
            deleteInventoryMenu();
        } else {
            --input;
            input = input < productList.length ? input : productList.length -1;
            if(productList[input] instanceof Sneaker){
                inventory.getSneakerService().delete(productList[input].getId());
            } else {
                inventory.getWhiskeyService().delete(productList[input].getId());
            }
            deleteInventoryMenu();
        }

    }

    public static void printList(Product[] list){
        ArrayList<Product> aList = new ArrayList<>(Arrays.asList(list));
        String productType = "";
        Integer listNumber = 0;
        for(Product element: aList){
            String price = decimalFormatter.format(element.getTotalPrice());
            productType = element instanceof Whiskey ? "Whiskey: " : "Sneaker: ";
            print(++listNumber + ": " + productType + element.getName() + "   qty:" + element.getQty() +
                    "   total $" + price);
        }
    }


}

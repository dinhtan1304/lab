/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import Entry.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author admin
 */
class ProductsManagemet {

    // display a menu 
    static void displayMenu() {
        System.out.println("Main Menu:");
        System.out.println("      1.  Add Storekeeper");
        System.out.println("      2.  Add product");
        System.out.println("      3.  Update product");
        System.out.println("      4.  Search product by Name, Category, Storekeeper, ReceiptDate");
        System.out.println("      5.  Sort product by Expiry date, Date of manufacture");
        System.out.println("      6.  Exit");
        System.out.print("Enter your choice[1,6]: ");
    }

    //number user selection
    static int numberUserSelection() {
        return Input.inputIntInRange(1, 6);
    }

    //add storekeeper
    static void addStorekeeper(ArrayList<String> stk) {
        System.out.println("=========Add Storekeeper============");
        String storekeeper = "";
        //loop until stk not exist
        do {
            //Storekeeper input
            System.out.print("Store Keeper: ");
            storekeeper = Input.inputString();
            if ((Check.checkStkExist(stk, storekeeper))) {
                System.out.println("Storekeeper is exist.Enter again.");
            }
        } while (Check.checkStkExist(stk, storekeeper));
        //add new storekeeper
        stk.add(storekeeper);
        System.out.println("========Add Storekeeper successfull========");
    }

    //display list of storekeeper
    static void displayStoreKeepers(ArrayList<String> stk) {
        int number = 1;
        System.out.printf("%-10s%-15s\n", "Number |", "StoreKeeper");
        for (String st : stk) {
            System.out.printf("%-10d%-15s\n", number++, st);
        }
    }

    //add product
    static void addProduct(ArrayList<String> stk, ArrayList<Product> lp) throws ParseException {
        System.out.println("=========Add Product============");
        //check if storekeeper is not exist
        if (stk.isEmpty()) {
            System.out.println("Not have store keeper.Can not add product.");
            System.out.println("=================================");
            return;
        }
        String Id = "";
        //loop until id is not exist
        do {
            System.out.print("ID: ");
            Id = Input.inputString();
            if (Check.checkIdExist(lp, Id)) {
                System.out.println("Id is exist.Enter again.");
            }
        } while (Check.checkIdExist(lp, Id));
        //info input
        System.out.print("Name: ");
        String name = Input.inputString();
        System.out.print("Location: ");
        String location = Input.inputString();
        System.out.print("Price: ");
        double price = Input.inputPosDouble();
        Date expDate = null;
        Date dom = null;
        //loop ultil exp date behind date of manu
        do {
            System.out.print("Expiry date: ");
            expDate = Input.inputDate();
            System.out.print("Date of manufacture: ");
            dom = Input.inputDate();
            if (expDate.compareTo(dom) <= 0) {
                System.out.println("Expiry date must before date of manufacture.Enter again. ");
            }
        } while (expDate.compareTo(dom) <= 0);
        System.out.print("Category: ");
        String cate = Input.inputString();
        displayStoreKeepers(stk);
        System.out.print("Store Keeper Number: ");
        int stkNumber = Input.inputIntInRange(1, stk.size());
        String storekeeper = stk.get(stkNumber-1);
        Date rcpDate = null;
        //loop ultil receipt date behind date of manu
        do {
            System.out.print("Receipt Date: ");
            rcpDate = Input.inputDate();
            if (rcpDate.compareTo(dom) <= 0) {
                System.out.println("Receipt date must before date of manufacture.Enter again. ");
            }
        } while (rcpDate.compareTo(dom) <= 0);
        //add product to list
        lp.add(new Product(Id, name, location, price, expDate, dom, cate, storekeeper, rcpDate));
        System.out.println("=========Add Product succesful========");
    }

    static void updateProduct(ArrayList<String> stk, ArrayList<Product> lp) throws ParseException {
        System.out.println("=========Update Product============");
        //check if storekeeper is not exist
        if (lp.isEmpty()) {
            System.out.println("Not have product.Can not update.");
            System.out.println("=================================");
            return;
        }
        String Id = "";
        //loop until id is exist
        do {
            System.out.print("ID: ");
            Id = Input.inputString();
            if (!Check.checkIdExist(lp, Id)) {
                System.out.println("Id is not exist.Enter again");
            }
        } while (!Check.checkIdExist(lp, Id));
        for (Product p : lp) {
            if (p.getId().equalsIgnoreCase(Id)) {
                //loop until id is not exist
                do {
                    System.out.print("New ID: ");
                    Id = Input.inputString();
                    if (p.getId().equalsIgnoreCase(Id)) {
                        break;
                    }
                    if (Check.checkIdExist(lp, Id)) {
                        System.out.println("Id is exist.Enter again.");
                    }
                } while (Check.checkIdExist(lp, Id));
                //info input
                System.out.print("New Name: ");
                String name = Input.inputString();
                System.out.print("New Location: ");
                String location = Input.inputString();
                System.out.print("New Price: ");
                double price = Input.inputPosDouble();
                Date expDate = null;
                Date dom = null;
                //loop ultil exp date behind date of manu
                do {
                    System.out.print("New Expiry date: ");
                    expDate = Input.inputDate();
                    System.out.print("New Date of manufacture: ");
                    dom = Input.inputDate();
                    if (expDate.compareTo(dom) <= 0) {
                        System.out.println("Expiry date must before date of manufacture.Enter again. ");
                    }
                } while (expDate.compareTo(dom) <= 0);
                System.out.print("New Category: ");
                String cate = Input.inputString();
                displayStoreKeepers(stk);
                System.out.print("Store Keeper Number: ");
                int stkNumber = Input.inputIntInRange(1, stk.size());
                String storekeeper = stk.get(stkNumber-1);
                Date rcpDate = null;
                //loop ultil receipt date behind date of manu
                do {
                    System.out.print("New Receipt Date: ");
                    rcpDate = Input.inputDate();
                    if (rcpDate.compareTo(dom) <= 0) {
                        System.out.println("Receipt date must before date of manufacture.Enter again. ");
                    }
                } while (rcpDate.compareTo(dom) <= 0);
                p.setId(Id);
                p.setName(name);
                p.setPrice(price);
                p.setLoacation(location);
                p.setExpiryDate(expDate);
                p.setDateOfMan(dom);
                p.setRecDate(rcpDate);
                p.setStorekeeper(storekeeper);
                break;
            }
        }
        System.out.println("=========Update Product successful========");
    }

    //display search menu
    static void displaySearchMenu() {
        System.out.println("Choose your option");
        System.out.println("1.Search by name");
        System.out.println("2.Search by Category");
        System.out.println("3.Search by Storekeeper");
        System.out.println("4.Search by ReceiptDate");
        System.out.print("Enter your choice[1,4]: ");
    }

    //search product
    static void searchProduct(ArrayList<Product> lp) throws ParseException {
        System.out.println("=========Search Product============");
        //check if storekeeper is not exist
        if (lp.isEmpty()) {
            System.out.println("Not have product.Can not search.");
            System.out.println("=================================");
            return;
        }
        //display search menu
        displaySearchMenu();
        //input selection
        int selection = Input.inputIntInRange(1, 4);
        //perform function based on the select option.
        switch (selection) {
            //Search by name
            case 1:
                searchByName(lp);
                break;
            //Search by Category
            case 2:
                searchByCategory(lp);
                break;
            //Search by Storekeeper
            case 3:
                searchByStorekeeper(lp);
                break;
            //Search by ReceiptDate
            case 4:
                searchByReceiptDate(lp);
                break;
        }
    }

    //Search by name
    static void searchByName(ArrayList<Product> lp) {
        System.out.println("=========Search by name============");
        String name = "";
        ArrayList<Product> lsbn = new ArrayList<>();
        System.out.print("Input name want to search: ");
        name = Input.inputString();
        for (Product p : lp) {
            if (p.getName().equalsIgnoreCase(name)) {
                lsbn.add(p);
            }
        }
        displayListProduct(lsbn);
    }

    //Search by Category
    static void searchByCategory(ArrayList<Product> lp) {
        System.out.println("=========Search by Category============");
        String cate = "";
        ArrayList<Product> lsbc = new ArrayList<>();
        System.out.print("Input category want to search: ");
        cate = Input.inputString();
        for (Product p : lp) {
            if (p.getCategory().equalsIgnoreCase(cate)) {
                lsbc.add(p);
            }
        }
        displayListProduct(lsbc);
    }

    //Search by Storekeeper
    static void searchByStorekeeper(ArrayList<Product> lp) {
        System.out.println("=========Search by Storekeeper============");
        String stk = "";
        ArrayList<Product> lsbstk = new ArrayList<>();
        System.out.print("Input storekeeper want to search: ");
        stk = Input.inputString();
        for (Product p : lp) {
            if (p.getStorekeeper().equalsIgnoreCase(stk)) {
                lsbstk.add(p);
            }
        }
        displayListProduct(lsbstk);
    }

    //Search by ReceiptDate
    static void searchByReceiptDate(ArrayList<Product> lp) throws ParseException {
        System.out.println("=========Search by ReceiptDate============");
        Date recDate = null;
        ArrayList<Product> lsbrd = new ArrayList<>();
        System.out.print("Input receipt date want to search: ");
        recDate = Input.inputDate();
        for (Product p : lp) {
            if (p.getRecDate().compareTo(recDate) == 0) {
                lsbrd.add(p);
            }
        }
        displayListProduct(lsbrd);
    }

    public static Comparator<Product> proCom = (Product p1, Product p2) -> {
        if (p1.getExpiryDate().compareTo(p2.getExpiryDate()) == 0) {
            return p1.getDateOfMan().compareTo(p2.getDateOfMan());
        } else {
            return p1.getExpiryDate().compareTo(p2.getExpiryDate());
        }
    };

    //sort product
    static void sortProduct(ArrayList<Product> lp) {
        Collections.sort(lp, proCom);
        //display after sort
        displayListProduct(lp);
    }

    //display list product
    static void displayListProduct(ArrayList<Product> lp) {
        System.out.println("=============List of Product===========");
        //check if storekeeper is not exist
        if (lp.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("=================================");
            return;
        }
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        System.out.printf("%-5s%-15s%-15s%-10s%-15s%-15s%-12s%-15s%-15s\n",
                "ID", "Name", "Location", "Price", "Expiry date", "DOM", "Category", "Storekeeper", "ReceiptDate");
        for (Product p : lp) {
            System.out.printf("%-5s%-15s%-15s%-10.1f%-15s%-15s%-12s%-15s%-15s\n",
                    p.getId(), p.getName(), p.getLoacation(), p.getPrice(), format.format(p.getExpiryDate()), format.format(p.getDateOfMan()), p.getCategory(), p.getStorekeeper(), format.format(p.getRecDate()));
        }
        System.out.println("=================================");
    }
}

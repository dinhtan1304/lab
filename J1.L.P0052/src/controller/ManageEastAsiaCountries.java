/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import model.Country;
import valiidation.Input;

/**
 *
 * @author Dell
 */
public class ManageEastAsiaCountries {

    private final static Scanner sc = new Scanner(System.in);
    //Display menu
    public static void showMenu() {
        System.out.println("                        MENU            ");
        System.out.println("====================================================");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you' ve just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Dislay the information of countries sorted name is ascending order ");
        System.out.println("5. Exit");
        System.out.println("=====================================================");
        System.out.println("Enter your choice :");

    }
    // Input the information of 11 countries 
    public static ArrayList<Country> inputInfor(ArrayList<Country> cl) {
        ArrayList<Country> cl1 = new ArrayList<>();
        //
//        System.out.println("How many country do you want add?");
//        int n = Input.inputInt();
        for (int i = 0; i < 2; i++) {
            String code = "";
            do {
                // input id
                System.out.println("Enter code of country");
                code = Input.inputString();
                // check id exist
                if (!valiidation.Check.checkIdExist(cl, code)) {
                    System.out.println("Code exist, Re_enter code!");
                }
            } while (!valiidation.Check.checkIdExist(cl, code));
            // input name of country
            System.out.println("Enter name of coutry");
            String name = Input.inputString();
            // input total Area
            System.out.println("Enter total Area:");
            float area = Input.inputFloat();
            // input terrain
            System.out.println("Enter terrain of country:");
            String terrain = Input.inputString();
            cl.add(new Country(code, name, area, terrain));
            System.out.println("Add country successful!");
            System.out.println();
        }
        

        return cl1;
    }
    
    //Display information of countries you’ve just input
    public static void showInfor(ArrayList<Country> cl) {
        if (cl.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
            cl.get(cl.size() - 1).printf();
        System.out.println();
    }
    
    //Search information of countries by user-entered name
    public static void searchByName(ArrayList<Country> cl) {
        if(cl.isEmpty()){
            System.out.println("List empty.");
            return;
        }
        // input name country user wamt to find
        System.out.println("Enter the name you want to search for:");
        String name = Input.inputString();
        int count = 0;
        // loop for all country list
        for (Country o : cl) {
            // if name equal name country  in the list => print  
            if (o.getCountryName().toUpperCase().contains(name.toUpperCase())){
                o.printf();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Not found the country!");
        }
    }
    
    // Display infor list country
    public static void Display(ArrayList<Country> cl){
        System.out.printf("%-20s%-20s%-20s%-20s\n", "ID", "Name", "Total Area", "Terrain");
        for (Country o : cl) {
            o.print();
            System.out.println();
        }        
    }

    //Displays the names of countries by name ascending 
    public static void sortByName(ArrayList<Country> cl) {
        if (cl.isEmpty()) {
            System.out.println("List empty.");
            return;
        }
        Collections.sort(cl, new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.getCountryName().compareToIgnoreCase(o2.getCountryName());
            }
        });
        // Display sorted list country by 
        Display(cl);
    }

}

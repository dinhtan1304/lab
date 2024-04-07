/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.Country;
import valiidation.Input;

/**
 *
 * @author Dell
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Country> country = new ArrayList<>();
        while (true) {
            //step 1:Display a menu 
            ManageEastAsiaCountries.showMenu();
            //step 2:ask users to select an option
            int choose = Input.inputIntLimit(1, 5);

            switch (choose) {
                //step 3:Input the information of 11 countries in East Asia
                case 1:
                    ManageEastAsiaCountries.inputInfor(country);
                    break;
                case 2:
                    //step 4:Display information of countries you’ve just input
                    ManageEastAsiaCountries.showInfor(country);
                    break;
                //step 5:Search information of countries by user-entered name
                case 3:
                    ManageEastAsiaCountries.searchByName(country);
                    break;
                //step 6:Display the country list sorted by name
                case 4:
                    ManageEastAsiaCountries.sortByName(country);
                    break;
                //step 7:Exit program
                case 5:
                    return;
            }
        }
    }

}

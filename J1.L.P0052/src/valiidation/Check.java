/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valiidation;

import java.util.ArrayList;
import model.Country;

/**
 *
 * @author Dell
 */
public class Check {
    public static boolean checkIdExist(ArrayList<Country> c,String code){
        for (Country o : c) {
            if(code.equalsIgnoreCase(o.getCountryCode()))
                return false;
        }
        return true;
    }
}

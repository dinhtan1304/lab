package Manage;

import Entry.Product;
import java.util.ArrayList;

public class Check {

    //check storekeeper exist
    static boolean checkStkExist(ArrayList<String> stk, String storekeeper) {
        for (String stk1 : stk) {
            if(stk1.equalsIgnoreCase(storekeeper)){
                return true;
                }
            }
        return false;
    }
    
    //check storekeeper exist
    static boolean checkIdExist(ArrayList<Product> lp, String id) {
        for (Product p : lp) {
            if(p.getId().equalsIgnoreCase(id)){
                return true;
                }
            }
        return false;
    }
}

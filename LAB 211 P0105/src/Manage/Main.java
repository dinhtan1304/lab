package Manage;

import Entry.Product;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        ArrayList<Product> lp = new ArrayList<>();
        ArrayList<String> stk = new ArrayList<>();
        //loop until user want to exit
        while (true) {
            // Display a menu 
            ProductsManagemet.displayMenu();
            //step 1 : number user selection
            int numUserSelection = ProductsManagemet.numberUserSelection();
            //step 2 : perform function based on the select option. 
            switch (numUserSelection) {
                //Step 2.1:add storekeeper
                case 1:
                    ProductsManagemet.addStorekeeper(stk);
                    break;
                //Step 2.2:add product
                case 2:
                    ProductsManagemet.addProduct(stk,lp);
                    break;
                //Step 2.3:update product
                case 3:
                    ProductsManagemet.updateProduct(stk,lp);
                    break;
                //Step 2.4:search product
                case 4:
                    ProductsManagemet.searchProduct(lp);
                    break;
                //Step 2.5:sort product
                case 5:
                    ProductsManagemet.sortProduct(lp);
                    break;  
                //Step 2.6: exit   
                case 6: 
                    return;
            }
        }
    }
}

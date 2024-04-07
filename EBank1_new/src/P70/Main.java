
package P70;

import java.util.HashMap;

public class Main {
    
    public final static HashMap<String, String> ACCOUNTS = new HashMap<>();
    // Information accounts
    static {
        ACCOUNTS.put("0123456789", "123456ab");
        ACCOUNTS.put("0987654321", "tan12345");
    }

    public static void main(String[] args) {
        while (true) {
            EBank eBank = new EBank();
            // show interface login program
            showLoginProgam();
            // Step 1: Get choice options from Login Program
            int choice = getChoice();
            switch (choice) {
                case 1:
                    //Step 2:Set language to Vietnamese
                    eBank.setLanguage("P70.Language_vi");
                    break;
                case 2:
                    // Step 3:Set language to English
                    eBank.setLanguage("P70.Language_en");
                    break;
                case 3:
                    // Step 4: Exit Login Program
                    return;
            }
        }
    }

    private static void showLoginProgam() {
        System.out.println("-------Login Program-------");
        System.out.println("1. Vietnamese");
        System.out.println("2. English");
        System.out.println("3. Exit");
        System.out.print("Please choice one option: ");
    }

    private static int getChoice() {
        int choice = Check.getChoice(1, 3);
        return choice;

    }

}

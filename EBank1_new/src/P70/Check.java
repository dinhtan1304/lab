package P70;

import static P70.Main.ACCOUNTS;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Check {

    static Scanner in = new Scanner(System.in);

    static int getChoice(int min, int max) {
        // Loop until user input correct
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                // result is only valid in range [min, max]
                if (result < min || result > max) {
                    throw new Exception();
                }
                return result;
            } catch (Exception e) {
                System.out.println("Please enter an integer number in the range[" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static String checkAccountNumber(ResourceBundle bundle, String account) {
        // Check account number must be a number and must have 10 digits
        if (!account.matches("[0-9]{10}")) {
            return bundle.getString("errorAcount");
        }
        return account;
    }

    public static String checkPasswordString(ResourceBundle bundle, String password) {
        // Password must be between 8 and 31 characters and must be alphanumeric
        if (!password.matches("(?=.*[0-9])(?=.*[a-zA-Z])\\w{8,31}")) {
            return bundle.getString("errorPassword");
        }
        return password;
    }

    static boolean checkAccountAndPasswordValid(ResourceBundle bundle, String accountNumber, String password) {
        // Loop to access all information accounts
        for (String key : ACCOUNTS.keySet()) {
            // Check if account number is exist or not
            if (accountNumber.equals(key)) {
                // Check password is correct or not
                if (password.equals(ACCOUNTS.get(key))) {
                    return true;
                } else {
                    System.out.println(bundle.getString("passwordIncorrect") + "\n");
                    return false;
                }
            }
        }
        System.out.println(bundle.getString("accountDoesNotExist") + "\n");
        return false;
    }

    public static String checkCaptcha(ResourceBundle bundle, String captchaInput, String captchaGenerate) {
        // check captcha input is not empty or captchaGenerate contains captchaInput 
        if (captchaInput.isEmpty() || !captchaGenerate.contains(captchaInput)) {
            return bundle.getString("errorCaptcha");
        }
        return captchaInput;
    }
}

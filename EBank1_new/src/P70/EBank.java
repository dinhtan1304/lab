package P70;

import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

public class EBank {

    Scanner in = new Scanner(System.in);

    void setLanguage(String baseName) {
        ResourceBundle bundle = ResourceBundle.getBundle(baseName);
        Login(bundle);
    }

    void Login(ResourceBundle bundle) {
        // step 1: Input the account number
        String accountNumber = inputAccount(bundle);
        // step 2: Input the password
        String password = inputPassword(bundle);
        // step 3: Check acount and password is valid or not
        boolean resultAfterCheck = Check.checkAccountAndPasswordValid(bundle, accountNumber, password);
        // Implement generate captcha and input captcha if 
        if (resultAfterCheck == true) {
            // step 4: Generate a random captcha code. If account and password is valid
            String captchaGenerate = generateCaptcha();
            // step 5: Input captcha
            String captchaInput = inputCaptcha(bundle, captchaGenerate);
            // Check the captcha
            String checkCaptcha = Check.checkCaptcha(bundle, captchaInput, captchaGenerate);
            // If checkCaptcha equals captchaInput user entered, then return 
            if (checkCaptcha.equals(captchaInput)) {
                // If checkCaptcha equals checkCaptcha user entered, then return 
                System.out.println(bundle.getString("success") + "\n");
            } else {
                System.out.println(bundle.getString("errorCaptcha"));
                System.out.println(bundle.getString("fail") + "\n");
            }
        }
    }

    private String inputAccount(ResourceBundle bundle) {
        // Loop until user input correct
        while (true) {
            try {
                System.out.print(bundle.getString("account"));
                String account = in.nextLine().trim();
                // Check the account number.
                String checkAccount = Check.checkAccountNumber(bundle, account);
                // If checkAccount equals account user entered
                if (checkAccount.equals(account)) {
                    return account;
                }
                System.out.println(checkAccount);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private String inputPassword(ResourceBundle bundle) {
        // Loop until user input correct
        while (true) {
            try {
                System.out.print(bundle.getString("password"));
                String password = in.nextLine().trim();
                // Check the password string.
                String checkPassword = Check.checkPasswordString(bundle, password);
                // If checkPassword equals password user entered
                if (checkPassword.equals(password)) {
                    return password;
                }
                System.out.println(checkPassword);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public String generateCaptcha() {
        Random random = new Random();
        int captchaLength = 5;
        String characters = "";
        String captcha = "";
        // Loop to add digits at the end of characters 
        for (char i = '0'; i <= '9'; i++) {
            characters = characters + i;
        }
        // Loop to add abphabet lowercase at the end of String characters
        for (char i = 'a'; i <= 'z'; i++) {
            characters = characters + i;
        }
        // Loop to add abphabet uppercase at the end of String characters 
        for (char i = 'A'; i <= 'Z'; i++) {
            characters = characters + i;
        }
        // Loop to get random captcha with the length is 5
        for (int i = 0; i < captchaLength; i++) {
            char character = characters.charAt(random.nextInt(characters.length()));
            captcha = captcha + character;
        }
        return captcha;
    }

    private String inputCaptcha(ResourceBundle bundle, String captchaGenerate) {
        System.out.println(bundle.getString("captcha") + captchaGenerate);
        System.out.print(bundle.getString("enterCaptcha"));
        return in.nextLine().trim();
    }



}

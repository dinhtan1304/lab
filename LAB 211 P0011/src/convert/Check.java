/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convert;

import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Check{

    private final static Scanner in = new Scanner(System.in);
    private static final String BINARY_VALID = "[0-1]*";
    private static final String DECIMAL_VALID = "[0-9]*";
    private static final String HEXADECIMAL_VALID = "[0-9A-F]*";

    static String inputBinary() {
        System.out.print("Enter binary number: ");
        //loop until user enter correct
        while (true) {
            try {
                String inputValue = in.nextLine().trim();
                //Compares each character of a string to match the character of a binary number
                if (inputValue.isEmpty()) {
                    inputValue = "0";
                    return inputValue;
                } else if (inputValue.matches(BINARY_VALID)) {
                    return inputValue;
                } else {
                    System.out.println("Must be enter 0 or 1");
                    System.out.print("Enter again: ");
                }
            } catch (Exception e) {
                System.out.println("Must be enter 0 or 1");
                System.out.print("Enter again: ");
            }
        }
    }

    static String inputDecimal() {
        System.out.print("Enter decimal number: ");
        //loop until user enter correct
        while (true) {
            try {
                String inputValue = in.nextLine().trim();
                //Compares each character of a string to match the character of a binary number
                if (inputValue.isEmpty()) {
                    inputValue = "0";
                    return inputValue;
                } else if (inputValue.matches(DECIMAL_VALID)) {
                    return inputValue;
                } else {
                    System.out.println("Must be enter decimal number [0-9]");
                    System.out.print("Enter again: ");
                }
            } catch (Exception e) {
                System.out.println("Must be enter decimal number [0-9]");
                System.out.print("Enter again: ");
            }
        }
    }

    static String inputHexaDecimal() {
        System.out.print("Enter number hexadecimal: ");
        //loop until user enter correct
        while (true) {
            try {
                String inputValue = in.nextLine().trim();
                //Compares each character of a string to match the character of a binary number
                if (inputValue.isEmpty()) {
                    inputValue = "0";
                    return inputValue;
                } else if (inputValue.matches(HEXADECIMAL_VALID)) {
                    return inputValue;
                } else {
                    System.out.println("Must be enter hexadecimal number [0-9] [A-F]");
                    System.out.print("Enter again: ");
                }
            } catch (Exception e) {
                System.out.println("Must be enter hexadecimal number [0-9] [A-F]");
                System.out.print("Enter again: ");
            }
        }
    }

    //check user input number limit
    static int inputIntLimit(int min, int max) {
        //loop until user input correct
        while (true) {
            try {
                int numb = Integer.parseInt(in.nextLine().trim());
                if (numb < min || numb > max) {
                    throw new NumberFormatException();
                }
                return numb;
            } catch (NumberFormatException e) {
                System.out.println("Must be input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package valiidation;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author Dell
 */
public class Input {

    private final static Scanner sc = new Scanner(System.in);

    public static int inputIntLimit(int min, int max) {
        //If input incorrect request user re_enter
        while (true) {
            try {
                int result = Integer.parseInt(sc.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();

                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public static int inputInt() {
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(sc.nextLine());
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Enter number >0");
                }
            } catch (Exception e) {
                System.out.println("Enter int number!");
            }
        }
        return number;
    }

    public static float inputFloat() {
        float number = 5;
        while (true) {
            try {
                number = Float.parseFloat(sc.nextLine());

                if (number > 0) {
                    break;
                } else {
                    System.out.println("Enter total Area > 0");
                }
            } catch (Exception e) {
                System.out.println("Enter float number!");
            }
        }
        return number;
    }

    public static String inputString() {
        String txt = " ";
        Pattern p = Pattern.compile("^[a-zA-Z ]+$");
        //If input except String request user re_enter
        while (true) {
            txt = sc.nextLine().trim();
            if (p.matcher(txt).find()) {
                break;
            }
            if (txt.isEmpty()) {
                System.out.println("Not empty,Enter again:");
            } else {
                System.out.println("Enter the String");
            }
        }

        return txt;
    }

}

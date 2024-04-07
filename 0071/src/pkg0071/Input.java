/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0071;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author ADMIN
 */
public class Input {
    
    public static Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, String err, int max) throws IOException {

        while (true) {
            try {
                int num;
                System.out.println(msg);
                num = Integer.parseInt(sc.nextLine());
                if (num <= 0 || num > max) {
                    System.out.println(err);
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
    }

    public static double getDouble(String msg, String err) throws IOException {
        double num;
        while (true) {
            try {
                System.out.println(msg);
                num = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(err);
            }
        }
        return num;
    }

    public static String getString(String msg, String err, String regex) throws IOException {
        while (true) {
            try {
                String str;
                System.out.println(msg);
                str = sc.nextLine().trim();
                if (str.matches(regex)) {
                    return str;
                } else {
                    System.out.println(err);
                }
            } catch (Exception e) {
                System.out.println(err);

            }
        }

    }

    public static Date getdate(String msg, String err) {
        Date d = null;
        System.out.println(msg);
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        df.setLenient(false);  //check dung ngay
        while (true) {
            try {
                d = df.parse(sc.nextLine());
                break;
            } catch (ParseException e) {
                System.out.println(err);
            }
            df.setLenient(false);
        }
        return d;

    }
    
}

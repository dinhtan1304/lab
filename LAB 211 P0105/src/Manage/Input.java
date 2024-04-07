package Manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {
    private static final Scanner in = new Scanner(System.in);
    
    
    //input int in range
    static int inputIntInRange(int min,int max){
        //loop until int input correct
        while (true) {
            try {
                int numInput = Integer.parseInt(in.nextLine().trim());
                //check if number input is out of range
                if (numInput < min || numInput > max) {
                    throw new UnsupportedOperationException("Not in range");
                }
                return numInput;
                //noti if number input is not a interger
            } catch (NumberFormatException e) {
                System.out.println("Must be input a integer,Enter again: ");
                //noti if number input is not in range [min,max]
            } catch (UnsupportedOperationException e) {
                System.out.println("Please input number in rage [" + min + ", " + max + "],Enter again: ");
            }
        }
    }

    //input positive int
    static int inputPosInt() {
        while (true) {
            try {
                int numInput = Integer.parseInt(in.nextLine().trim());
                //check if number input is out of range
                if (numInput <= 0) {
                    throw new UnsupportedOperationException("Not a positive");
                }
                return numInput;
                //noti if number input is not a interger
            } catch (NumberFormatException e) {
                System.out.println("Must be input a integer,Enter again: ");
                //noti if number input is not in range [min,max]
            } catch (UnsupportedOperationException e) {
                System.out.println("Please input a positive number,Enter again: ");               
            }
        }
    }
    
     //input positive double
    static double inputPosDouble() {
        while (true) {
            try {
                double numInput = Double.parseDouble(in.nextLine().trim());
                //check if number input is not positive
                if (numInput <= 0) {
                    throw new UnsupportedOperationException("Not a positive");
                }
                return numInput;
                //noti if number input is not a interger
            } catch (NumberFormatException e) {
                System.out.println("Must be input a double,Enter again: ");
                //noti if number input is not positive
            } catch (UnsupportedOperationException e) {
                System.out.println("Please input a positive double,Enter again: ");               
            }
        }
    }
    
    //input string 
    static String inputString() {
        //loop until string input correct
        while (true) {
            String stringInput = in.nextLine().trim();
            //noti if string input is empty
            if (stringInput.isEmpty()) {
                System.out.print("Not empty,Enter again: ");
            } else {
                return stringInput;
            }
        }
    }

    //input date
    static Date inputDate() throws ParseException {
        //loop until date form input correct
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return date;
                //noti if date is not exist
                } else {
                    System.out.print("Date is not exist,Please re-input :");
                }
            //noti if wrong format of date
            } catch (NumberFormatException | ParseException ex) {
                System.out.print("Wrong format,Enter again :");
            }
        }
    }

}

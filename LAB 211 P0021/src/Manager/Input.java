package Manager;

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
 
     //input course name
    static String inputCourseName() {
        //loop until course name input correct
        System.out.println("1. Java");
        System.out.println("2. .Net");
        System.out.println("3. C/C++");
        System.out.print("Your selection:");
        while (true) {
            //input must be exist (1-3)
            int numInput = inputIntInRange(1, 3);
            String courseName = null;
            //perform task type id based on input
            switch (numInput) {
                case 1:
                    courseName = "Java";
                    break;
                case 2:
                    courseName = ".Net";
                    break;
                case 3:
                    courseName= "C/C++";
                    break;
            }
            return courseName;
        }
    }
    
    public static String InputUD(String notice) {
        System.out.print(notice);
        //loop until user input correct
        while (true) {
            String result = Input.inputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("U")||result.equalsIgnoreCase("D")) {
                return result;
            }
            System.out.println("Please input u/U or d/D.");
            System.out.print("Enter again: ");
        }
    }

}

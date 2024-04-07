package Manage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Input {
    static final String PLAN_VALID = "^[0-9]{1,2}\\.5|[0-9]{1,2}\\.0$";

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


    //input task type(1-4)
    static String inputTaskTypeId() {
        //loop until task type id input correct
        while (true) {
            //input must be exist (1-4)
            int numInput = inputIntInRange(1, 4);
            String taskTypeId = null;
            //perform task type id based on input
            switch (numInput) {
                case 1:
                    taskTypeId = "Code";
                    break;
                case 2:
                    taskTypeId = "Test";
                    break;
                case 3:
                    taskTypeId = "Design";
                    break;
                case 4:
                    taskTypeId = "Review";
            }
            return taskTypeId;
        }
    }

    //input date
    static String inputDate() throws ParseException {
        //loop until date form input correct
        while (true) {
            try {
                String result = in.nextLine().trim();
                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
                Date date = format.parse(result);
                if (result.equalsIgnoreCase(format.format(date))) {
                    return result;
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

    //input plan
    static String inputPlan() {
        while (true) {
            String plan = inputString();
            //check if form and values of plan right
            if (plan.matches(PLAN_VALID) ) {
                if(Double.parseDouble(plan) >= 8.0 && Double.parseDouble(plan) <= 17.5)
                    return plan;
                //noti if plan input out of range
                else System.out.print("Plan must be in range [8.0-17.5],Enter again : ");
            } else {
                System.out.print("Wrong format,Enter again : ");
            }
        }
    }
    
    

}

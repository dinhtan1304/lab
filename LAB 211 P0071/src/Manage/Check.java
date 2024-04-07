package Manage;

import Entry.Task;
import java.util.ArrayList;

public class Check {

    static boolean CanAddTaskForAssign(String Assign, String Date, String From, String To, ArrayList<Task> lt) {
        //loop for all task in list
        for (Task t : lt) {
            if (Assign.equalsIgnoreCase(t.getAssign()) && Date.equalsIgnoreCase(t.getDate())) {
                if ((Double.valueOf(From) < Double.valueOf(t.getPlanFrom()) && Double.valueOf(To) > Double.valueOf(t.getPlanFrom()))
                        ||Double.valueOf(From) >= Double.valueOf(t.getPlanFrom()) && Double.valueOf(From) < Double.valueOf(t.getPlanTo())) {
                    System.out.println("Can add this task for this Assign,Enter again.");
                    return false;
                }
               
            }
        }
        return true;
    }
}

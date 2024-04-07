package Manage;

import Entry.Task;
import java.text.ParseException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws ParseException {
        ArrayList<Task> lt = new ArrayList<>();        
        //loop until user want to exit
        while (true) {
            // Display a menu 
            ManagementProgram.displayMenu();
            //step 1 : number user selection
            int numUserSelection = ManagementProgram.numberUserSelection();
            //step 2 : perform function based on the select option. 
            switch (numUserSelection) {
                //Step 2.1:add task
                case 1:
                    ManagementProgram.addTask(lt);   
                    break;
                //Step 2.2:delete task
                case 2:
                    ManagementProgram.deleteTask(lt);
                    break;
                //Step 2.3:show task
                case 3:
                    ManagementProgram.showTask(lt);
                    break;
                //Step 2.4:Exit
                case 4:
                    return;
            }
        }
    }
}

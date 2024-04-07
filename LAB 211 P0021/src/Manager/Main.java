package Manager;

import Entry.Student;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Student> ls = new ArrayList();
        while (true) {
            // Display a menu 
            ManageStudent.displayMenu();
            //step 1 : number user selection
            int numUserSelection = ManageStudent.numberUserSelection();
            //step 2 : perform function based on the select option. 
            switch (numUserSelection) {
                //Step 2.1:create student
                case 1:
                    ManageStudent.createStudent(ls);
                    break;
                //Step 2.2:find and sort student
                case 2:
                    ManageStudent.findAndSort(ls);
                    break;
                //Step 2.3:update or delete student
                case 3:
                    ManageStudent.deleteOrUpdate(ls);
                    break;
                //Step 2.4:report 
                case 4:
                    ManageStudent.report(ls);
                    break;
                //Step 2.5:exit
                case 5:
                    return;
            }
        }
    }
}

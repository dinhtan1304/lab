package Manager;

import Entry.Report;
import Entry.Student;
import java.util.ArrayList;

public class Check {
    //check user input yes/ no
    public static boolean checkInputYN(String notice) {
        System.out.print(notice);
        //loop until user input correct
        while (true) {
            String result = Input.inputString();
            //return true if user input y/Y
            if (result.equalsIgnoreCase("Y")) {
                return true;
            }
            //return false if user input n/N
            if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.out.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }
    
    //check is student info exist in list
    public static boolean isStudentInfoExist(ArrayList<Student> ls,String id, String semester,String coursename){
        for(Student s:ls){
            if(s.getId().equalsIgnoreCase(id)&&s.getSemester().equalsIgnoreCase(semester)&&s.getCourseName().equalsIgnoreCase(coursename))
                return true;
        }
        return false;
    }
    
    //check is student report exist in list
    public static boolean isStudentReportExist(ArrayList<Report> lr,String id,String courseName){
        for(Report r: lr){
            if(r.getId().equalsIgnoreCase(id)&&r.getCourseName().equalsIgnoreCase(courseName)){
                return true;
            }
        }
        return false;
    }
            
}

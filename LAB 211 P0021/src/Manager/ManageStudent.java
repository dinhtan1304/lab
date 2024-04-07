package Manager;

import Entry.Report;
import Entry.Student;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageStudent {

    //display menu
    static void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("\t1. Create");
        System.out.println("\t2. Find and Sort");
        System.out.println("\t3. Update/Delete");
        System.out.println("\t4. Report");
        System.out.println("\t5. Exit");
        System.out.println("\n(Please choose 1 to Create, 2 to Find and Sort, 3 to Update/Delete, 4 to Report and 5 to Exit program).");
        System.out.print("Your selection : ");
    }

    // number user selection
    static int numberUserSelection() {
        return Input.inputIntInRange(1, 5);
    }

    //create student
    static void createStudent(ArrayList<Student> ls) {
        System.out.println("===============Create Student================");
        //check if have more than 10 students
        if (ls.size() >= 3) {
            System.out.println("List of student has more than 10 students.");
            if (!Check.checkInputYN("Do you want to continue (Y/N)?")) {
                System.out.println("=========================================================");
                return;
            }
        }
        //id input
        System.out.print("ID: ");
        String id = Input.inputString();
        System.out.print("Name: ");
        String name = Input.inputString();
        //update name for id
        name = nameUpdate(ls, id, name);
        String semester = "";
        String courseName = "";
        //loop until student info is not exist
        do {
            //info input
            System.out.print("Semester: ");
            semester = Input.inputString();
            System.out.println("CourseName: ");
            courseName = Input.inputCourseName();
            if (Check.isStudentInfoExist(ls, id, semester, courseName)) {
                System.out.println("This students info is exist.Enter again.");
            }
        } while (Check.isStudentInfoExist(ls, id, semester, courseName));
        ls.add(new Student(id, name, semester, courseName));
        System.out.println("==============Create Successfull=============");
        displayStudentsWithID(ls);
    }

    //find and sort
    static void findAndSort(ArrayList<Student> ls) {
        System.out.println("=======================Find and Sort=====================");
        if (ls.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("=========================================================");
            return;
        }
        //input name want to find
        System.out.print("Name want to find:");
        String nameFind = Input.inputString();
        //find student by name
        ArrayList<Student> lsf = findByName(ls, nameFind);
        //sort student by name
        sortByName(lsf);
    }

    //delete or update
    static void deleteOrUpdate(ArrayList<Student> ls) {
        System.out.println("=====================Update or delete====================");
        if (ls.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("=========================================================");
            return;
        }
        //input name want to find
        System.out.print("ID want to update or delete:");
        String Id = Input.inputString();
        //find student by name
        ArrayList<Student> lsf = findByID(ls, Id);
        displayStudentsWithID(lsf);
        if (lsf.isEmpty()) {
            return;
        }
        if (Input.InputUD("Do you want to update (U) or delete (D) student : ").equalsIgnoreCase("u")) {
            updateStudent(ls, lsf);
        } else {
            deleteStudent(ls, lsf);
        }
        displayStudentsWithID(ls);
    }

    //report
    static void report(ArrayList<Student> ls) {
        ArrayList<Report> lr = new ArrayList<>();
        System.out.println("===========================Report========================");
        if (ls.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("=========================================================");
            return;
        }
        for (Student s1 : ls) {
            int total = 0;
            if (Check.isStudentReportExist(lr, s1.getId(), s1.getCourseName())) {
            } else {
                for (Student s2 : ls) {
                    if (s1.getId().equalsIgnoreCase(s2.getId()) && s1.getCourseName().equalsIgnoreCase(s2.getCourseName())) {
                        total++;
                    }
                }
                lr.add(new Report(s1.getId(), s1.getStudentName(), s1.getCourseName(), total));
            }
        }
        displayReport(lr);
    }
    
    static String nameUpdate(ArrayList<Student> ls, String id, String name) {
        boolean isNameBelongId = true;
        String oldName = "";
        for (Student s : ls) {
            //check if name belong id
            if (s.getId().equalsIgnoreCase(id) && !s.getStudentName().equalsIgnoreCase(name)) {
                oldName = s.getStudentName();
                isNameBelongId = false;
                break;
            }
        }
        if (!isNameBelongId) {
            if (Check.checkInputYN("Do you want to update student name for this id?: ")) {
                for (Student s : ls) {
                    if (s.getId().equalsIgnoreCase(id)) {
                        s.setStudentName(name);
                    }
                }
                return name;
            } else {
                return oldName;
            }
        } else {
            return name;
        }
    }

    //find student by name
    static ArrayList<Student> findByName(ArrayList<Student> ls, String nameFind) {
        ArrayList<Student> lsf = new ArrayList<>();
        for (Student s : ls) {
            if (s.getStudentName().toLowerCase().contains(nameFind.toLowerCase())) {
                lsf.add(s);
            }
        }
        return lsf;
    }

    //find student by id
    static ArrayList<Student> findByID(ArrayList<Student> ls, String ID) {
        ArrayList<Student> lsf = new ArrayList<>();
        for (Student s : ls) {
            if (s.getId().equalsIgnoreCase(ID)) {
                lsf.add(s);
            }
        }
        return lsf;
    }

    static Comparator<Student> nameComparator = (Student s1, Student s2) -> {
        String[] name1 = s1.getStudentName().trim().split(" ");
        String[] name2 = s2.getStudentName().trim().split(" ");
        return name1[name1.length-1].compareTo(name2[name2.length-1]);

    };

    //sort student by name
    static void sortByName(ArrayList<Student> ls) {
        //sort
        Collections.sort(ls, nameComparator);
        //display students after sort
        displayStudentsWithoutID(ls);
    }

    //display list of student without ID
    static void displayStudentsWithoutID(ArrayList<Student> ls) {
        System.out.println("==================Student Information====================");
        //check if list empty
        if (ls.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("=========================================================");
            return;
        }
        System.out.printf("%-15s%-15s%-15s\n", "Student Name", "Semester", "Course Name");
        for (Student s : ls) {
            System.out.printf("%-15s%-15s%-15s\n", s.getStudentName(), s.getSemester(), s.getCourseName());
        }
        System.out.println("=========================================================");
    }

    //display list of student with ID
    static void displayStudentsWithID(ArrayList<Student> ls) {
        System.out.println("=======================Student Information=========================");
        int line = 1;
        //check if list empty
        if (ls.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("===================================================================");
            return;
        }
        System.out.printf("%-10s%-15s%-15s%-15s%-15s\n", "Line", "ID", "Student Name", "Semester", "Course Name");
        for (Student s : ls) {
            System.out.printf("%-10d%-15s%-15s%-15s%-15s\n", line++, s.getId(), s.getStudentName(), s.getSemester(), s.getCourseName());
        }
        System.out.println("===================================================================");
    }

    //display report
    static void displayReport(ArrayList<Report> lr) {
        System.out.println("=======================Report Information=========================");
        //check if list empty
        if (lr.isEmpty()) {
            System.out.println("List is empty");
            System.out.println("===================================================================");
            return;
        }
        System.out.printf("%-15s|%-5s|%-15s\n", "Student Name", "Corse", "Total");
        for (Report r : lr) {
            System.out.printf("%-15s|%-5s|%-15d\n", r.getName(), r.getCourseName(), r.getTotalCourse());
        }
        System.out.println("===================================================================");
    }

    //update student
    static void updateStudent(ArrayList<Student> ls, ArrayList<Student> lsf) {
        //input line want to update
        System.out.println("Line want to update: ");
        int line = Input.inputIntInRange(1, lsf.size());
        String id = "";
        String name = "";
        String semester = "";
        String courseName = "";
        for (Student s : ls) {
            if (s.equals(lsf.get(line - 1))) {
                //id input
                System.out.print("New ID: ");
                id = Input.inputString();
                System.out.print("New Name: ");
                name = Input.inputString();
                //update name for id
                name = nameUpdate(ls, id, name);
                //loop until student info is not exist
                do {
                    //info input
                    System.out.print("New Semester: ");
                    semester = Input.inputString();
                    System.out.println("New CourseName: ");
                    courseName = Input.inputCourseName();
                    if (Check.isStudentInfoExist(ls, id, semester, courseName)) {
                        System.out.println("This students info is exist.Enter again.");
                    }
                } while (Check.isStudentInfoExist(ls, id, semester, courseName));
            s.setId(id);
            s.setStudentName(name);
            s.setSemester(semester);
            s.setCourseName(courseName);
            break;
            }    
        }
        System.out.println("==============Update Successfull=============");
    }

    //delete student
    static void deleteStudent(ArrayList<Student> ls, ArrayList<Student> lsf) {
        //input line want to delete
        System.out.println("Line want to delete: ");
        int line = Input.inputIntInRange(1, lsf.size());
        ls.remove(lsf.get(line - 1));
        System.out.println("==============Delete Successfull=============");
    }

}

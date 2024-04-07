/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0071;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ManagementProgram {

    ArrayList<Task> listTasks = new ArrayList<>();
//    int NOT_EXIST = -1;
//    Scanner sc = new Scanner(System.in);

    public ManagementProgram() {
        listTasks = new ArrayList<>();

    }

    void addTask() throws IOException {
        System.out.println("------------Add Task---------------");
        String name = Input.getString("Requirement Name: ", "Input  include letter ", "[a-zA-Z ]+");
        int type = Input.getInt("Task Type: ", "Option[1-4]", 4);
        Date date = Input.getdate("Date:", "Invalid Date, please re-enter");
        double from;
        while (true) {
            from = Input.getDouble("From:", "Input  include  digists");
            if (from < 8 || from > 17.5) {
                System.out.println("Time from 8h to 17h30");
                continue;
            } else {
                break;
            }
        }
        double to;
        //loop to > from

        while (true) {
            to = Input.getDouble("To:", "Input  include  digists");
            if (to < 8 || to > 17.5) {
                System.out.println("Time from 8h to 17h30");
                continue;
            } else {
                if (to <= from) {
                    System.out.println("To must be more from");
                    continue;
                } else {
                    break;
                }
            }
        }
        String assignee = Input.getString("Assignee: ", "Input  include letter ", "[a-zA-Z ]+");
        String reviewer = Input.getString("Reviewer: ", "Input  include letter ", "[a-zA-Z ]+");

        String[] listType = {"Code", "Test", "Design", "Review"};

        Task task = new Task(name, listType[(type - 1)], date, (to - from), assignee, reviewer);
        listTasks.add(task);
//        System.out.println("ID" + "\t" + "Name" + "\t" + "Task Type" + "\t" + "Date" + "\t" + "Time" + "\t" + "Assignee" + "\t" + "Reviewer");
//        System.out.println(task.toString());
        System.out.println("Add Task Successfull");
    }

    void deleteTask() throws IOException {
        System.out.println("---------Del Task------");
        //check empty list
        if (listTasks.isEmpty()) {
            System.out.println("List Empty!");
        } else {
            //check Id 
            boolean check = true;
            while (check) {
                int code = Input.getInt("ID: ", "Input  include letter ", Integer.MAX_VALUE);
                //loop to add id in list tasks

                for (Task listTask : listTasks) {
                    if (listTask.getId() == code) {
                        listTasks.remove(listTask);
                        check = false;
                        break;
                    } else {
                        continue;
                    }
                }
                if (check) {
                    System.out.println("Don't have ID");
                } else {
                    System.out.println("Delete Task Successfull");
                }
            }

        }
    }

    void getDataTasks() {
        System.out.println("----------------------------------------- Task ---------------------------------------");
        System.out.println("ID" + "\t" + "Name" + "\t" + "Task Type" + "\t" + "Date" + "\t" + "\t" + "Time" + "\t" + "Assignee" + "\t" + "Reviewer");
        //loop to add id in list tasks
        for (Task listTask : listTasks) {
            System.out.println(listTask.toString());
        }
    }

}

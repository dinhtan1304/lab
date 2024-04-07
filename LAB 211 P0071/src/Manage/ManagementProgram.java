package Manage;

import Entry.Task;
import java.text.ParseException;
import java.util.ArrayList;

class ManagementProgram {

    // Display a menu 
    static void displayMenu() {
        System.out.println("========= Task program ========");
        System.out.println("   .   Add Task");
        System.out.println("   .   Delete task");
        System.out.println("   .   Display Task");
        System.out.println("   .   exit");
        System.out.print("Enter your choice[1,4]: ");
    }

    //number user selection
    static int numberUserSelection() {
        return Input.inputIntInRange(1, 4);
    }

    //add task
    static void addTask(ArrayList<Task> lt) throws ParseException {

        System.out.println("------------Add Task--------------");
        //set Id = 1 if list is empty
//        int id;
//        if (lt.isEmpty()) {
//            id = 1;
//        } //set id for task : id = id last task + 1 if list is not empty
//        else {
//            id = lt.get(lt.size() - 1).getId() + 1;
//        }
        //requirement input
        System.out.print("Requirement Name: ");
        String requirementName = Input.inputString();
        //task style input
        System.out.print("Task Type: ");
        String taskTypeId = Input.inputTaskTypeId();
        //date input
        System.out.print("Date: ");
        String date = Input.inputDate();
        String planFrom = "";
        String planTo = "";
        //loop until plan to higher than plan from
        do {
            //plan from input
            System.out.print("From: ");
            planFrom = Input.inputPlan();
            //plan to input
            System.out.print("To: ");
            planTo = Input.inputPlan();
            if (Double.valueOf(planFrom) >= Double.valueOf(planTo)) {
                System.out.println("Plan from must be lower than plan to");
            }
        } while (Double.valueOf(planFrom) >= Double.valueOf(planTo));
        //assignee input
        System.out.print("Assignee: ");
        String assign = Input.inputString();
        //loop until can add task for assign
        while (!Check.CanAddTaskForAssign(assign, date, planFrom, planTo, lt)) {
            //loop until can adđ task for assign
            do {
                //plan from input
                System.out.print("From: ");
                planFrom = Input.inputPlan();
                //plan to input
                System.out.print("To: ");
                planTo = Input.inputPlan();
                if (Double.valueOf(planFrom) >= Double.valueOf(planTo)) {
                    System.out.println("Plan from must be lower than plan to");
                }
            } while (Double.valueOf(planFrom) >= Double.valueOf(planTo) || !Check.CanAddTaskForAssign(assign, date, planFrom, planTo, lt));
        }
        //reviewer input
        System.out.print("Reviewer: ");
        String reviewer = Input.inputString();
        //add task to the list
        Task task = new Task(requirementName, taskTypeId, date, planFrom, planTo, assign, reviewer);
        lt.add(task);
        System.out.println("---------Add Task Success---------");
    }

    //delete task
    static void deleteTask(ArrayList<Task> lt) {
        System.out.println("-------------Del Task-------------");
        //check if list empty
        if (lt.isEmpty()) {
            System.out.println("The List is empty");
            System.out.println("----------------------------------");
            return;
        }
        String id = "";
        boolean isIdExist = false;
        //loop until can delete task
        do {
            System.out.print("ID: ");
            id = Input.inputString();
            isIdExist = false;
            //check if id is in list
            for (Task t : lt) {
                if (id.equalsIgnoreCase(String.valueOf(t.getId()))) {
                    lt.remove(t);
                    isIdExist = true;
                    break;
                }
            }
            if (!isIdExist) {
                System.out.println("Id is not found,Enter Again");
            }
        } while (!isIdExist);
        System.out.println("----------Delete Success----------");
    }

    //show task
    static void showTask(ArrayList<Task> lt) {
        System.out.println("--------------------------------------- Task -------------------------------------------");
        //check if list empty
        if (lt.isEmpty()) {
            System.out.println("The List is empty");
            System.out.println("----------------------------------------------------------------------------------------");
            return;
        }
        System.out.printf("%-5s%-15s%-15s%-15s%-15s%-15s%-15s\n",
                "ID", "Name", "Task Type", "Date", "Time", "Assign", "Reviewer");
        //loop for all element of list
        for (int i = 0; i < lt.size(); i++) {
            //display task info 
            System.out.printf("%-5d%-15s%-15s%-15s%-15.1f%-15s%-15s\n",
                    lt.get(i).getId(),
                    lt.get(i).getRequirementName(),
                    lt.get(i).getTaskTypeId(),
                    lt.get(i).getDate(),
                    Double.parseDouble(lt.get(i).getPlanTo()) - Double.parseDouble(lt.get(i).getPlanFrom()),
                    lt.get(i).getAssign(),
                    lt.get(i).getReviewer()
            );
        }
    }
}

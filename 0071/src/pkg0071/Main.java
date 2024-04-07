/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg0071;

import java.io.IOException;

/**
 *
 * @author ADMIN
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ManagementProgram managament = new ManagementProgram();
        while (true) {
            //Function 1: Display a menu and ask users to select an option.
            int option = showmenu();

            switch (option) {
                //Step1: Add Task
                case 1: {
                    managament.addTask();
                    continue;
                }
                //Step2: Delete Task
                case 2: {
                    managament.deleteTask();
                    continue;
                }
                //Step3: Show task
                case 3: {
                    managament.getDataTasks();
                    continue;
                }
                //Step4: Exit the program.
                case 4: {
                    System.exit(0);
                }

            }
        }
    }

    private static int showmenu() throws IOException {

        System.out.println("========= Task program ==========");
        System.out.println("1.\tAdd Task\n"
                + "2.\tDelete task\n"
                + "3.\tDisplay Task\n"
                + "4.\texit");
        int option = Input.getInt("Enter option: ", "Option[1-4]", 4);
        return option;
    }
}

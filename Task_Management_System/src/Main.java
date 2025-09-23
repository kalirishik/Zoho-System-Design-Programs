import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TaskManager taskManager=new TaskManager();
        System.out.println("Welcome to Task Management System");
        while(true){
            System.out.println("\n  1.Add Task \n  2.View Task\n  3.View Task By Priority\n  4.View Task By Category\n  5.Exit");
            System.out.print("Enter Option: ");
            int choice=sc.nextInt();
            switch(choice){
                case 1:
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.viewTask();
                    break;
                case 3:
                    taskManager.viewTaskByPriority();
                    break;
                case 4:
                    taskManager.viewTaskByCategory();
                    break;
                case 5:
                    System.out.println("Thanks For Using Task Management System");
                    System.exit(0);
                default:
                    System.out.println("Enter Correct Option");
            }
        }
    }
}
import java.util.Scanner;

public class TicketBooking {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        TicketSystem ticketSystem=new TicketSystem();
        while(true){
            System.out.println("Railway Booking System\n" +
                    "   1. Book Ticket\n" +
                    "   2. Cancel Ticket\n" +
                    "   3. View Confirmed Tickets\n" +
                    "   4. View Available Tickets\n" +
                    "   5. View RAC Tickets\n" +
                    "   6. View Waiting List Tickets\n" +
                    "   7. Exit");
            System.out.print("Enter your Choice (1-7): ");
            int op=sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.print("Enter Name: ");
                    String name=sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age=sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Gender(Male/Female): ");
                    String gender=sc.nextLine();
                    System.out.print("Enter Berth Preference(L/U/M): ");
                    String berthPreference=sc.nextLine();
                    ticketSystem.bookTicket(name,age,gender,berthPreference);
                    break;
                case 2:
                    System.out.print("Enter Ticket Id: ");
                    String ticketId=sc.next();
                    ticketSystem.cancelTicket(ticketId);
                    break;
                case 3:
                    ticketSystem.viewConfirmedTickets();
                    break;
                case 4:
                    ticketSystem.viewAvailableTickets();
                    break;
                case 5:
                    ticketSystem.viewRACTickets();
                    break;
                case 6:
                    ticketSystem.viewWaitingListTickets();
                    break;
                case 7:
                    System.out.println("Thanks For Using The Application");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Option(1-7)");
            }
        }
    }
}

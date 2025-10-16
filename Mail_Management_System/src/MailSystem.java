import java.util.Scanner;

public class MailSystem {
    public static void main(String[] args) {
        MailManagementSystem mailManagementSystem=new MailManagementSystem();
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("------ Mail Management System -------");
            System.out.println(" 1. Store Mail\n" +
                               " 2. Delete Mail\n" +
                               " 3. Add Tag\n" +
                               " 4. Show Stats\n" +
                               " 5. Search\n" +
                               " 6. Wild Card Search\n" +
                               " 7. Exit");
            System.out.print("Enter Choice(1-7): ");
            int option=sc.nextInt();
            sc.nextLine();
            switch(option){
                case 1:
                    System.out.print("Enter Sender Mail: ");
                    String senderMail=sc.next();
                    System.out.print("Enter Receiver Mail: ");
                    String receiverMail=sc.next();
                    sc.nextLine();
                    System.out.print("Enter Subject: ");
                    String subject=sc.nextLine();
                    System.out.print("Enter Content: ");
                    String content=sc.nextLine();
                    mailManagementSystem.storeMail(senderMail,receiverMail,subject,content);
                    break;
                case 2:
                    System.out.print("Enter The Mail Index: ");
                    int deleteIndex=sc.nextInt();
                    mailManagementSystem.deleteMail(deleteIndex);
                    break;
                case 3:
                    System.out.print("Enter The Mail Index: ");
                    int addTagIndex=sc.nextInt();
                    mailManagementSystem.addTag(addTagIndex);
                    break;
                case 4:
                    mailManagementSystem.showStats();
                    break;
                case 5:
                    System.out.print("Enter The Word To Search: ");
                    String searchWord=sc.nextLine();
                    mailManagementSystem.search(searchWord.toLowerCase());
                    break;
                case 6:
                    System.out.print("Enter WildCard Pattern (use * for any Characters): ");
                    String wildCardSearchWord=sc.nextLine();
                    mailManagementSystem.wildCardSearch(wildCardSearchWord.toLowerCase());
                    break;
                case 7:
                    System.out.println("Thanks For Using.");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Choice: (1-7)");
            }
        }
    }
}

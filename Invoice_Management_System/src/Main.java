import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        InvoiceService invoiceService=new InvoiceService();
        while(true){
            System.out.println("----- Invoice Management System -----");
            System.out.println(" 1. Add a Customer\n 2. Add an Invoice\n 3. Add Items to an Invoice\n" +
                    " 4. List All Customers\n 5. List All Invoices\n 6. List All Invoices of a Customer\n" +
                    " 7. Display the Full Details of an Invoices\n 8.Exit");
            System.out.print("Choose An Option(1-8): ");
            int opt=sc.nextInt();
            sc.nextLine();
            switch (opt){
                case 1:
                    System.out.print("Enter Customer ID: ");
                    String cusID=sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cusName=sc.nextLine();
                    invoiceService.addCustomer(cusID,cusName);
                    break;
                case 2:
                    System.out.print("Enter Invoice ID: ");
                    String invID=sc.nextLine();
                    System.out.print("Enter Customer ID: ");
                    String invCusID=sc.nextLine();;
                    invoiceService.addInvoice(invID,invCusID);
                    break;
                case 3:
                    System.out.print("Enter Invoice ID: ");
                    String invItemID=sc.nextLine();
                    System.out.print("Enter Item Name: ");
                    String itemName=sc.nextLine();
                    System.out.print("Enter Item Quantity: ");
                    int itemQuantity=sc.nextInt();
                    System.out.print("Enter Item Price: ");
                    double itemPrice=sc.nextDouble();
                    invoiceService.addItemsToInvoice(invItemID,itemName,itemQuantity,itemPrice);
                    break;
                case 4:
                    invoiceService.listAllCustomers();
                    break;
                case 5:
                    invoiceService.listAllInvoices();
                    break;
                case 6:
                    System.out.print("Enter Customer ID: ");
                    String invOfCusID=sc.nextLine();
                    invoiceService.listAllInvoiceOfCustomer(invOfCusID);
                    break;
                case 7:
                    System.out.print("Enter Invoice ID: ");
                    String invDetailsID=sc.nextLine();
                    invoiceService.listAllInvoiceDetails(invDetailsID);
                    break;
                case 8:
                    System.out.print("Thanks For Visiting.");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Option(1-8)");

            }
        }
    }
}
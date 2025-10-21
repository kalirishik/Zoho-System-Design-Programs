import java.util.*;
public class InvoiceService {
    Map<String, Customer> customers;
    Map<String, Invoice> invoices;

    public InvoiceService() {
        this.customers = new HashMap<>();
        this.invoices = new HashMap<>();
    }

    public void addCustomer(String cusID, String cusName) {
        if(customers.containsKey(cusID))
            System.out.println("Customer Id Already Added.");
        else{
            customers.put(cusID,new Customer(cusID,cusName));
            System.out.println("Customer Added Successfully.");
        }
    }

    public void addInvoice(String invID, String invCusID) {
        if(!customers.containsKey(invCusID)){
            System.out.println("Customer Id Not Found");
            return;
        }
        if(invoices.containsKey(invID))
            System.out.println("Invoice Id Already Added.");
        else{
            invoices.put(invID,new Invoice(invID,invCusID));
            System.out.println("Invoice Added Successfully.");
        }
    }

    public void addItemsToInvoice(String invItemID, String itemName, int itemQuantity, double itemPrice) {
        Invoice invoice=invoices.get(invItemID);
        if(invoice==null){
            System.out.println("Invoice Not Found");
            return;
        }
        invoice.items.add(new Item(itemName,itemQuantity,itemPrice));
        System.out.println("Items Added to Invoice");
    }


    public void listAllCustomers() {
        if(customers.size()==0){
            System.out.println("No Customer");
            return;
        }
        for(Customer customer:customers.values()){
            System.out.println("Customer Id: "+customer.getCusId()+", Customer Name: "+customer.getCusName());
        }
    }

    public void listAllInvoices() {
        if(invoices.size()==0){
            System.out.println("No Invoice");
            return;
        }
        for(Invoice invoice:invoices.values()){
            System.out.println("Invoice ID: "+invoice.getInvId()+", Customer ID: "+invoice.getCusId());
        }
    }

    public void listAllInvoiceOfCustomer(String invOfCusID) {
        boolean found=false;
        System.out.println("--- Invoices for Customer ID: "+invOfCusID);
        for(Invoice invoice:invoices.values()){
            if(invoice.getCusId().equals(invOfCusID)){
                System.out.println("Invoice ID: "+invoice.getInvId());
                found=true;
            }
        }
        if(!found)
            System.out.println("No Invoice of Customer");
    }

    public void listAllInvoiceDetails(String invDetailsID) {
        Invoice invoice=invoices.get(invDetailsID);
        if(invoice==null){
            System.out.println("Invoice Not Found");
            return;
        }
        if(invoice.items.size()==0){
            System.out.println("No Items in Invoice ID: "+invDetailsID);
        }
        else{
            double total=0;
            System.out.println("--- Invoice Details ---");
            System.out.println("Invoice  ID: "+invoice.getInvId());
            System.out.println("Customer ID: "+invoice.getCusId());
            System.out.println("Items: ");
            for(Item item: invoice.items){
                    System.out.println("- "+item.getItemName()+": "+item.getItemQuantity()+" x "
                    +item.getPrice()+" = "+(item.getItemQuantity()* item.getPrice()));
                    total+= item.getItemQuantity()* item.getPrice();
            }
            System.out.println("  Total Amount: "+total);
        }
    }
}

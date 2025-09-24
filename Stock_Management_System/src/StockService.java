import java.util.*;

public class StockService {
    Scanner sc=new Scanner(System.in);
    int productId=1;
    int transactionId=1;
    Map<Integer,Product> products=new HashMap<>();
    List<Transaction> transactions = new ArrayList<>();
    public void addProduct(){
        System.out.print("Enter Product Name: ");
        String productName=sc.nextLine();
        System.out.print("Enter Category: ");
        String category=sc.nextLine();
        System.out.print("Enter Quantity: ");
        int quantity=sc.nextInt();
        System.out.print("Enter Price Per Unit: ");
        int pricePerUnit=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Supplier Name: ");
        String supplierName=sc.nextLine();
        products.put(productId,new Product(productId,productName,category,quantity,pricePerUnit,supplierName));
        productId++;
        System.out.println("Product Added Successfully");
    }
    public void searchProducts(){
        while(true){
            System.out.println("  1. Search By ProductId\n  2. Search By Product Name\n  3. Search By Category\n  4. Exit");
            System.out.print("Enter Option (1-4):");
            int option=sc.nextInt();
            boolean found = false;
            switch(option){
                case 1:
                    System.out.print("Enter Product Id: ");
                    int productId=sc.nextInt();
                    for(Product product: products.values()){
                        if(product.getProductId()==productId){
                            found=true;
                            displayProduct(product);
                            break;
                        }
                    }
                    if(!found)
                        System.out.println("Product Id Not Found");
                    break;
                case 2:
                    System.out.print("Enter Product Name: ");
                    sc.nextLine();
                    String productName=sc.nextLine();
                    for(Product product: products.values()){
                        if(product.getProductName().equalsIgnoreCase(productName)){
                            found=true;
                            displayProduct(product);
                        }
                    }
                    if(!found)
                        System.out.println("Product Name Not Found");
                    break;
                case 3:
                    System.out.print("Enter Category: ");
                    sc.nextLine();
                    String category=sc.nextLine();
                    for(Product product: products.values()){
                        if(product.getCategory().equalsIgnoreCase(category)){
                            found=true;
                            displayProduct(product);
                        }
                    }
                    if(!found)
                        System.out.println("Category Not Found");
                    break;
                case 4:
                    System.out.println("Exiting search...");
                    sc.nextLine();
                    return;
                default:
                    System.out.println("Enter Valid Option (1-4)");
            }
        }
    }
    private void displayProduct(Product product) {
        System.out.printf(
                "Product Id: %-2d | Product Name: %-8s | Category: %-8s | Quantity: %-3d" +
                        " | Price Per Unit: %-7d | Supplier Name: %-8s\n",
                product.getProductId(),
                product.getProductName(),
                product.getCategory(),
                product.getQuantity(),
                product.getPricePerUnit(),
                product.getSupplierName()
        );
    }

    public void updateStockQuantity(){
        System.out.print("Enter Product Id: ");
        int productId=sc.nextInt();
        if(!products.containsKey(productId)){
                System.out.println("Product Id Not Found");
                return;
        }
        Product product=products.get(productId);
        while(true){
            System.out.println("  1.Add Quantity\n  2.Remove Quantity\n  3.Exit\n");
            System.out.print("Enter Option (1-3): ");
            int op=sc.nextInt();
            switch (op){
                case 1:
                    System.out.print("Enter Quantity: ");
                    int addQuantity=sc.nextInt();
                    product.setQuantity(product.getQuantity()+addQuantity);
                    System.out.println("Quantity Updated Successfully!");
                    break;
                case 2:
                    System.out.print("Enter Quantity to Remove: ");
                    int removeQty = sc.nextInt();
                    if(removeQty > product.getQuantity()){
                        System.out.println("Insufficient stock. Cannot remove more than available.");
                    } else {
                        product.setQuantity(product.getQuantity() - removeQty);
                        System.out.println("Quantity Updated Successfully!");
                    }
                    break;
                case 3:
                    System.out.println("Exiting Update Stock Quantity...");
                    return;
                default:
                    System.out.println("Enter Valid Option (1-3)");
            }
        }
    }
    public void trackSalesAndPurchases() {
        System.out.print("Enter Product Id: ");
        int pid = sc.nextInt();

        if (!products.containsKey(pid)) {
            System.out.println("Product Id Not Found");
            return;
        }
        Product product = products.get(pid);
        while(true){
            System.out.println("  1. Record Sale\n  2. Record Purchase\n  3.Exit");
            System.out.print("Enter Option (1-3): ");
            int option = sc.nextInt();
            int qty=0;
            Date date = new Date();
            String type = "";
            switch (option){
                case 1:
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    if (qty > product.getQuantity()) {
                        System.out.println("Insufficient stock for sale.");
                        return;
                    }
                    product.setQuantity(product.getQuantity() - qty);
                    type = "Sale";
                    break;
                case 2:
                    System.out.print("Enter Quantity: ");
                    qty = sc.nextInt();
                    product.setQuantity(product.getQuantity() + qty);
                    type = "Purchase";
                    break;
                default:
                    System.out.println("Invalid option.");
                    return;
            }
            Transaction transaction = new Transaction(transactionId++, pid, type, qty, date);
            transactions.add(transaction);
            System.out.println("Transaction Recorded Successfully!");
            System.out.println(transaction);
        }
    }

    public void viewTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No Transactions Recorded Yet.");
            return;
        }
        System.out.println("---- Transaction History ----");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
    public void generateReports() {
        Scanner sc = new Scanner(System.in);
        System.out.println("  1. Low Stock Alert\n  2. Sales Report\n  3. Purchase Report\n  4. Exit");
        System.out.print("Enter Option (1-4): ");
        int option = sc.nextInt();

        switch(option) {
            case 1: // Low Stock Alert
                int threshold = 5; // You can also take input from user
                System.out.println("---- Low Stock Alert (Below " + threshold + ") ----");
                boolean found = false;
                for(Product p : products.values()) {
                    if(p.getQuantity() < threshold) {
                        displayProduct(p);
                        found = true;
                    }
                }
                if(!found) System.out.println("No products below threshold.");
                break;

            case 2: // Sales Report
                System.out.println("---- Sales Report ----");
                Map<Integer, Integer> salesMap = new HashMap<>();
                for(Transaction t : transactions) {
                    if(t.getType().equalsIgnoreCase("Sale")) {
                        salesMap.put(t.getProductId(),
                                salesMap.getOrDefault(t.getProductId(), 0) + t.getQuantity());
                    }
                }
                if(salesMap.isEmpty()) {
                    System.out.println("No sales recorded.");
                } else {
                    for(Integer pid : salesMap.keySet()) {
                        Product p = products.get(pid);
                        System.out.println("Product: " + p.getProductName() + " | Quantity Sold: " + salesMap.get(pid));
                    }
                }
                break;

            case 3: // Purchase Report
                System.out.println("---- Purchase Report ----");
                Map<Integer, Integer> purchaseMap = new HashMap<>();
                for(Transaction t : transactions) {
                    if(t.getType().equalsIgnoreCase("Purchase")) {
                        purchaseMap.put(t.getProductId(),
                                purchaseMap.getOrDefault(t.getProductId(), 0) + t.getQuantity());
                    }
                }
                if(purchaseMap.isEmpty()) {
                    System.out.println("No purchases recorded.");
                } else {
                    for(Integer pid : purchaseMap.keySet()) {
                        Product p = products.get(pid);
                        System.out.println("Product: " + p.getProductName() + " | Quantity Purchased: " + purchaseMap.get(pid));
                    }
                }
                break;

            case 4:
                System.out.println("Exiting Reports...");
                return;

            default:
                System.out.println("Enter Valid Option (1-4)");
        }
    }

    public void updateProductDetails(){
        System.out.print("Enter Product Id: ");
        int productId=sc.nextInt();
        if(!products.containsKey(productId)){
            System.out.println("Product Id Not Found");
            return;
        }
        Product product=products.get(productId);
        while(true){
            System.out.println("  1.Modify Product Name\n  2.Modify Category\n  3.Modify Supplier Name\n" +
                    "  4.Modify Price\n  5.Exit");
            System.out.print("Enter Option (1-5): ");
            int op=sc.nextInt();
            sc.nextLine();
            switch (op){
                case 1:
                    System.out.print("Enter Product Name: ");
                    String productName=sc.nextLine();
                    product.setProductName(productName);
                    System.out.println("Product Name Updated Successfully!");
                    break;
                case 2:
                    System.out.print("Enter Category: ");
                    String category=sc.nextLine();
                    product.setCategory(category);
                    System.out.println("Category Updated Successfully!");
                    break;
                case 3:
                    System.out.print("Enter Supplier Name: ");
                    String supplierName=sc.nextLine();
                    product.setSupplierName(supplierName);
                    System.out.println("Supplier Name Updated Successfully!");
                    break;
                case 4:
                    System.out.print("Enter Product Price: ");
                    int productPrice=sc.nextInt();
                    product.setPricePerUnit(productPrice);
                    System.out.println("Product Price Updated Successfully!");
                    break;
                case 5:
                    System.out.println("Exiting Update Product Details...");
                    return;
                default:
                    System.out.println("Enter Valid Option (1-5)");
            }
        }
    }
}

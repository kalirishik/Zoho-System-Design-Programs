import java.util.Scanner;

public class StockManagementSystem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StockService stockService=new StockService();
        System.out.println("          Welcome To Task Management System");
        while(true){
            System.out.println("  1. Add New Product To Inventory\n  2. Update Stock Quantity\n  3. Search Product\n" +
                    "  4. Track Sales and Purchases\n  5. View Transactions\n" +
                    "  6. Generate Reports\n  7. Update Product Details\n  8. Exit");
            System.out.print("Enter Option (1-8): ");
            int option=sc.nextInt();
            switch (option){
                case 1:
                    stockService.addProduct();
                    break;
                case 2:
                    stockService.updateStockQuantity();
                    break;
                case 3:
                    stockService.searchProducts();
                    break;
                case 4:
                    stockService.trackSalesAndPurchases();
                    break;
                case 5:
                    stockService.viewTransactions();
                    break;
                case 6:
                    stockService.generateReports();
                    break;
                case 7:
                    stockService.updateProductDetails();
                    break;
                case 8:
                    System.out.println("Thanks For Using Stock Management System");
                    System.exit(0);
                default:
                    System.out.println("Enter Valid Option (1-8):");
            }
        }
    }
}
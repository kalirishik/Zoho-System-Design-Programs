import java.util.*;
class Transaction {
    private int transactionId;
    private int productId;
    private String type;  // Sale or Purchase
    private int quantity;
    private Date date;

    public Transaction(int transactionId, int productId, String type, int quantity, Date date) {
        this.transactionId = transactionId;
        this.productId = productId;
        this.type = type;
        this.quantity = quantity;
        this.date = date;
    }

    public int getTransactionId() { return transactionId; }
    public int getProductId() { return productId; }
    public String getType() { return type; }
    public int getQuantity() { return quantity; }
    public Date getDate() { return date; }

    @Override
    public String toString() {
        return String.format(
                "TransactionId: %-2d | ProductId: %-2d | Type: %-9s | Quantity: %-3d | Date: %s",
                transactionId, productId, type, quantity, date
        );
    }
}
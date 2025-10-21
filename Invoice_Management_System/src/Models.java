import java.util.*;
public class Models {
}
class Customer{
    String cusId;
    String cusName;

    public Customer(String cusId, String cusName) {
        this.cusId = cusId;
        this.cusName = cusName;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
}

class Item{
    String itemName;
    int itemQuantity;
    double price;

    public Item(String itemName, int itemQuantity, double price) {
        this.itemName = itemName;
        this.itemQuantity = itemQuantity;
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

class Invoice{

    String invId;
    String cusId;
    List<Item> items;

    public Invoice(String invId, String cusId) {
        this.invId = invId;
        this.cusId = cusId;
        this.items=new ArrayList<>();
    }

    public double calculateTotal(){
        double total=0;
        for(Item item:items){
            total+= item.getPrice() * item.getItemQuantity();
        }
        return total;
    }

    public String getInvId() {
        return invId;
    }

    public void setInvId(String invId) {
        this.invId = invId;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }
}
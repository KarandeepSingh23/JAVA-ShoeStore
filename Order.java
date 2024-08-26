import java.util.Date;

public class Order {
    private Shoe shoe;
    private int quantity;
    private Date date;
    private String type; 
    private String status;

    public Order(Shoe shoe, int quantity) {
        this.shoe = shoe;
        this.quantity = quantity;
        this.date = new Date();
        this.type = "Customer";
        this.status = "Pending";
    }

    public Order(Shoe shoe, int quantity, String type) {
        this.shoe = shoe;
        this.quantity = quantity;
        this.date = new Date();
        this.type = type;
        this.status = "Pending";
    }

    public Shoe getShoe() {
        return shoe;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void processOrder() {
        if (type.equals("Customer")) {
            if (shoe.getQuantityInStock() >= quantity) {
                shoe.setQuantityInStock(shoe.getQuantityInStock() - quantity);
                status = "Processed";
                System.out.println("Customer order processed successfully.");
            } else {
                status = "Insufficient Stock";
                System.out.println("Customer order failed: Insufficient stock.");
            }
        } else if (type.equals("Supplier")) {
            shoe.setQuantityInStock(shoe.getQuantityInStock() + quantity);
            status = "Processed";
            System.out.println("Supplier order processed successfully.");
        }
    }

    @Override
    public String toString() {
        return String.format("Order [Shoe: %s, Quantity: %d, Date: %s, Type: %s, Status: %s]",
                shoe, quantity, date, type, status);
    }
}

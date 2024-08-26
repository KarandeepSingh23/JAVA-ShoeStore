import java.util.ArrayList;
import java.util.HashMap;

public class ShoeStore {
    private HashMap<String, ArrayList<Shoe>> inventory;

    public ShoeStore() {
        this.inventory = new HashMap<>();
    }

    public void addShoesToInventory(Shoe shoe) {
        inventory.computeIfAbsent(shoe.getBrand(), k -> new ArrayList<>()).add(shoe);
    }

    public void checkAndPlaceSupplierOrders(int minStockThreshold, int orderQuantity) {
        for (String brand : inventory.keySet()) {
            for (Shoe shoe : inventory.get(brand)) {
                if (shoe.getQuantityInStock() < minStockThreshold) {
                    System.out.println("Supplier order processed. Additional stock received.");
                    addShoesToInventory(new Shoe(shoe.getSize(), shoe.getColor(), shoe.getBrand(),
                            shoe.getModel(), orderQuantity, 0.0));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("ShoeStore Inventory:\n");
        for (ArrayList<Shoe> shoes : inventory.values()) {
            for (Shoe shoe : shoes) {
                result.append(shoe).append("\n");
            }
        }
        return result.toString();
    }

    public ArrayList<Shoe> searchShoes(String brand, String modelName, int size, String color) {
        ArrayList<Shoe> searchResults = new ArrayList<>();

        for (ArrayList<Shoe> shoes : inventory.values()) {
            for (Shoe shoe : shoes) {
                if (shoe.getBrand().equalsIgnoreCase(brand) &&
                    shoe.getModel().toString().equalsIgnoreCase(modelName) &&
                    shoe.getSize() == size &&
                    shoe.getColor().equalsIgnoreCase(color)) {
                    searchResults.add(shoe);
                }
            }
        }

        return searchResults;
    }


    public void processCustomerOrder(Shoe shoe, int quantityToPurchase) {
        if (shoe.getQuantityInStock() >= quantityToPurchase) {
            shoe.setQuantityInStock(shoe.getQuantityInStock() - quantityToPurchase);
            System.out.println("Purchase successful!");
        } else {
            System.out.println("Invalid purchase: Insufficient stock.");
        }
    }

    public void addStock(String brand, String model, int size, String color, int quantity) {
        for (ArrayList<Shoe> shoes : inventory.values()) {
            for (Shoe shoe : shoes) {
                if (shoe.getBrand().equalsIgnoreCase(brand) &&
                    shoe.getModel().toString().equalsIgnoreCase(model) &&
                    shoe.getSize() == size &&
                    shoe.getColor().equalsIgnoreCase(color)) {
                    shoe.setQuantityInStock(shoe.getQuantityInStock() + quantity);
                    System.out.println("Stock added successfully!");
                    return; 
                }
            }
        }
                System.out.println("Shoe not found in inventory. Unable to add stock.");
    }



}

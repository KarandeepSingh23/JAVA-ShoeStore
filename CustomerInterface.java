import java.util.ArrayList;
import java.util.Scanner;

public class CustomerInterface {
    private Scanner scanner;
    private ShoeStore shoeStore;

    public CustomerInterface(ShoeStore shoeStore) {
        this.scanner = new Scanner(System.in);
        this.shoeStore = shoeStore;
    }

    public void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n===== Johnny's Kickz =====");
            System.out.println("1. Search for Shoes");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    searchForShoes();
                    break;
                case 2:
                    exit = true;
                    System.out.println("Exiting Shop. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void searchForShoes() {
        System.out.println("\n===== Search for Shoes =====");
        System.out.print("Enter brand: ");
        String brand = scanner.nextLine();
        System.out.print("Enter model: ");
        String modelName = scanner.nextLine();
        System.out.print("Enter size: ");
        int size = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter color: ");
        String color = scanner.nextLine();

        ArrayList<Shoe> searchResults = shoeStore.searchShoes(brand, modelName, size, color);

        if (searchResults == null || searchResults.isEmpty()) {
            System.out.println("No matching shoes found.");
        } else {
            System.out.println("Search results:");
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }

            System.out.print("Do you want to purchase a shoe? (y/n): ");
            String purchaseDecision = scanner.nextLine();

            if (purchaseDecision.equalsIgnoreCase("y")) {
                System.out.print("Confirm the shoe by entring the # to purchase:\n");
                int selectedShoeIndex = scanner.nextInt();
                scanner.nextLine(); 
                System.out.print("Enter the quantity you want to purchase: ");
                int quantityToPurchase = scanner.nextInt();

                if (selectedShoeIndex > 0 && selectedShoeIndex <= searchResults.size()) {
                    shoeStore.processCustomerOrder(searchResults.get(selectedShoeIndex - 1), quantityToPurchase);
                } else {
                    System.out.println("Invalid shoe selection.");
                }
            }
        }
    }
}

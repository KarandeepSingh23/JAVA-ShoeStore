import java.util.Scanner;

public class SupplierInterface {
    private ShoeStore shoeStore;

    public SupplierInterface(ShoeStore shoeStore) {
        this.shoeStore = shoeStore;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Management Shop =====");
            System.out.println("1. Add Stock");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStock();
                    break;
                case 2:
                    System.out.println("Exiting supplier interface. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }

        } while (choice != 2);
    }

    private void addStock() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the brand of the shoe: ");
        String brand = scanner.nextLine();

        System.out.print("Enter the model of the shoe: ");
        String model = scanner.nextLine();

        System.out.print("Enter the size of the shoe: ");
        int size = scanner.nextInt();

        System.out.print("Enter the color of the shoe: ");
        scanner.nextLine(); 
        String color = scanner.nextLine();

        System.out.print("Enter the quantity to add to stock: ");
        int quantity = scanner.nextInt();

        shoeStore.addStock(brand, model, size, color, quantity);
        System.out.println("Stock added successfully.");
    }

    public void returnToCustomerInterface() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Returning to Customer Interface...");
        Main.simulateCustomerPurchase(shoeStore);
    }
}

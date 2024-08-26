import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ShoeStore shoeStore = new ShoeStore();
        initializeModelsAndShoes(shoeStore);

        System.out.println("Initial ShoeStore Inventory:");
        System.out.println(shoeStore);

        simulateCustomerPurchase(shoeStore);

        System.out.println("\nUpdated ShoeStore Inventory:");
        System.out.println(shoeStore);

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the password to access the Supplier Interface: ");
        String password = scanner.nextLine();

        if (password.equals("password")) {
            SupplierInterface supplierInterface = new SupplierInterface(shoeStore);
            supplierInterface.displayMenu();

            System.out.println("\nFinal ShoeStore Inventory:");
            System.out.println(shoeStore);

            supplierInterface.returnToCustomerInterface();
        } else {
            System.out.println("Incorrect password. Access denied.");
        }
    }

    static void simulateCustomerPurchase(ShoeStore shoeStore) {
        CustomerInterface customerInterface = new CustomerInterface(shoeStore);
        customerInterface.displayMenu();
    }

    private static void initializeModelsAndShoes(ShoeStore shoeStore) {
        Model dunksModel = new Model("Dunks");
        Model airMaxModel = new Model("Air Max");
        Model jordan1Model = new Model("Jordan 1");
        Model jordan4Model = new Model("Jordan 4");

        Shoe nikeDunks = new Shoe(9, "Black", "Nike", dunksModel, 20, 129.99);
        Shoe nikeAirMax = new Shoe(8, "White", "Nike", airMaxModel, 15, 149.99);
        Shoe jordan1 = new Shoe(10, "Red", "Jordan", jordan1Model, 25, 199.99);
        Shoe jordan4 = new Shoe(11, "Blue", "Jordan", jordan4Model, 18, 249.99);

        shoeStore.addShoesToInventory(nikeDunks);
        shoeStore.addShoesToInventory(nikeAirMax);
        shoeStore.addShoesToInventory(jordan1);
        shoeStore.addShoesToInventory(jordan4);
    }
}

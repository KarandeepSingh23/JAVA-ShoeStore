public class Shoe {
    private int size;
    private String color;
    private String brand;
    private Model model;
    private int quantityInStock;
    private double price;

    public Shoe(int size, String color, String brand, Model model, int quantityInStock, double price) {
        this.size = size;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.quantityInStock = quantityInStock;
        this.price = price;
    }

    public int getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return String.format("Shoe [Size: %d, Color: %s, Brand: %s, Model: %s, Quantity: %d, Price: %.2f]",
                size, color, brand, model, quantityInStock, price);
    }
}

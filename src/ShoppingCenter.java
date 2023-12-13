package po;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCenter {
    private static ShoppingCenter instance;
    private Map<String, Double> products;

    private ShoppingCenter() {
        products = new HashMap<>();
    }

    public static synchronized ShoppingCenter getInstance() {
        if (instance == null) {
            instance = new ShoppingCenter();
        }
        return instance;
    }

    public void addProduct(String name, double price) {
        products.put(name, price);
    }

    // Simulates a purchase and returns the spending amount
    public double simulatePurchase(Customer customer) {
        // Define purchase simulation logic
        return Math.random() * customer.getBudget(); // Example spending
    }

    // Getters for products
    public Map<String, Double> getProducts() {
        return products;
    }
}

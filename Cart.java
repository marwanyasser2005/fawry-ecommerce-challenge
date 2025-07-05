import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> items;

    public Cart() {
        items = new HashMap<>();
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Requested quantity for " + product.getName() + " exceeds available stock");
        }
        items.put(product, items.getOrDefault(product, 0) + quantity);
        product.reduceQuantity(quantity);
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public double calculateSubtotal() {
        return items.entrySet().stream()
                .mapToDouble(entry -> entry.getKey().getPrice() * entry.getValue())
                .sum();
    }

    public double calculateTotalWeight() {
        return items.entrySet().stream()
                .filter(entry -> entry.getKey() instanceof ShippableProduct)
                .mapToDouble(entry -> ((ShippableProduct) entry.getKey()).getWeight() * entry.getValue())
                .sum();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
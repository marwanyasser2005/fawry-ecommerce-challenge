import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();

        System.out.print("Enter customer balance (EGP): ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        Customer customer = new Customer(name, balance);
        Map<String, Product> products = getAvailableProducts();

        while (true) {
            printAvailableProducts(products);

            System.out.print("Enter product name (or 'done' to checkout): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) break;

            Product product = getProductByName(products, input);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }

            System.out.print("Enter quantity: ");
            int quantity = scanner.nextInt();
            scanner.nextLine();

            try {
                cart.add(product, quantity);
                System.out.println(quantity + "x " + product.getName() + " added to cart.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        try {
            checkout(customer, cart);
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
 


    private static Map<String, Product> getAvailableProducts() {
        Map<String, Product> map = new HashMap<>();
        map.put("cheese", new ShippableProduct("Cheese", 10, 1000, 0.2));   
        map.put("biscuits", new ShippableProduct("Biscuits", 15, 500, 0.7));
        map.put("tv", new ShippableProduct("TV", 6000, 3, 8.0)); 
        map.put("milk", new ShippableProduct("Milk", 30, 100, 1.0)); 
        map.put("fawry card", new Product("Fawry Card", 50, 1000));
        return map;       
    }

    private static Product getProductByName(Map<String, Product> products, String name) {
        return products.get(name.toLowerCase());
    }

    private static void printAvailableProducts(Map<String, Product> products) {
        System.out.println("\nAvailable Products:");
        for (Product p : products.values()) {
            System.out.printf("- %s: %.0f EGP | Available: %d", p.getName(), p.getPrice(), p.getQuantity());
            if (p instanceof ShippableProduct) {
                System.out.printf(" | Weight: %.1fkg%n", ((ShippableProduct) p).getWeight());
            } else {
                System.out.println(" | Non-shippable");
            }
        }
    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.isEmpty()) throw new IllegalStateException("Cart is empty.");

        double subtotal = cart.calculateSubtotal();
        double totalWeight = cart.calculateTotalWeight();
        double shippingFee = totalWeight > 0 ? 30 : 0;
        double total = subtotal + shippingFee;

        if (customer.getBalance() < total) throw new IllegalStateException("Insufficient balance for payment.");

        customer.deductBalance(total);

        System.out.println("\n** Shipment notice **");
        double weightSum = 0;
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            if (product instanceof ShippableProduct) {
                double weight = ((ShippableProduct) product).getWeight();
                double totalProductWeight = weight * qty;
                weightSum += totalProductWeight;
                System.out.printf("%dx %s %dgg%n", qty, product.getName(), (int)(totalProductWeight * 1000));
            }
        }
        if (weightSum > 0) {
            System.out.printf("Total package weight %.1fkg%n", weightSum);
        }

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int qty = entry.getValue();
            System.out.printf("%dx %s %.0f%n", qty, product.getName(), product.getPrice() * qty);
        }

        System.out.println("--------------------");
        System.out.printf("Subtotal %.0f%n", subtotal);
        if (shippingFee > 0) {
            System.out.printf("Shipping %.0f%n", shippingFee);
        }
        System.out.printf("Amount %.0f%n", total);
        System.out.printf("Customer balance after payment: %.0f%n", customer.getBalance());
    }
}

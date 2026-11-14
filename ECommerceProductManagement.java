import java.util.*;
import java.io.*;

public class ECommerceProductManagement {

    static HashMap<String, Product> products = new HashMap<>();
    static ArrayList<Product> productList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static int nextId = 101;
    static final String FILE_NAME = "products.txt";

    static class Product {
        String id, name, category;
        double price;
        int stock;

        Product(String id, String name, String category,
                double price, int stock) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.stock = stock;
        }

        public String toString() {
            return id + " | " + name + " | " + category
                    + " | " + price + " | Stock " + stock;
        }
    }

    static void addProduct() {
        System.out.print("Enter product name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter category: ");
        String category = sc.nextLine().trim();

        if (name.isEmpty() || category.isEmpty()) {
            System.out.println("Name and category cannot be empty.");
            return;
        }

        double price;
        int stock;

        try {
            System.out.print("Enter price: ");
            price = Double.parseDouble(sc.nextLine());

            System.out.print("Enter stock: ");
            stock = Integer.parseInt(sc.nextLine());

            if (price <= 0 || stock < 0) {
                System.out.println("Invalid price or stock.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid numeric values.");
            return;
        }

        String id = "P" + nextId++;

        Product p = new Product(id, name, category, price, stock);

        products.put(id, p);
        productList.add(p);

        saveProducts();

        System.out.println("Product added. " + p);
    }

    static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- All Products ---");

        for (Product p : products.values()) {
            System.out.println(p);
        }
    }

    static void searchProduct() {
        System.out.print("Enter Product ID or Category: ");
        String search = sc.nextLine().trim();

        Product p = products.get(search);

        if (p != null) {
            System.out.println(p);
            return;
        }

        boolean found = false;

        for (Product product : products.values()) {
            if (product.category.equalsIgnoreCase(search)) {
                System.out.println(product);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Product " + search + " not found.");
        }
    }

    static void sortProducts() {
        if (productList.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        Collections.sort(productList,
                Comparator.comparingDouble(p -> p.price));

        System.out.println("\n--- Products (Low to High) ---");

        for (Product p : productList) {
            System.out.println(p.id + " | " + p.name + " | " + p.price);
        }
    }

    static void updateStock() {
        System.out.print("Enter Product ID: ");
        String id = sc.nextLine().trim();

        Product p = products.get(id);

        if (p == null) {
            System.out.println("Product " + id + " not found.");
            return;
        }

        try {
            System.out.print("Enter new stock: ");
            int newStock = Integer.parseInt(sc.nextLine());

            if (newStock < 0) {
                System.out.println("Stock cannot be negative.");
                return;
            }

            p.stock = newStock;
            saveProducts();

            if (newStock == 0) {
                System.out.println("Stock updated. " + id
                        + " is Out of Stock.");
            } else {
                System.out.println("Stock updated. " + id
                        + " Stock: " + newStock);
            }

        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid stock value.");
        }
    }

    static void saveProducts() {
        try (PrintWriter writer =
                new PrintWriter(new FileWriter(FILE_NAME))) {

            for (Product p : products.values()) {
                writer.println(p.id + "|" + p.name + "|"
                        + p.category + "|" + p.price + "|"
                        + p.stock);
            }

        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    static void loadProducts() {
        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|", -1);

                if (data.length != 5) {
                    continue;
                }

                try {
                    String id = data[0];
                    String name = data[1];
                    String category = data[2];
                    double price = Double.parseDouble(data[3]);
                    int stock = Integer.parseInt(data[4]);

                    Product p = new Product(
                            id, name, category, price, stock);

                    products.put(id, p);
                    productList.add(p);

                    if (id.matches("P\\d+")) {
                        int number = Integer.parseInt(id.substring(1));
                        nextId = Math.max(nextId, number + 1);
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid product record.");
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading products: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        loadProducts();

        System.out.println("Welcome to E-Commerce Product Management!");

        while (true) {

            System.out.println("\n================================");
            System.out.println(" E-COMMERCE PRODUCT MANAGEMENT");
            System.out.println("================================");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Sort Products by Price");
            System.out.println("5. Update Stock");
            System.out.println("6. Exit");
            System.out.println("================================");
            System.out.print("Enter your choice: ");

            String choice = sc.nextLine().trim();

            switch (choice) {
                case "1":
                    addProduct();
                    break;

                case "2":
                    viewProducts();
                    break;

                case "3":
                    searchProduct();
                    break;

                case "4":
                    sortProducts();
                    break;

                case "5":
                    updateStock();
                    break;

                case "6":
                    saveProducts();
                    System.out.println("Products saved successfully.");
                    System.out.println("Thank you for using the application!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
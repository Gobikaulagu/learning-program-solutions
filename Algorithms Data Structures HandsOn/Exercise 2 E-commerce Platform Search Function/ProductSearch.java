// Step 1: Imports
import java.util.Arrays;
import java.util.Comparator;

// Step 2: Define the Product class
class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product(ID=" + productId + ", Name='" + productName + "', Category='" + category + "')";
    }
}

// Step 3: Implement search functionality
public class ProductSearch {

    // Linear Search (O(n))
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search (O(log n)) — assumes array is sorted
    public static Product binarySearch(Product[] products, String targetName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            String midName = products[mid].productName.toLowerCase();
            int comparison = targetName.toLowerCase().compareTo(midName);
            if (comparison == 0) {
                return products[mid];
            } else if (comparison > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    // Step 4: Main method for testing
    public static void main(String[] args) {
        // Create product list
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Chair", "Furniture"),
            new Product(103, "Headphones", "Electronics"),
            new Product(104, "Shoes", "Fashion"),
            new Product(105, "Book", "Education")
        };

        // Print for reference
        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p);
        }

        // Linear Search Test
        System.out.println("\n--- Linear Search ---");
        String target = "Shoes";
        Product foundLinear = linearSearch(products, target);
        System.out.println("Result: " + (foundLinear != null ? foundLinear : "Product not found"));

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search Test
        System.out.println("\n--- Binary Search ---");
        Product foundBinary = binarySearch(products, target);
        System.out.println("Result: " + (foundBinary != null ? foundBinary : "Product not found"));

        // Step 5: Analysis (in comments)
        /*
         Time Complexity Analysis:

         Linear Search:
           - Best Case: O(1)   → target is first
           - Average:  O(n)   → somewhere in middle
           - Worst:    O(n)   → at end or not found

         Binary Search:
           - Best Case: O(1)       → found at middle
           - Average/Worst: O(log n)
           - Requires sorted array

         Recommendation:
         - Use Binary Search for large, sorted product lists.
         - Use Linear Search if data is small or unsorted.
        */
    }
}

import java.util.Arrays;

class Order {
    int orderId;
    String customerName;
    double totalPrice;

    // Constructor
    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    // Print format
    public String toString() {
        return "Order ID: " + orderId + ", Customer: " + customerName + ", Total: Rs." + totalPrice;
    }
}

public class OrderSorting {

    // Bubble sort method to sort orders based on totalPrice
    public static void bubbleSort(Order[] orders) {
        for (int i = 0; i < orders.length - 1; i++) {
            for (int j = 0; j < orders.length - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    // swap
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick sort method to sort orders
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(orders, low, high);
            quickSort(orders, low, pivotIndex - 1);
            quickSort(orders, pivotIndex + 1, high);
        }
    }

    // Helper method for quick sort
    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        // Sample data
        Order[] orders = {
            new Order(101, "Karthik", 299.0),
            new Order(102, "Divya", 1899.0),
            new Order(103, "Rahul", 2099.5),
            new Order(104, "Priya", 4599.0),
            new Order(105, "Anika", 6500.0)
        };

        // Bubble sort test
        Order[] bubbleSorted = Arrays.copyOf(orders, orders.length);
        bubbleSort(bubbleSorted);
        System.out.println("Sorted Orders (Bubble Sort):");
        for (Order o : bubbleSorted) {
            System.out.println(o);
        }

        // Quick sort test
        Order[] quickSorted = Arrays.copyOf(orders, orders.length);
        quickSort(quickSorted, 0, quickSorted.length - 1);
        System.out.println("\nSorted Orders (Quick Sort):");
        for (Order o : quickSorted) {
            System.out.println(o);
        }

        // Final note (can be printed or just left in comments)
        /*
         Notes:
         - Bubble Sort is simple but slow (O(n^2))
         - Quick Sort is faster for larger lists (O(n log n))
         - Real-world applications prefer Quick Sort for performance
        */
    }
}

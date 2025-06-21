import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibrarySystem {
    static Book[] books = {
        new Book(101, "The Alchemist", "Paulo Coelho"),
        new Book(102, "To Kill a Mockingbird", "Harper Lee"),
        new Book(103, "Pride and Prejudice", "Jane Austen"),
        new Book(104, "1984", "George Orwell"),
        new Book(105, "Moby Dick", "Herman Melville")
    };

    // Linear Search by title
    public static void linearSearch(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                System.out.println("Book found: " + book);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Book not found.");
    }

    // Binary Search by title (list must be sorted)
    public static void binarySearch(String title) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase()));
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) {
                System.out.println("Book found: " + books[mid]);
                return;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Book not found.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--- Library Management System ---");
        System.out.print("Enter title to search: ");
        String title = scanner.nextLine();

        System.out.println("\nUsing Linear Search:");
        linearSearch(title);

        System.out.println("\nUsing Binary Search (on sorted list):");
        binarySearch(title);

        scanner.close();
    }
}

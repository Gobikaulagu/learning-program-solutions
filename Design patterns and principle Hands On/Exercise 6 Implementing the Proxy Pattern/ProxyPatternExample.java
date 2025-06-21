// ProxyPatternExample.java

// Subject Interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String filename;
    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }
    private void loadFromServer() {
        System.out.println("Loading image from server: " + filename);
    }
    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;
    public ProxyImage(String filename) {
        this.filename = filename;
    }
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("cat.jpg");
        Image image2 = new ProxyImage("dog.jpg");

        // Image will be loaded from server only once per ProxyImage
        image1.display(); // Loads and displays
        image1.display(); // Only displays
        image2.display(); // Loads and displays
    }
} 
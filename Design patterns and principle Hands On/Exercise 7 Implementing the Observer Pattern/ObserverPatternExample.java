// ObserverPatternExample.java

import java.util.*;

// Subject Interface
interface Stock {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
    void setPrice(double price);
}

// Observer Interface
interface Observer {
    void update(double price);
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(price);
        }
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }
}

// Concrete Observer: MobileApp
class MobileApp implements Observer {
    private String name;
    public MobileApp(String name) {
        this.name = name;
    }
    @Override
    public void update(double price) {
        System.out.println("MobileApp " + name + ": Stock price updated to $" + price);
    }
}

// Concrete Observer: WebApp
class WebApp implements Observer {
    private String name;
    public WebApp(String name) {
        this.name = name;
    }
    @Override
    public void update(double price) {
        System.out.println("WebApp " + name + ": Stock price updated to $" + price);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobileApp = new MobileApp("Alpha");
        Observer webApp = new WebApp("Beta");

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        System.out.println("Setting price to 100.0");
        stockMarket.setPrice(100.0);

        System.out.println("Setting price to 120.5");
        stockMarket.setPrice(120.5);

        stockMarket.removeObserver(mobileApp);
        System.out.println("Setting price to 130.0 (only WebApp should be notified)");
        stockMarket.setPrice(130.0);
    }
} 
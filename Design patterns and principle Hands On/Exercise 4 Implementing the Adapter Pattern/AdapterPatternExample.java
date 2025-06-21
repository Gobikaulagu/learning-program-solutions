// AdapterPatternExample.java

// Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Adaptee 1: PayPal gateway with its own method
class PayPalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via PayPal.");
    }
}

// Adaptee 2: Stripe gateway with its own method
class StripeGateway {
    public void makeStripePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " via Stripe.");
    }
}

// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        payPalGateway.sendPayment(amount);
    }
}

// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        stripeGateway.makeStripePayment(amount);
    }
}

public class AdapterPatternExample {
    public static void main(String[] args) {
        // Using PayPal through the adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPalGateway());
        paypalProcessor.processPayment(100.0);

        // Using Stripe through the adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new StripeGateway());
        stripeProcessor.processPayment(200.0);
    }
} 
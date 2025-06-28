// DecoratorPatternExample.java

// Component Interface
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email: " + message);
    }
}

// Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;
    public NotifierDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }
    public void send(String message) {
        wrappee.send(message);
    }
}

// Concrete Decorator: SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

// Concrete Decorator: Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending Slack: " + message);
    }
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        Notifier notifier = new EmailNotifier();
        Notifier smsNotifier = new SMSNotifierDecorator(notifier);
        Notifier slackAndSmsNotifier = new SlackNotifierDecorator(smsNotifier);

        System.out.println("--- Email Only ---");
        notifier.send("Hello!");

        System.out.println("--- Email + SMS ---");
        smsNotifier.send("Hello!");

        System.out.println("--- Email + SMS + Slack ---");
        slackAndSmsNotifier.send("Hello!");
    }
} 
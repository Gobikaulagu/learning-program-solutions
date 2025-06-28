 // CommandPatternExample.java

// Command Interface
interface Command {
    void execute();
}

// Receiver
class Light {
    private String location;
    public Light(String location) {
        this.location = location;
    }
    public void turnOn() {
        System.out.println(location + " light is ON");
    }
    public void turnOff() {
        System.out.println(location + " light is OFF");
    }
}

// Concrete Command: Light On
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) {
        this.light = light;
    }
      @Override
    public void execute() {
        light.turnOn();
    }
}

// Concrete Command: Light Off
class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) {
        this.light = light;
    }
    @Override
    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
         }
}

public class CommandPatternExample {
    public static void main(String[] args) {
        Light livingRoomLight = new Light("Living Room");
        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton(); // Turns on the light

        remote.setCommand(lightOff);
        remote.pressButton(); // Turns off the light
    }
}
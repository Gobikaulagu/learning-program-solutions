// BuilderPatternExample.java

class Computer {
    // Required parameters
    private String CPU;
    private String RAM;
    // Optional parameters
    private String storage;
    private String graphicsCard;
    private String keyboard;
    private String mouse;

    // Private constructor
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.keyboard = builder.keyboard;
        this.mouse = builder.mouse;
    }

    // Getters
    public String getCPU() { return CPU; }
    public String getRAM() { return RAM; }
    public String getStorage() { return storage; }
    public String getGraphicsCard() { return graphicsCard; }
    public String getKeyboard() { return keyboard; }
    public String getMouse() { return mouse; }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GraphicsCard=" + graphicsCard + ", Keyboard=" + keyboard + ", Mouse=" + mouse + "]";
    }

    // Static nested Builder class
    public static class Builder {
        // Required parameters
        private String CPU;
        private String RAM;
        // Optional parameters
        private String storage;
        private String graphicsCard;
        private String keyboard;
        private String mouse;

        public Builder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder keyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder mouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Basic computer
        Computer basicComputer = new Computer.Builder("Intel i5", "8GB")
                .storage("256GB SSD")
                .build();
        System.out.println("Basic Computer: " + basicComputer);

        // Gaming computer
        Computer gamingComputer = new Computer.Builder("Intel i9", "32GB")
                .storage("1TB SSD")
                .graphicsCard("NVIDIA RTX 4090")
                .keyboard("Mechanical")
                .mouse("Gaming Mouse")
                .build();
        System.out.println("Gaming Computer: " + gamingComputer);

        // Office computer
        Computer officeComputer = new Computer.Builder("AMD Ryzen 5", "16GB")
                .storage("512GB SSD")
                .keyboard("Standard Keyboard")
                .build();
        System.out.println("Office Computer: " + officeComputer);
    }
} 
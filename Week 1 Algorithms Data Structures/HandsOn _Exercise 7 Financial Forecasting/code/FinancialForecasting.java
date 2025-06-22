import java.util.Scanner;

public class FinancialForecasting {

    // Recursive method to calculate future value
    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, years - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Financial Forecasting Tool ---");

        System.out.print("Enter current value: ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter no. of years to forecast: ");
        int forecastYears = scanner.nextInt();

        double futureValue = calculateFutureValue(currentValue, growthRate, forecastYears);

        System.out.printf("Predicted future value after %d years: Rs. %.2f\n", forecastYears, futureValue);
        
        scanner.close();
    }
}

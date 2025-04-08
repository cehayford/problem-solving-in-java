import java.util.Scanner;

public class temp_converter {
    private static final String functionsName = "Temperature Converter";
    private static final String errorMessage = "Invalid choice. Please restart the program and choose 1 or 2.";
    private static final double normalBodyTemp_C = 37.0;
    private static final double normalBodyTemp_F = 98.6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(functionsName);
        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.println("Choose conversion direction:");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        if (choice == 1) {
            double fahrenheit = (temperature * 9 / 5) + 32;
            System.out.println(temperature + "°C is equal to " + fahrenheit + "°F");
            checkTemperature(temperature, true);
        } else if (choice == 2) {
            double celsius = (temperature - 32) * 5 / 9;
            System.out.println(temperature + "°F is equal to " + celsius + "°C");
            checkTemperature(temperature, false);
        } else {
            System.out.println(errorMessage);
            System.err.println("Error: " + errorMessage);
            System.exit(1);
        }

        scanner.close();
    }

    private static void checkTemperature(double temperature, boolean isCelsius) {
        if (isCelsius) {
            if (temperature < normalBodyTemp_C - 2) {
                System.out.println("The temperature is assume as cold for the human body.");
            } else if (temperature > normalBodyTemp_C + 2) {
                System.out.println("The temperature is assume as hot for the human body.");
            } else {
                System.out.println("The temperature for the human body is normal.");
            }
        } else {
            if (temperature < normalBodyTemp_F - 3.6) {
                System.out.println("The temperature is assume as cold for the human body.");
            } else if (temperature > normalBodyTemp_F + 3.6) {
                System.out.println("The temperature is assume as hot for the human body.");
            } else {
                System.out.println("The temperature for the human body is normal.");
            }
        }
    }
}

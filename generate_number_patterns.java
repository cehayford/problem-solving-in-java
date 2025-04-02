// Objective: Utilize loops to control the structure of number patterns.
import java.util.Scanner;

class generate_number_patterns {
    public static void main(String[] args) {
        Scanner rows = new Scanner(System.in);
        System.out.println("Enter number of rows: ");
        int numberOfRows = rows.nextInt();

        generatePatterns(numberOfRows);
    }

    static void generatePatterns(int rows) {
        // Pattern 1
        
        for (int i = 1; i <= rows; i++) {
            for (int k = 1; k <= rows - i; k++) {
                System.out.print("* ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void fibonacciPatterns(int rows) {
        int firstTerm = 0, secondTerm = 1;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) { 
                System.out.print(firstTerm + " ");
                int nextTerm = firstTerm + secondTerm;
                firstTerm = secondTerm;
                secondTerm = nextTerm;
            }
        }
    }
}


import java.util.Scanner;

public class SalaryAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double[] salaries = new double[n];

        for (int i = 0; i < n; i++) {
            salaries[i] = sc.nextDouble();
        }

        double total = 0;

        for (int i = 0; i < n; i++) {
            total = total + salaries[i];
        }

        double average = total / n;

        double highest = salaries[0];
        double lowest = salaries[0];

        int highestEmployee = 0;
        int lowestEmployee = 0;

        for (int i = 1; i < n; i++) {

            if (salaries[i] > highest) {
                highest = salaries[i];
                highestEmployee = i;
            }

            if (salaries[i] < lowest) {
                lowest = salaries[i];
                lowestEmployee = i;
            }
        }

        int aboveAverage = 0;
        int within5000 = 0;

        for (int i = 0; i < n; i++) {

            if (salaries[i] > average) {
                aboveAverage++;
            }

            if (salaries[i] >= average - 5000 &&
                salaries[i] <= average + 5000) {
                within5000++;
            }
        }

        System.out.println("===== Salary Analysis Report");
        System.out.println();

        System.out.println("Employees: " + n);
        System.out.println();

        System.out.println("Total Payroll: Rs." + total);

        System.out.printf("Average Salary: Rs.%.2f%n", average);

        System.out.println("Highest Salary: Rs." + highest + " (Employee " + (highestEmployee + 1) + ")");

        System.out.println("Lowest Salary: Rs." + lowest + " (Employee " + (lowestEmployee + 1) + ")");

        System.out.println("Above Average: " + aboveAverage + " employees.");

        System.out.println("Within Rs.5000 of Average: " + within5000 + " employees.");

        sc.close();
    }
}

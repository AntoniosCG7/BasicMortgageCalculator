package MortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;

public class mortgage_calculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MONTHS_IN_YEAR = 12;
        int principal = Principal(input);
        double annualInterestRate = annualInterestRate(input);
        int periodInYears = period(input);
        calculateMortgage(input, principal, annualInterestRate, periodInYears, MONTHS_IN_YEAR);
    }

    public static int Principal(Scanner input) {
        int principal;
        while (true) {
            System.out.print("Principal ($1K - $1M): ");
            principal = input.nextInt();
            if (principal < 1000 || principal > 1_000_000) {
                System.out.println("Enter a number between 1,000 and 1,000,000.");
                continue;
            } else {
                break;
            }
        }
        return principal;
    }

    public static double annualInterestRate(Scanner input) {
        double annualInterestRate;
        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterestRate = input.nextDouble();
            if (annualInterestRate <= 0 || annualInterestRate > 30) {
                System.out.println("Enter a value greater than 0 and less than or equal to 30.");
                continue;
            } else {
                break;
            }
        }
        return annualInterestRate;
    }

    public static int period(Scanner input) {
        int periodInYears;
        while (true) {
            System.out.print("Period (years): ");
            periodInYears = input.nextInt();
            if (periodInYears < 1 || periodInYears > 30) {
                System.out.println("Enter a value between 1 and 30.");
                continue;
            } else {
                break;
            }
        }
        return periodInYears;
    }

    public static double calculateMortgage(Scanner input, int principal, double annualInterestRate,
        double periodInYears, final int MONTHS_IN_YEAR) {
        double monthlyInterestRate = (annualInterestRate / 100) / (MONTHS_IN_YEAR);
        double Mortgage = (principal)
            * ((monthlyInterestRate * Math.pow(1 + monthlyInterestRate,
            periodInYears * MONTHS_IN_YEAR))
            / (Math.pow(1 + monthlyInterestRate, periodInYears * MONTHS_IN_YEAR) - 1));
        System.out.println("Mortgage: " + NumberFormat.getCurrencyInstance().format(Mortgage));
        return Mortgage;
    }
}

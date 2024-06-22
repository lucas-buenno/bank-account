package application;

import entities.Account;
import exception.DomainException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter account data");
            System.out.println();
            System.out.print("Number: ");
            int accountNumber = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String holderAccount = sc.nextLine();
            System.out.print("Initial balance: ");
            double initialDeposit = sc.nextDouble();

            Account account = new Account(accountNumber, holderAccount, initialDeposit);
            System.out.println("------------------");
            System.out.println("Your bank account has been created successfully.");
            System.out.println("The withdrawal limit on your account is $ " + String.format("%.2f",Account.getWithDrawLimit()));
            System.out.println("------------------");

            System.out.println();
            System.out.print("Enter amount for withdraw: ");
            double withDrawValue = sc.nextDouble();
            account.withDraw(withDrawValue);
            System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
        }

        catch (DomainException e) {
            System.out.println(e.getMessage());
        }

        catch (InputMismatchException e) {
            System.out.println("The value entered is invalid. Please try again.");
        }

        catch (RuntimeException e) {
            System.out.println("The action cannot be performed at this time. Please try again later.");
        }
        sc.close();
    }
}

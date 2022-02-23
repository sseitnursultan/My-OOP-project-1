package com.company;

import java.util.Scanner;
import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        SignIn sign = new SignIn();
        WithdrawCash withdrawCash = new WithdrawCash();
        Deposit deposit = new Deposit();
        ChangePin changePin = new ChangePin();

        Balance balance = new Balance();
        boolean a=false;

        System.out.println("Enter your first_name");
        String firstName = scan.nextLine();
        System.out.println("Enter your PIN");
        int pin = scan.nextInt();
        sign.signIn(firstName,pin);

        int choice = -1;
        while(choice != 0){
            System.out.println("Welcome to out Bank,Choose one operation");
            System.out.println(" ");
            System.out.println("1. Check the balance");
            System.out.println("2. Withdraw cash");
            System.out.println("3. Deposit cash");
            System.out.println("4. Modify the PIN Code");
            System.out.println("0. EXIT");

            choice = scan.nextInt();
            switch (choice){
                case 1:
                    balance.checkBalance(firstName);
                    break;
                case 2:
                    System.out.println("kansha");
                    int ai = scan.nextInt();
                    withdrawCash.withdrawCash(firstName,ai);
                    break;
                case 3:
                    System.out.println("kansha2");
                    int aksha = scan.nextInt();
                    deposit.deposit(firstName,aksha);
                    break;
                case 4:
                    System.out.println("enter a new pin");
                    int newPin = scan.nextInt();
                    changePin.changePin(firstName,newPin);
                    break;
                default:
                    System.out.println("Error");
            }
        }

    }

}

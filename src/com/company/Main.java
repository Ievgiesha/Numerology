package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Visitor visitor = new Visitor();
        Scanner scanner = new Scanner(System.in);// write your code here
        int day = readDayFromInput(scanner);
        System.out.println(" Please, enter number of month of you date birthday:");
        int month = scanner.nextInt();
        System.out.println(" Please, enter year of you birthday: ");
        int year = scanner.nextInt();
        visitor.whatDestinyNumber(day, month, year);
    }

    static int readDayFromInput(Scanner scanner) {
        int day;
        boolean condition = false;
        do {
            System.out.println(" Please, enter day of you date birthday: ");
            day = scanner.nextInt();
            if ((day <= 0) || (day > 32)) {
                System.out.println("The number is wrong .Please, enter number from 1 to 31 ");
            } else {
                condition = true;
            }
        } while (!condition);
        return day;
    }
}

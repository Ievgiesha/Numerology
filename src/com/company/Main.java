package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        Visitor visitor = new Visitor();
        Scanner scanner = new Scanner(System.in);// write your code here
        StringBuilder builder = new StringBuilder();
        int day = readDayFromInput(scanner);
        int month = readMonthFromInput(scanner);
        int year = readYearFromInput(scanner);
        int destinyNumber = visitor.whatDestinyNumber(day, month, year);
        readToFile(builder,destinyNumber);
    }

    static int readDayFromInput(Scanner scanner) {
        int day = 0;
        boolean condition = false;
        do {
            System.out.println(" Please, enter day of you date birthday: ");
            if (scanner.hasNextInt()) {
                day = scanner.nextInt();
            } else {
                System.out.println("Enter correct birth day number");
                scanner.next();
                continue;
            }
            if ((day <= 0) || (day > 31)) {
                System.out.println("The number is wrong. Please, enter number from 1 to 31 ");
            } else {
                condition = true;
            }
        } while (!condition);
        return day;
    }

    static int readMonthFromInput(Scanner scanner) {
        int month = 0;
        boolean condition = false;
        do {
            System.out.println(" Please, enter number of month of you date birthday:");
            if (scanner.hasNextInt()) {
                month = scanner.nextInt();
            } else {
                System.out.println("Enter correct number of month of you birthday");
                scanner.next();
                continue;
            }
            if ((month < 1) || (month > 12)) {
                System.out.println("The number is wrong. Please, enter number from 1 to 12 ");
            } else {
                condition = true;
            }
        }
        while (!condition);
        return month;
    }


    static int readYearFromInput(Scanner scanner) {
        int year = 0;
        boolean condition = false;
        do {
            System.out.println(" Please, enter year of you birthday: ");
            if (scanner.hasNextInt()) {
                year = scanner.nextInt();
            } else {
                System.out.println("Enter correct year of you birthday");
                scanner.next();
                continue;
            }
            if ((year < 1800) || (year > 2018)) {
                System.out.println(" Number is wrong. Please enter number from 1800 to 2018 ");
            } else {
                condition = true;

            }
        } while (!condition);
        return year;


    }

    static StringBuilder readToFile(StringBuilder builder, int destinyNumber) throws IOException {
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(Paths.get("Text"), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        boolean toRead = false;
        for (String line : lines) {
            if (line.contains("The number " + destinyNumber)) {
                toRead = true;
            }
            if (line.contains("The number " + (destinyNumber + 1))) {
                toRead = false;
            }
            if (toRead) {
                builder.append(line);
            }
        }
                System.out.println(builder.toString());


        return builder;

    }

}
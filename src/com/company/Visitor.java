package com.company;

public class Visitor {
    private String name;
    private int day;
    private int month;
    private int year;
    private int destinyNumber;

    public Visitor() {
    }

    public Visitor(String name, int destinyNumber) {
        this.name = name;
        this.destinyNumber = destinyNumber;
    }

    public Visitor(String name, int day, int month, int year, int destinyNumber) {
        this.name = name;
        this.day = day;
        this.month = month;
        this.year = year;
        this.destinyNumber = destinyNumber;
    }

    public int whatDestinyNumber(int day, int month, int year) {
        int temp = year;
        int sum = 0;
        if (day >= 10) {
            sum = (day - (day % 10))/10 + (day % 10);
            if (sum >= 10) {
                sum = (sum - (sum % 10)) + (sum % 10);
            } } else sum = day;
            if (month >= 10) {
                sum += ((month - (month % 10))/10 + (month % 10));
            } else sum += month;
            for (int i = 0; i < 3; i++) {
                sum += temp % 10;
                temp = (temp - (temp % 10)) / 10;
            }
            sum += temp;
            if (sum >= 10) {
                sum = (sum - (sum % 10))/10 + sum % 10;
                if(sum >= 10){
                    sum = (sum - (sum % 10))/10 + sum % 10;
                }
            }
            System.out.println("You number of destiny: "+sum);
            return sum;


        }

    public void setName(String name) {
        this.name = name;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setDestinyNumber(int destinyNumber) {
        this.destinyNumber = destinyNumber;
    }



    public String getName() {
        return name;
    }

    public int getDestinyNumber() {
        return destinyNumber;
    }
}
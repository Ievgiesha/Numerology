package com.company;

public class Visitor {
    private String name;
    private int day;
    private int month;
    private int year;
    private int destinyNumber;

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

        public static void main (String[]args){
            Visitor visitor = new Visitor();
            System.out.println(visitor.whatDestinyNumber(28, 8, 1973));
        }
    }
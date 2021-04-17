package lesson2;

import java.util.Scanner;

public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(sumCheck(12, 2));
        positiveOrNegative(-23);
        System.out.println(trueOrFalse(-65));
        printString(7, "I completed my homework!");

        System.out.print("Enter year: ");
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        System.out.println(leapYearOrNot(year));
    }

    private static boolean sumCheck(int first_num, int second_num) {
        return first_num + second_num >= 10 && first_num + second_num <= 20;
    }

    private static void positiveOrNegative(int number) {
        if (number >= 0) {
            System.out.println("Number is positive");
        } else {
            System.out.println("Number is negative");
        }
    }

    private static boolean trueOrFalse(int number) {
        return number < 0;
    }

    private static void printString(int number, String string) {
        for (int i = 1; i <= number; i++) {
            System.out.println(string);
        }
        System.out.println();
    }

    public static boolean leapYearOrNot(int year) {
        return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
    }
}


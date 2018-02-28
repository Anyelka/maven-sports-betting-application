package org.sports.betting.application.app.ui;

import java.util.Scanner;

public class UserIO {

    private static Scanner scanner = new Scanner(System.in);

    public static String read() {
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static char readChar() {
        return scanner.next().charAt(0);
    }

    public static String readDate() {
        String date = scanner.nextLine();
        if (!date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            System.out.println("The given date is in the wrong format. Please define it in the proper format! [YYYY-MM-DD]");
            date = readDate();
        }
        return date;
    }

    public static void confirmPlay() {
        System.out.println("Are you ready to play ? Press Enter...");
        scanner.nextLine();
        System.out.println("--------------------------------------------------------------");
    }
}

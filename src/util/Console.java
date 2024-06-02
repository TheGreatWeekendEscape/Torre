package util;

import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    //Reset
    private static final String RESET = "\u001B[0m";

    // Text colors
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    // Background colors
    public static final String BLACK_BG = "\u001B[40m";
    public static final String RED_BG = "\u001B[41m";
    public static final String GREEN_BG = "\u001B[42m";
    public static final String YELLOW_BG = "\u001B[43m";
    private static final String BLUE_BG = "\u001B[44m";
    private static final String PURPLE_BG = "\u001B[45m";
    private static final String CYAN_BG = "\u001B[46m";
    private static final String WHITE_BG = "\u001B[47m";

    // Text styles
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String REVERSED = "\u001B[7m";

    public static void print (String message) {
        System.out.print(message);
        sc.nextLine();
    }

    public static void printRed (String message) {
        System.out.print(RED + message + RESET);
        sc.nextLine();
    }

    public static void printBlue (String message) {
        System.out.print(BLUE + message + RESET);
        sc.nextLine();
    }

    public static void printGreen (String message) {
        System.out.print(GREEN + message + RESET);
        sc.nextLine();
    }

    public static void printYellow (String message) {
        System.out.print(YELLOW + message + RESET);
        sc.nextLine();
    }

    public static void printWhite (String message) {
        System.out.print(WHITE + message + RESET);
        sc.nextLine();
    }

    public static void printCyan (String message) {
        System.out.print(CYAN + message + RESET);
        sc.nextLine();
    }

    public static void printPurple (String message) {
        System.out.print(PURPLE + message + RESET);
        sc.nextLine();
    }
}

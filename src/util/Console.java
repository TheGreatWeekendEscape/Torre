package util;

public class Console {

    //Reset
    private static final String RESET = "\u001B[0m";

    // Text colors
    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    // Background colors
    private static final String BLACK_BG = "\u001B[40m";
    private static final String RED_BG = "\u001B[41m";
    private static final String GREEN_BG = "\u001B[42m";
    private static final String YELLOW_BG = "\u001B[43m";
    private static final String BLUE_BG = "\u001B[44m";
    private static final String PURPLE_BG = "\u001B[45m";
    private static final String CYAN_BG = "\u001B[46m";
    private static final String WHITE_BG = "\u001B[47m";

    // Text styles
    private static final String BOLD = "\u001B[1m";
    private static final String UNDERLINE = "\u001B[4m";
    private static final String REVERSED = "\u001B[7m";

    public static void print (String message) {
        System.out.println(message);
    }

    public static void printRed (String message) {
        System.out.println(RED + message + RESET);
    }

    public static void printBlue (String message) {
        System.out.println(BLUE + message + RESET);
    }

    public static void printGreen (String message) {
        System.out.println(GREEN + message + RESET);
    }

    public static void printYellow (String message) {
        System.out.println(YELLOW + message + RESET);
    }

    public static void printWhite (String message) {
        System.out.println(WHITE + message + RESET);
    }

    public static void printCyan (String message) {
        System.out.println(CYAN + message + RESET);
    }

    public static void printPurple (String message) {
        System.out.println(PURPLE + message + RESET);
    }
}

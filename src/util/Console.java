package util;

import model.entity.Entity;

import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);

    //Reset
    private static final String RESET = "\u001B[0m";

    private static final String BLACK = "\u001B[30m";
    private static final String RED = "\u001B[31m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String BLUE = "\u001B[34m";
    private static final String PURPLE = "\u001B[35m";
    private static final String CYAN = "\u001B[36m";
    private static final String WHITE = "\u001B[37m";

    // Birght colors
    private static final String BRIGHT_BLACK = "\u001B[90m";
    private static final String BRIGHT_RED = "\u001B[91m";
    private static final String BRIGHT_GREEN = "\u001B[92m";
    private static final String BRIGHT_YELLOW = "\u001B[93m";
    private static final String BRIGHT_BLUE = "\u001B[94m";
    private static final String BRIGHT_PURPLE = "\u001B[95m";
    private static final String BRIGHT_CYAN = "\u001B[96m";
    private static final String BRIGHT_WHITE = "\u001B[97m";

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
    private static final String BRIGHT = "\u001B[1m";       // Negrita
    private static final String DIM = "\u001B[2m";          // Atenuar
    private static final String UNDERLINE = "\u001B[4m";    // Subrayado
    private static final String BLINK = "\u001B[5m";        // Parpadeo
    private static final String REVERSE = "\u001B[7m";      // Invertir colores
    private static final String HIDDEN = "\u001B[8m";       // Oculto

    // Finals
    public static final String DEFAULT_COLOR = BLUE;
    public static final String ITEM_COLOR = YELLOW;
    public static final String BAD_COLOR = RED;
    public static final String GOOD_COLOR = GREEN;
    public static final String FLOOR_COLOR = BLACK;
    public static final String FLOOR_BACKGROUND = BLUE_BG;

    public static void print(String message, String color) {
        System.out.print(color + message + " ..." + RESET);
        sc.nextLine();
    }

    public static void printBold(String message, String color) {
        System.out.print(BRIGHT + color + message + " ..." + RESET);
        sc.nextLine();
    }

    public static void printBackground(String message, String color, String backgroundColor) {
        System.out.print(backgroundColor + color + message + RESET + " ...");
        sc.nextLine();
    }

    public static void printFightStage(Entity player, Entity enemy) {
        System.out.println();
        System.out.println(BLACK + PURPLE_BG + player.getName() + RESET + "             " + BLACK + PURPLE_BG + enemy.getName() + RESET);
        System.out.println();
        System.out.println(PURPLE + "                  " + enemy.getRepresentation()[0]);
        System.out.println(PURPLE + "  O               " + enemy.getRepresentation()[1]);
        System.out.println(PURPLE + "  |   *           " + enemy.getRepresentation()[2]);
        System.out.println(PURPLE + " /|\\/            " + enemy.getRepresentation()[3]);
        System.out.println(PURPLE + " / \\             " + enemy.getRepresentation()[4]);
    }

    public static void printEnemy(Entity enemy) {
        System.out.println();
        System.out.println(BLACK + PURPLE_BG + enemy.getName() + RESET);
        printRepresentation(enemy.getRepresentation());
        System.out.println(RED + BLACK_BG + "**********" + RESET);
    }

    private static void printRepresentation(String[] representation) {
        for (String s : representation) {
            System.out.println(PURPLE + s);
        }
    }




}

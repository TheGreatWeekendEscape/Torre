package util;

import model.entity.Entity;
import model.entity.Player;
import model.relic.Relic;
import model.spell.Spell;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);
    private static final int NAME_BOX_SIZE = 17;
    public static final String DEF_CHAR = "#";
    public static final String DMG_CHAR = "‡";
    public static final String STS_CHAR = "*";
    public static final String HP_CHAR = "+";

    //Reset
    public static final String RESET = "\u001B[0m";

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
    public static final String BAD_COLOR = RED;
    public static final String GOOD_COLOR = GREEN;
    public static final String FLOOR_COLOR = BLACK;
    public static final String FLOOR_BACKGROUND = BLUE_BG;
    public static final String SPELL_COLOR = BRIGHT_PURPLE;
    public static final String RELIC_COLOR = BRIGHT_YELLOW;
    public static final String ARMOR_COLOR = BRIGHT_CYAN;
    public static final String DAMAGE_COLOR = BRIGHT_RED;
    public static final String STATUS_COLOR = BRIGHT_GREEN;
    public static final String POTION_COLOR = BRIGHT_RED;
    public static final String GOLD_COLOR = YELLOW;
    public static final String KEY_COLOR = WHITE;
    public static final String FIRE_COLOR = RED;
    public static final String WIND_COLOR = BRIGHT_WHITE;
    public static final String WATER_COLOR = BRIGHT_BLUE;
    public static final String DARKNESS_COLOR = BRIGHT_PURPLE;
    public static final String NORMAL_COLOR = WHITE;
    public static final String PLANT_COLOR = GREEN;
    public static final String ROCK_COLOR = YELLOW;
    public static final String ICE_COLOR = CYAN;
    public static final String HEALTH_COLOR = BRIGHT_GREEN;

    public static void printDefault(String message) {
        System.out.print(Console.DEFAULT_COLOR + message + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void print(String message, String color) {
        System.out.print(color + message + " ..." + RESET);
        sc.nextLine();
    }

    public static void printBold(String message, String color) {
        System.out.print(BRIGHT + color + message + " ..." + RESET);
        sc.nextLine();
    }

    public static void printBackground(String message, String color, String backgroundColor) {
        System.out.print(backgroundColor + color + message +  " ..." + RESET);
        sc.nextLine();
    }

    public static void printSpell(String text, String spellName) {
        System.out.print(DEFAULT_COLOR + text + SPELL_COLOR + spellName + RESET + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void printPotion (String text, String potionName) {
        System.out.print(DEFAULT_COLOR + text + POTION_COLOR + potionName + RESET + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void printArmor(String text, String armor) {
        System.out.print(DEFAULT_COLOR + text + ARMOR_COLOR + armor + DEF_CHAR + RESET + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void printDamage(String text, int damage) {
        System.out.print(DEFAULT_COLOR + text + DAMAGE_COLOR + damage + DMG_CHAR + RESET + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void printGood(String text, String good) {
        System.out.print(DEFAULT_COLOR + text + GOOD_COLOR + good + RESET + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void printBad(String text, String bad) {
        System.out.print(DEFAULT_COLOR + text + BAD_COLOR + bad + RESET + DEFAULT_COLOR + " ..." + RESET);
        sc.nextLine();
    }

    public static void printGold(Player p) {
        System.out.println(DEFAULT_COLOR + "Tienes " + GOLD_COLOR + p.getGold() + "g" + RESET);
    }

    public static String printMenu(ArrayList<String> menu) {
        System.out.print(DEFAULT_COLOR);
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
        String option = "";
        boolean validOption = false;
        while (!validOption) {
            option = sc.nextLine();
            for (int i = 1; i <= menu.size(); i++) {
                if ((i + "").equalsIgnoreCase(option)) {
                    validOption = true;
                }
            }
            if (!validOption) {
                System.out.println(DEFAULT_COLOR + "Elige una opcion valida [1-" + menu.size() + "]: ");
            }
        }
        System.out.print(RESET);
        return option;
    }

    public static void printGrimoire(Entity player, Spell enemySpell) {
        System.out.println(UNDERLINE  + DEFAULT_COLOR + "Hechizo del enemigo: " + RESET);
        System.out.println(DEFAULT_COLOR + "- " + enemySpell.getType().getDisplayName() + " " + enemySpell.getName() + DEFAULT_COLOR + ": " + enemySpell.getDesc());
        System.out.println(UNDERLINE + DEFAULT_COLOR + "Tus hechizos: " + RESET);
        for (Spell s : player.getSpells()) {
            System.out.println(DEFAULT_COLOR + "- " + s.getType().getDisplayName() + " " + s.getName() + DEFAULT_COLOR + ": " + s.getDesc());
        }
        System.out.print("...");
        sc.nextLine();
    }

    public static void printRelics(ArrayList<Relic> relics) {
        if (relics.isEmpty()) {
            printDefault("Todavia no tienes ningun objeto");
        } else {
            for (Relic relic : relics) {
                System.out.println(DEFAULT_COLOR + "- " + relic.getName() + DEFAULT_COLOR + ": " + relic.getDesc());
            }
            System.out.print("...");
            sc.nextLine();
        }
    }

    public static void printFightStage(Entity player, Entity enemy) {
        String playerHpDisplay = player.getHp() + "/" + player.getMaxHp();
        String enemyHpDisplay = enemy.getHp() + "/" + enemy.getMaxHp();
        String playerHpBar = "";
        String enemyHpBar = "";
        for (int i = 0; i < player.getHpPercentage(); i++) {
            playerHpBar += "█";
        }
        for (int i = 0; i < enemy.getHpPercentage(); i++) {
            enemyHpBar += "█";
        }
        String playerArmorDisplay = player.getArmor() <= 0 ? "" : "[" + player.getArmor() + " " + DEF_CHAR + "]";
        String enemyArmorDisplay = enemy.getArmor() <= 0 ? "" : "[" + enemy.getArmor() + " " + DEF_CHAR + "]";

        System.out.println();
        System.out.println(ARMOR_COLOR + centerString(playerArmorDisplay, NAME_BOX_SIZE) + "      " + centerString(enemyArmorDisplay, NAME_BOX_SIZE) + RESET);
        System.out.println(BLACK + PURPLE_BG + centerString(player.getName(), NAME_BOX_SIZE) + RESET + "      " +
                BLACK + PURPLE_BG + centerString(enemy.getName(), NAME_BOX_SIZE) + RESET);
        System.out.print(PURPLE);
        System.out.println("                            " + enemy.getRepresentation()[0]);
        System.out.println("       O                    " + enemy.getRepresentation()[1]);
        System.out.println("       |   *                " + enemy.getRepresentation()[2]);
        System.out.println("      /|\\/                 " + enemy.getRepresentation()[3]);
        System.out.println("      / \\                  " + enemy.getRepresentation()[4] + RESET);
        System.out.printf("   " + BLACK_BG + GREEN + "%-10s" + RESET + "              " + BLACK_BG + GREEN + "%-10s" + RESET, playerHpBar, enemyHpBar);
        System.out.println();
        System.out.println(PURPLE + centerString(playerHpDisplay, NAME_BOX_SIZE) + RESET + "      " + PURPLE + centerString(enemyHpDisplay, NAME_BOX_SIZE) + RESET);
        System.out.println();
    }

    public static void printChest(Player p) { //Se le pasa el player para que pueda imprimir las llaves
        System.out.print(RELIC_COLOR);
        System.out.println("  _____");
        System.out.println(" /    /|");
        System.out.println("|____| |    " + DEFAULT_COLOR + "Llaves: " + p.getKeys() + RELIC_COLOR);
        System.out.println("| [] | |");
        System.out.println("|____|/");
    }

    public static void printFountain(Player p) { //Se le pasa el player para que pueda imprimir la vida
        System.out.println(BRIGHT_CYAN);
        System.out.println("    ||");
        System.out.println(WHITE + "   \\ /");
        System.out.println(" __| |__");
        System.out.println(" \\__ __/");
        System.out.println("  |  | ");
        System.out.println("/______\\" + RESET);
        System.out.println();



    }

    public static void printEnemy(Entity enemy) {
        System.out.println();
        System.out.println(BLACK + PURPLE_BG + enemy.getName() + RESET);
        printRepresentation(enemy.getRepresentation());
        System.out.println(RED + BLACK_BG + "**********" + RESET);
    }

    //A partir de aqui son toodo metodos privados

    private static void printRepresentation(String[] representation) {
        for (String s : representation) {
            System.out.println(PURPLE + s);
        }
    }

    private static String centerString(String str, int size) {
        if (str.length() >= size) {
            return str.substring(0, size);
        }
        int total = size - str.length();
        int left = total / 2;
        int right = total - left;

        StringBuilder finalStr = new StringBuilder();
        for (int i = 0; i < left; i++) {
            finalStr.append(' ');
        }
        finalStr.append(str);
        for (int i = 0; i < right; i++) {
            finalStr.append(' ');
        }
        return finalStr.toString();
    }
}

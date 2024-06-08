package model.floor;

import model.entity.Player;
import util.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FountainFloor extends Floor {

    public FountainFloor(int floorNum) {
        super(floorNum);
        this.prob = 5;
    }

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Encuentras una vieja fuente de piedra");
        Console.printFountain(p);
        String fountainOption = Console.printMenu(getFountainMenu(p));

        switch (fountainOption) {
            case "1":
                    int healAmount = p.getHealingForFountain();
                    int totalHealed = p.gainHp(healAmount);
                    Console.printDefault("Recuperas " + totalHealed + " puntos de vida");
                break;
            case "2":
                    Console.printDefault("!Que inteligente! Avanzas al siguiente piso");
                break;
            default:
                    if (p.hasRelic("manguitos")) {
                        int totalHealedWithManguitos = p.gainHp(p.getMaxHp());
                        Console.printDefault("Nadas un rato y te recuperas al maximo. Recuperas " + totalHealedWithManguitos + " puntos de vida");
                    }

        }
        return false;
    }

    private ArrayList<String> getFountainMenu(Player player) {
        ArrayList<String> fountainMenu = new ArrayList<>();
        String s1 = "1.- Beber";
        String s2 = "2.- Pasar de largo";
        fountainMenu.add(s1);
        fountainMenu.add(s2);
        if (player.hasRelic("manguitos")) {
            String s3 = "3.- Nadar con los manguitos";
            fountainMenu.add(s3);
        }
        return fountainMenu;
    }
}

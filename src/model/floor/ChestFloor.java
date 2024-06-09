package model.floor;

import controller.RelicController;
import model.entity.Player;
import model.relic.Relic;
import util.Console;

import java.util.ArrayList;
import java.util.Random;

public class ChestFloor extends Floor {

    public ChestFloor() {
        this.prob = 5;
    }

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Encuentras un cofre");
        Console.printChest(p);

        boolean chestEnd = false;
        while (!chestEnd) {
            String chestOption = Console.printMenu(getChestMenu(p));
            switch (chestOption) {
                case "1":
                    if (p.getKeys() > 0) {
                        Console.printDefault("Gastas una llave en abrir el cofre");
                        p.useKey();
                        openChest(p);
                        chestEnd = true;
                    } else {
                        Console.printDefault("No puedes abrir el cofre si no tienes llaves");
                        chestEnd = false;
                    }

                    break;
                case "2":
                    Console.printDefault("Debes de ser tonto, continuas al siguiente piso");
                    chestEnd = true;
                    break;
                case "3":
                    Console.printDefault("Abres el cofre con la llave maestra");
                    openChest(p);
                    chestEnd = true;
                    break;
                default:
            }
        }

        return false; //De momento no se puede morir en pisos de cofre
    }

    private ArrayList<String> getChestMenu(Player p) {
        ArrayList<String> chestMenu = new ArrayList<>();
        String s1 = "1.- Abrir";
        String s2 = "2.- Pasar de largo";
        chestMenu.add(s1);
        chestMenu.add(s2);
        if (p.hasRelic("llavemaestra")) {
            String s3 = "3.- Usar la llave maestra";
            chestMenu.add(s3);
        }
        return chestMenu;
    }

    private void openChest(Player player) {
        Relic relic = RelicController.getNewRandRelic(player);
        player.addRelic(relic);
    }
}

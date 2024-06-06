package model.floor;

import controller.RelicController;
import model.entity.Player;
import model.relic.Relic;
import util.Console;

import java.util.ArrayList;
import java.util.Random;

public class ChestFloor extends Floor {

    public ChestFloor (int floorNum) {
        super(floorNum);
        this.prob = 5;
    }

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Encuentras un cofre");
        Console.printChest(p);
        String chestOption = Console.printMenu(getChestMenu(p));
        boolean chestEnd = false;
        while (!chestEnd) {
            switch (chestOption) {
                case "1":
                    if (p.getKeys() > 0) {
                        Console.printDefault("Gastas una llave en abrir el cofre");
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
        if (p.hasRelic("Llave maestra")) {
            String s3 = "3.- Usar la llave maestra";
        }
        return chestMenu;
    }

    private void openChest() {
        Relic relic = RelicController.getRandRelic();
        //Hacer que al abrir salga una reliquia y quizas algo de oro
    }
}

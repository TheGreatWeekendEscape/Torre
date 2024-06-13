package model.floor;

import controller.PotionController;
import model.entity.Player;
import util.Console;

import java.util.ArrayList;

public class EventSellpotionsFloor extends Floor {

    int goldForPotion = 20;

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Encuentras un anciano con un saco cargado a la espalda");
        if (p.getPotionsAmount() > 0) {
            int g = p.getPotionsAmount() * goldForPotion;
            Console.printDefault("No habla pero ve tu bolsa de pociones y te ofrece " + Console.GOLD_COLOR + g + "g");
            String sellpotionsOption = Console.printMenu(getSellpotionsMenu());
            switch (sellpotionsOption) {
                case "1":
                    p.emptyPotionBag();
                    p.addGold(g);
                    break;
                case "2":
                    Console.printDefault("Avanzas al siguiente piso sin hacer caso al anciano");
                    break;
            }
        } else {
            Console.printDefault("No habla pero ve tu bolsa de pociones y ves la decepcion en su rostro");
            Console.printDefault("No sabes que queria pero avanzas al siguiente piso");
        }
        return false;
    }

    private ArrayList<String> getSellpotionsMenu() {
        ArrayList<String> sellpotionsMenu = new ArrayList<>();
        sellpotionsMenu.add("1.- Vender todas mis pociones");
        sellpotionsMenu.add("2.- Quedarse las pociones");
        return sellpotionsMenu;
    }
}

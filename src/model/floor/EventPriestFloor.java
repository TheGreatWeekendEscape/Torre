package model.floor;


import controller.SpellController;
import model.entity.Player;
import model.spell.Spell;
import util.Console;

import java.util.ArrayList;

//Cura o water spell aleatorio, de momento solo spell
public class EventPriestFloor extends Floor {

    private int healPrice = 40;
    private int spellPrice = 60;

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Te encuentras a un sacerdote que ofrece sus servicios");
        Spell s = SpellController.getNewRandSpell(p);
        boolean priestEnd = false;
        while (!priestEnd) {
            Console.printGold(p);
            String priestOption = Console.printMenu(getPriestMenu());
            switch (priestOption) {
                case "1":
                    if (p.getGold() < healPrice) {
                        Console.printDefault("No tienes dinero suficiente");
                    } else {
                        int healed = p.fullHeal();
                        Console.printDefault("Te curas " + healed + " puntos de vida");
                        priestEnd = true;
                    }
                    break;
                case "2":
                    if (p.buy(s, spellPrice)) {
                        priestEnd = true;
                    }
                    break;
                case "3":
                    priestEnd = true;
                    break;
            }
        }
        return false;
    }

    private ArrayList<String> getPriestMenu() {
        ArrayList<String> priestMenu = new ArrayList<>();
        priestMenu.add("1.- Descansar y curarse [" + Console.GOLD_COLOR + healPrice + "g" + Console.DEFAULT_COLOR + "]");
        priestMenu.add("2.- Comprar hechizo aleatorio [" + Console.GOLD_COLOR + spellPrice + "g" + Console.DEFAULT_COLOR + "]");
        priestMenu.add("3.- Ir al siguiente piso");
        return priestMenu;
    }
}

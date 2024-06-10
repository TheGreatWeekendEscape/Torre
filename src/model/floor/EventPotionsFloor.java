package model.floor;

import model.entity.Player;
import util.Console;

public class EventPotionsFloor extends Floor {
    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Evento de pociones gratis");
        return false;
    }
}

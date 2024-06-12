package model.floor;

import model.entity.Player;
import util.Console;

public class EventMoneyFloor extends Floor {
    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Evento de dinero gratis");
        return false;
    }
}

package model.floor;

import model.entity.Player;
import util.Console;

public class CombatFloor extends Floor{

    public CombatFloor(int floorNum) {
        super(floorNum);
        this.prob = 70;
    }

    @Override
    public void trigger(Player p) {
        Console.printBlue("Encuentras un enemigo");
    }
}

package model.floor;

import model.entity.Player;
import util.Console;

public class EventFloor extends Floor{

    public EventFloor (int floorNum) {
        super(floorNum);
        this.prob = 15;
    }

    @Override
    public boolean trigger(Player p) {
        Console.print("Encuentras un evento", Console.DEFAULT_COLOR);
        return false;
    }
}

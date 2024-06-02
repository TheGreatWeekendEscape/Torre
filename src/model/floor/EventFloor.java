package model.floor;

import model.entity.Player;
import util.Console;

public class EventFloor extends Floor{

    public EventFloor (int floorNum) {
        super(floorNum);
        this.prob = 15;
    }

    @Override
    public void trigger(Player p) {
        Console.printBlue("Encuentras un evento");
    }
}
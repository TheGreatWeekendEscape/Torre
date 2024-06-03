package model.floor;

import model.entity.Player;
import util.Console;

public class FountainFloor extends Floor {

    public FountainFloor(int floorNum) {
        super(floorNum);
        this.prob = 10;
    }

    @Override
    public void trigger(Player p) {
        Console.print("Has encontrado una fuente", Console.DEFAULT_COLOR);
    }
}

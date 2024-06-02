package model.floor;

import model.entity.Player;
import util.Console;

public class ShopFloor extends Floor {

    public ShopFloor (int floorNum) {
        super(floorNum);
        this.prob = 5;
    }

    @Override
    public void trigger(Player p) {
        Console.printBlue("Encuentras una tienda");
    }
}

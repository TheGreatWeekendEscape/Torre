package model.floor;

import model.entity.Player;
import util.Console;

public class ShopFloor extends Floor {

    public ShopFloor (int floorNum) {
        super(floorNum);
        this.prob = 5;
    }

    @Override
    public boolean trigger(Player p) {
        Console.print("Encuentras una tienda", Console.DEFAULT_COLOR);
        return false;
    }
}

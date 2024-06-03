package model.floor;

import controller.EntityController;
import model.entity.Entity;
import model.entity.Player;
import util.Console;

public class CombatFloor extends Floor{

    public CombatFloor(int floorNum) {
        super(floorNum);
        this.prob = 70;
    }

    @Override
    public boolean trigger(Player p) {
        Entity enemy = EntityController.getRandEnemy(super.floorNumber);
        /**
         * p.fight(enemy);
         */
        Console.print("Encuentras un enemigo", Console.DEFAULT_COLOR);
        return false;
    }
}

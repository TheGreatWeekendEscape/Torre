package model.floor;

import controller.EntityController;
import model.entity.Entity;
import model.entity.Player;
import model.entity.enemy.Enemy;
import util.Console;

public class CombatFloor extends Floor{

    public CombatFloor(int floorNum) {
        super(floorNum);
        this.prob = 70;
    }

    @Override
    public boolean trigger(Player player) {
        Enemy enemy = (Enemy)  EntityController.getRandEnemy(super.floorNumber);
        Console.print("Te encuentras con " + enemy.getDisplayName(), Console.DEFAULT_COLOR);
        if  (player.fight(enemy)) {
            Console.print("Has muerto", Console.BAD_COLOR);
            return true;
        } else {
            Console.print("Has vencido a " + enemy.getDisplayName(), Console.GOOD_COLOR);
            return false;
        }
    }
}

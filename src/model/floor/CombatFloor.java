package model.floor;

import controller.EntityController;
import game.Run;
import model.entity.Player;
import model.entity.enemy.Enemy;
import util.Console;

public class CombatFloor extends Floor{

    public CombatFloor() {
        this.prob = 70;
    }

    @Override
    public boolean trigger(Player player) {
        Enemy enemy = (Enemy)  EntityController.getRandEnemy(Run.floorNum);
        Console.print("Te encuentras con " + enemy.getDisplayName(), Console.DEFAULT_COLOR);
        if  (player.fight(enemy)) {
            Console.print("Has muerto", Console.BAD_COLOR);
            return true;
        } else {
            Console.print("Has vencido a " + enemy.getDisplayName(), Console.DEFAULT_COLOR);
            return false;
        }
    }
}

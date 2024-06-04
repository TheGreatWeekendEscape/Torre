package model.entity;

import model.spell.Spell;
import util.Console;

public class Player extends Entity{

    public Player (String name) {
        this.name = name;
    }

    public boolean fight(Entity enemy) {
        boolean fin = false;
        while (!fin) {
            Console.printFightStage(this, enemy);
            Spell enemySpell = enemy.getRandSpell();
            Console.print(enemy.getName() + " va a usar " + enemySpell.getName(), Console.DEFAULT_COLOR);
        }
        return false;
    }
}
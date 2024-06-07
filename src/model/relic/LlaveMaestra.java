package model.relic;

import model.entity.Player;
import util.Console;

public class LlaveMaestra extends Relic {

    public LlaveMaestra() {
        super.id = "llavemaestra";
        super.name = Console.ITEM_COLOR + "Llave maestra" + Console.RESET;
        super.desc = "Te permite abrir cofres sin la necesidad de usar una llave";
        super.foundText = "Que maestro";
    }

    @Override
    public void activate(Player player) {
        Console.printDefault("Obtienes " + super.name);
        Console.printDefault(super.foundText);
    }
}

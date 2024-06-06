package model.relic;

import model.entity.Player;
import util.Console;

public class LlaveMaestra extends Relic {

    public LlaveMaestra() {
        super.name = Console.ITEM_COLOR + "Llave maestra" + Console.RESET;
        super.desc = "Cuando lo encuentras ganas " + Console.ITEM_COLOR + "50g";
        super.foundText = "Son euros pero al de la tienda le vale todo";
    }

    @Override
    public void activate(Player player) {
        Console.printDefault("Obtienes " + super.name);
        Console.printDefault(super.foundText);
        player.addRelic(this);
    }
}

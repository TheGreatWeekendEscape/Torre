package model.relic;

import model.entity.Player;
import util.Console;

public class Billete extends Relic {

    public Billete() {
        super.name = Console.ITEM_COLOR + "Billete de 50 euros" + Console.RESET;
        super.desc = "Cuando lo encuentras ganas " + Console.ITEM_COLOR + "50g";
        super.foundText = "Son euros pero al de la tienda le vale todo";
    }
    @Override
    public void activate(Player player) {
        Console.printDefault("Obtienes " + super.name);
        Console.printDefault(super.foundText);
        player.setGold(player.getGold() + 50);
        player.addRelic(this);
    }
}

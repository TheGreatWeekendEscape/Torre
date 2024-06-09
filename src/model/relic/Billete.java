package model.relic;

import model.entity.Player;
import util.Console;

public class Billete extends Relic {

    public Billete() {
        super.id = "billete";
        super.name = Console.RELIC_COLOR + "Billete de 50 euros" + Console.RESET;
        super.desc = "Cuando lo encuentras ganas " + Console.GOLD_COLOR + "50g";
        super.foundText = "Moneda aceptada en la tienda de la torre";
    }
    @Override
    public void activate(Player player) {
        player.setGold(player.getGold() + 50);
    }
}

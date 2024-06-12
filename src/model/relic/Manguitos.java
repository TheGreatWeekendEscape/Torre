package model.relic;

import model.entity.Player;
import util.Console;

public class Manguitos extends Relic {

    public Manguitos() {
        super.id = "manguitos";
        super.name = Console.RELIC_COLOR + "Manguitos" + Console.RESET;
        super.desc = "Te permiten nadar en las fuentes";
        super.foundText = "Para flotar cuando nadas";
    }

    @Override
    public void activate(Player player) {

    }
}

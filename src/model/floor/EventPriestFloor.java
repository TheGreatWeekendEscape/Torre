package model.floor;


import model.entity.Player;
import util.Console;

//Cura o priest spell aleatorio, de momento solo spell
public class EventPriestFloor  extends Floor {

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Priest event");
        return false;
    }
}

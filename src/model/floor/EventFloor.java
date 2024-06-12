package model.floor;

import controller.FloorController;
import model.entity.Player;
import util.Console;

public class EventFloor extends Floor{

    public EventFloor () {
        this.prob = 15;
    }

    @Override
    public boolean trigger(Player p) {
        Floor eventFloor = FloorController.getEventFloor();
        eventFloor = new EventPriestFloor();
        eventFloor.trigger(p);
        return false;
    }
}

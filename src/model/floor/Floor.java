package model.floor;

import model.entity.Player;
import util.Console;

public abstract class Floor {

    protected int floorNumber;
    protected int prob; //Probabilidad sobre 100 de salir

    public Floor (int floorNum) {
        this.floorNumber = floorNum;
    }

    public abstract boolean trigger(Player p);

    public int getProb() {
        return this.prob;
    }
}


package model.floor;

import model.entity.Player;

public abstract class Floor {

    private int floorNumber;
    protected int prob; //Probabilidad sobre 100 de salir

    public Floor (int floorNum) {
        this.floorNumber = floorNum;
    }

    public abstract void trigger(Player p);

    public int getProb() {
        return this.prob;
    }
}

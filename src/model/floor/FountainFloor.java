package model.floor;

import model.entity.Player;
import util.Console;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FountainFloor extends Floor {

    public FountainFloor(int floorNum) {
        super(floorNum);
        this.prob = 5;
    }

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Encuentras una vieja fuente de piedra");
        Console.printFountain(p);
        String fontOption = Console.printMenu(getFountainMenu(p));
        return false;
    }

    private ArrayList<String> getFountainMenu(Player player) {
        ArrayList<String> fountainMenu = new ArrayList<>();
        int i = 1;
        String s1 = i + ".- ";
        return null; //Dolor y dinero
    }
}

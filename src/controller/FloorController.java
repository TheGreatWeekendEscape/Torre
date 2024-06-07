package controller;

import model.floor.*;

import java.util.ArrayList;
import java.util.Random;

public class FloorController {

    private static Random random = new Random();

    public static Floor getRandFloorD(int floorNum) {
        ArrayList<Floor> floors = new ArrayList<>();
        Floor combatFloor = new CombatFloor(floorNum);
        Floor eventFloor = new EventFloor(floorNum);
        Floor shopFloor = new ShopFloor(floorNum);
        Floor fountainFloor = new FountainFloor(floorNum);
        Floor chestFloor = new ChestFloor(floorNum);
        floors.add(fountainFloor);
        floors.add(combatFloor);
        floors.add(eventFloor);
        floors.add(shopFloor);
        floors.add(chestFloor);

        double rand = random.nextDouble() * 100;
        double totalSum = 0;

        for (Floor floor : floors) {
            totalSum += floor.getProb();
            if (rand <= totalSum) {
                return floor;
            }
        }
        return null;
    }

    public static Floor getRandFloor(int floorNum) {
        return new FountainFloor(floorNum);
    }
}

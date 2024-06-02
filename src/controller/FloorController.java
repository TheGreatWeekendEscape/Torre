package controller;

import model.floor.CombatFloor;
import model.floor.EventFloor;
import model.floor.Floor;
import model.floor.ShopFloor;

import java.util.ArrayList;
import java.util.Random;

public class FloorController {

    private static Random random = new Random();

    public static Floor getRandFloor(int floorNum) {
        ArrayList<Floor> floors = new ArrayList<>();
        Floor combatFloor = new CombatFloor(floorNum);
        Floor eventFloor = new EventFloor(floorNum);
        Floor shopFloor = new ShopFloor(floorNum);
        floors.add(combatFloor);
        floors.add(eventFloor);
        floors.add(shopFloor);

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
}

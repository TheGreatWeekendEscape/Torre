package controller;

import model.floor.*;

import java.util.ArrayList;
import java.util.Random;

public class FloorController {

    private static ArrayList<Floor> mainFloors = generateMainFloors();

    public static Floor getRandFloor(int floorNum) {
        Random r = new Random();
        double rand = r.nextDouble() * 100;
        double totalSum = 0;

        for (Floor floor : mainFloors) {
            totalSum += floor.getProb();
            if (rand <= totalSum) {
                return floor;
            }
        }
        return null;
    }

    public static Floor getRandFloorDev(int floorNum) {
        return new ShopFloor();
    }

    public static ArrayList<Floor> generateMainFloors() {
        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(new CombatFloor());
        floors.add(new ShopFloor());
        floors.add(new EventFloor());
        floors.add(new FountainFloor());
        floors.add(new ChestFloor());
        return floors;
    }
}

package controller;

import model.floor.*;

import java.util.ArrayList;
import java.util.Random;

public class FloorController {

    private static ArrayList<Floor> mainFloors = generateMainFloors();
    private static ArrayList<Floor> eventFloors;

    public static Floor getMainFloorD() {
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

    //Coge un evento random y lo saca del array para que no se repitan entre runs
    public static Floor getEventFloor() {
        Random r = new Random();
        Floor f = eventFloors.get(r.nextInt(eventFloors.size()));
        eventFloors
        return
    }

    public static Floor getMainFloor() {
        return new EventFloor();
    }

    private static ArrayList<Floor> generateMainFloors() {
        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(new CombatFloor());
        floors.add(new ShopFloor());
        floors.add(new EventFloor());
        floors.add(new FountainFloor());
        floors.add(new ChestFloor());
        return floors;
    }

    public static ArrayList<Floor> generateEventFloors() {
        ArrayList<Floor> floors = new ArrayList<>();
        floors.add(new EventPotionsFloor());
        floors.add(new EventPriestFloor());
        floors.add(new EventMoneyFloor());
        return floors;
    }
}

package controller;

import model.floor.*;

import java.util.ArrayList;
import java.util.Random;

public class FloorController {

    private static ArrayList<Floor> mainFloors = generateMainFloors();
    private static ArrayList<Floor> eventFloors;

    public static Floor getMainFloorDev() {
        return new EventCrowFloor();
    }

    public static Floor getMainFloor() {
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
        Random rand = new Random();
        int randIndex = rand.nextInt(eventFloors.size());
        Floor f = eventFloors.get(randIndex);
        eventFloors.remove(randIndex);
        return f;
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

    public static void generateEventFloors() {
        eventFloors = new ArrayList<>();
        eventFloors.add(new EventPotionsFloor());
        eventFloors.add(new EventPriestFloor());
        eventFloors.add(new EventCrowFloor());
        eventFloors.add(new EventSellpotionsFloor());
    }
}

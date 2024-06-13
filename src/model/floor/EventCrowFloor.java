package model.floor;

import model.entity.Player;
import util.Console;

import java.util.ArrayList;
import java.util.Random;

public class EventCrowFloor extends Floor {

    private int nestGold;


    //En el futuro que se luche contra el cuervo
    @Override
    public boolean trigger(Player p) {
        Random rand = new Random();
        nestGold = rand.nextInt(15, 60);
        Console.printDefault("La habitacion esta vacia salvo por un cuervo en las vigas");
        Console.printDefault("Parece que algo brilla en el nido pero el cuervo parece enfadado");
        String crowOption = Console.printMenu(getCrowMenu());
        switch (crowOption) {
            case "1":
                Console.printDefault("Has sido mas rapido que el cuervo");
                p.addGold(nestGold);
                break;
            case "2":
                Console.printDefault("No merece la pena, continuas subiendo");
                break;
        }
        return false;
    }

    private ArrayList<String> getCrowMenu() {
        ArrayList crowMenu = new ArrayList();
        crowMenu.add("1.- Vaciar el nido");
        crowMenu.add("2.- Ir al siguiente piso");
        return crowMenu;
    }
}

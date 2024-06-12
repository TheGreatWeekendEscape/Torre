package model.floor;

import controller.PotionController;
import model.entity.Player;
import util.Console;

public class EventPotionsFloor extends Floor {

    private int numPocionesGratis = 3;

    @Override
    public boolean trigger(Player p) {
        Console.printDefault("Encuentras una habitacion llena de trastos y te pones a rebuscar");
        Console.printDefault("Al final encuentras en un rincon una bolsa llena de pociones");
        for (int i = 0; i < numPocionesGratis; i++) {
            p.addPotion(PotionController.getRandPotion());
        }
        Console.printDefault("Avanzas al siguiente piso con la bolsa de pociones llena");
        return false;
    }
}

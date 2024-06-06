package controller;

import model.floor.Floor;
import model.relic.Billete;
import model.relic.LlaveMaestra;
import model.relic.Relic;

import java.util.ArrayList;
import java.util.Random;

public class RelicController {

    private static ArrayList<Relic> relics;

    public static void initRelics() {
        relics = new ArrayList<>();
        relics.add(new Billete());
        relics.add(new LlaveMaestra());
        for (int i = 0; i < 900;  i++) {
            getRandRelic();
        }
    }

    public static Relic getRandRelic() {
        Random rand = new Random();
        if (!relics.isEmpty()) { //Deberia controlar que pasa si no quedan relics pero en principio no pasara?
            Relic r = relics.get(rand.nextInt(relics.size()));
            relics.remove(r);
            return r;
        }
        return null;
    }
}

package controller;

import model.entity.Player;
import model.floor.Floor;
import model.relic.Billete;
import model.relic.LlaveMaestra;
import model.relic.Manguitos;
import model.relic.Relic;
import model.spell.Spell;

import java.util.ArrayList;
import java.util.Random;

public class RelicController {

    private static ArrayList<Relic> normalPool = generateRelics();

    public static ArrayList<Relic> generateRelics() {
        ArrayList<Relic> generatedRelics = new ArrayList<>();
        generatedRelics.add(new Billete());
        generatedRelics.add(new LlaveMaestra());
        generatedRelics.add(new Manguitos());
        return generatedRelics;
    }

    public static Relic getNewRandRelic(Player p) {
        Random rand = new Random();
        Relic r;
        do {
            r = normalPool.get(rand.nextInt(normalPool.size()));
        } while (p.hasRelic(r.getId()));
        return r;
    }
}

package controller;

import model.entity.Player;
import model.spell.*;

import java.util.ArrayList;
import java.util.Random;

public class SpellController {

    private static ArrayList<Spell> normalPool = generateNormalPool();


    public static Spell getNewRandSpell(Player p) {
        Random rand = new Random();
        Spell s;
        do {
            s = normalPool.get(rand.nextInt(normalPool.size()));
        } while (p.hasSpell(s));
        return s;
    }

    private static ArrayList<Spell> generateNormalPool() {
        ArrayList<Spell> generatedSpells = new ArrayList<>();
        generatedSpells.add(new AtaqueBasico());
        generatedSpells.add(new DefensaBasica());
        generatedSpells.add(new Escupitajo());
        generatedSpells.add(new LLuviaDePiedras());
        generatedSpells.add(new VivaGym());
        return generatedSpells;
    }
}

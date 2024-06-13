package controller;

import model.entity.Entity;
import model.spell.*;

import java.util.ArrayList;
import java.util.Random;

public class SpellController {

    private static ArrayList<Spell> normalPool = generateNormalPool();


    public static Spell getNewRandSpell(Entity p) {
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
        generatedSpells.add(new VivaGym());
        generatedSpells.add(new Ascua());
        generatedSpells.add(new PimPamPum());
        generatedSpells.add(new LluviaDeAire());
        generatedSpells.add(new LanzaHelada());
        generatedSpells.add(new Abucheo());
        generatedSpells.add(new Muro());
        generatedSpells.add(new Chapoteo());
        return generatedSpells;
    }
}

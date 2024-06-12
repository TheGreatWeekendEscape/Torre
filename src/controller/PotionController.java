package controller;

import model.potion.PocionDeFuego;
import model.potion.PocionDeRoca;
import model.potion.Potion;

import java.util.ArrayList;
import java.util.Random;

public class PotionController {

    private static ArrayList<Potion> potions = generatePotions();

    public static Potion getRandPotion() {
        Random rand = new Random();
        return potions.get(rand.nextInt(potions.size()));
    }

    private static ArrayList<Potion> generatePotions() {
        ArrayList<Potion> generatedPotions = new ArrayList<>();
        generatedPotions.add(new PocionDeFuego());
        generatedPotions.add(new PocionDeRoca());
        return generatedPotions;
    }
}

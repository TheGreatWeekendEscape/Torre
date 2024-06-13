package controller;

import model.potion.*;

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
        generatedPotions.add(new CoctelMolotov());
        generatedPotions.add(new PocionDeRoca());
        generatedPotions.add(new PocionDeFuego());
        generatedPotions.add(new AguaDeFuente());
        generatedPotions.add(new PocionDeViento());
        generatedPotions.add(new JugoDeMago());
        return generatedPotions;
    }
}

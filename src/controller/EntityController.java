package controller;

import model.entity.Entity;
import model.entity.enemy.Blob;
import model.entity.enemy.Llamaga;

import java.util.ArrayList;
import java.util.Random;

public class EntityController {

    private static ArrayList<String> pool0 = generatePool0();

    public static Entity getRandEnemy(int floorNum) {
        ArrayList <String> pool = pool0; //Luego se elegira la pool dependiendo el piso
        return getEnemyFromPool(pool);
    }

    private static Entity getEnemyFromPool (ArrayList<String> pool) {
        Random rand = new Random();
        String enemyName = pool.get(rand.nextInt(pool.size()));

        switch (enemyName) {
            case "Blob": return new Blob();
            case "Manticoralojomora" : return new Llamaga();
            default: return null;
        }
    }

    private static ArrayList<String> generatePool0 () {
        ArrayList<String> pool0 = new ArrayList<>();
        pool0.add("Blob");
        pool0.add("Manticoralojomora");
        return pool0;
    }
}

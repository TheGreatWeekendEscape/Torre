package model.entity;

import model.potion.PocionDeFuego;
import model.potion.PocionDeRoca;
import model.potion.Potion;
import model.spell.*;
import util.Console;

import java.util.ArrayList;

public class Player extends Entity {

    private int maxPotions;
    private ArrayList<Potion> potions;

    public Player(String name) {
        super.name = name;
        init();
    }

    private void init() {
        super.maxHp = 25;
        super.hp = super.maxHp;
        super.armor = 0;
        super.gold = 0;
        this.maxPotions = 3;
        this.potions = new ArrayList<>();
        generatePlayerSpells();
        generatePotions();
    }


    public boolean fight(Entity enemy) {
        ArrayList<Spell> unmodifiedSpells = new ArrayList<>();
        boolean nextTurn = true;
        Spell enemySpell = null;
        for (Spell s : super.spells) {
            unmodifiedSpells.add(s.clone());
        }
        while (true) {
            if (nextTurn) {
                enemySpell = enemy.getRandSpell();
            }
            Console.printFightStage(this, enemy);
            System.out.println(Console.DEFAULT_COLOR + enemy.getName() + " va a usar " + enemySpell.getName() + enemySpell.getSummary() + Console.RESET);
            String option = Console.printMenu(getCombatMenu(enemySpell.getName()));

            switch (option) {
                case "1": //Spells
                    int spellOption = Integer.parseInt(Console.printMenu(getSpellsMenu()));
                    if (spellOption <= super.spells.size()) { //Si no ha elegido volver
                        Spell playerSpell = super.spells.get(spellOption - 1);
                        Console.printSpell("Usas ", playerSpell.getName());
                        playerSpell.cast(enemy);
                        if (enemy.getHp() > 0) {
                            enemySpell.cast(this);
                        }
                        nextTurn = true;
                    } else {
                        nextTurn = false;
                    }

                    break;
                case "2": //Potions
                    int potionOption = Integer.parseInt(Console.printMenu(getPotionsMenu()));
                    if (potionOption <= this.maxPotions) {
                        Potion potion = this.potions.get(potionOption - 1);
                        if (potion == null) {
                            Console.print("Ahi no hay nada", Console.DEFAULT_COLOR);
                        } else {
                            Console.printPotion("Usas ", potion.getName());
                            potion.drink(this, enemy);
                            this.potions.set(potionOption - 1, null);
                        }

                    }
                    nextTurn = false;
                    break;
                case "3": //Relics
                    nextTurn = false;
                    break;
                case "4": //Info
                    nextTurn = false;
                    break;
                default:
                    System.out.println("Si estas leyendo esto es que hay un error en el codigo");
            }

            if (super.hp <= 0) {
                return true;
            }
            if (enemy.getHp() <= 0) {
                this.spells = unmodifiedSpells;
                return false;
            }
        }
    }

    //A partir de aqui metodos privados

    private void generatePotions() {
        this.potions.add(new PocionDeFuego());
        this.potions.add(new PocionDeRoca());
        this.potions.add(null);
    }

    private void generatePlayerSpells() {
        super.spells = new ArrayList<>();
        super.spells.add(new AtaqueBasico(this));
        super.spells.add(new DefensaBasica(this));
        super.spells.add(new LLuviaDePiedras(this));
        super.spells.add(new VivaGym(this));
    }

    private ArrayList<String> getCombatMenu(String enemySpellName) {
        ArrayList<String> combatMenu = new ArrayList<>();
        String s1 = "1.- Hechizos";
        String s2 = "2.- Bolsa de pociones";
        String s3 = "3.- Objetos";
        String s4 = "4.- Info";
        combatMenu.add(s1);
        combatMenu.add(s2);
        combatMenu.add(s3);
        combatMenu.add(s4);
        return combatMenu;
    }

    private ArrayList<String> getSpellsMenu() {
        ArrayList<String> spellsMenu = new ArrayList<>();
        for (int i = 0; i < spells.size(); i++) {
            spellsMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + spells.get(i).getName() + spells.get(i).getSummary());
        }
        spellsMenu.add(Console.DEFAULT_COLOR + (spells.size() + 1) + ".- Volver" + Console.RESET);
        return spellsMenu;
    }

    private ArrayList<String> getPotionsMenu() {
        ArrayList<String> potionsMenu = new ArrayList<>();
        for (int i = 0; i < maxPotions; i++) {
            if (this.potions.get(i) != null) {
                potionsMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + this.potions.get(i).getName() + Console.DEFAULT_COLOR + " [" + this.potions.get(i).getDesc() + "]");
            } else {
                potionsMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + "Vacio");
            }
        }
        potionsMenu.add(Console.DEFAULT_COLOR + (maxPotions + 1) + ".- Volver");
        return potionsMenu;
    }
}
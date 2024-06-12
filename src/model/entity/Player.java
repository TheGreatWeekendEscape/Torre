package model.entity;

import model.entity.enemy.Enemy;
import model.potion.PocionDeFuego;
import model.potion.PocionDeRoca;
import model.potion.Potion;
import model.relic.Manguitos;
import model.relic.Relic;
import model.spell.*;
import util.Console;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class Player extends Entity {

    private int maxPotions;
    private Potion[] potions;
    private ArrayList<Relic> relics;

    public Player(String name) {
        super.name = name;
        init();
    }

    private void init() {
        super.maxHp = 25;
        super.hp = super.maxHp;
        super.armor = 0;
        super.gold = 0;
        super.keys = 0;
        this.maxPotions = 3;
        this.potions = new Potion[maxPotions];
        this.relics = new ArrayList<>();
        generatePlayerSpells();
        generatePotions();
    }


    public boolean fight(Enemy enemy) {
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
                        Console.printDefault("Usas " + playerSpell.getName());
                        playerSpell.cast(enemy);
                        if (enemy.getHp() > 0) {
                            Console.printDefault(enemy.getName() + " usa " + enemySpell.getName());
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
                        Potion potion = this.potions[potionOption - 1];
                        if (potion == null) {
                            Console.print("Ahi no hay nada", Console.DEFAULT_COLOR);
                        } else {
                            Console.printPotion("Usas ", potion.getName());
                            potion.drink(this, enemy);
                            this.potions[potionOption - 1] = null;
                        }

                    }
                    nextTurn = false;
                    break;
                case "3": //Objects
                    nextTurn = false;
                    break;
                case "4": //Info
                    Console.printGrimoire(this, enemySpell);
                    nextTurn = false;
                    break;
                default:
                    System.out.println("Si estas leyendo esto es que hay un error en el codigo");
            }

            if (super.hp <= 0) { //Fight lost
                Console.print("Has muerto", Console.BAD_COLOR);
                return true;
            }
            if (enemy.getHp() <= 0) { //Fight won
                Console.print("Has vencido a " + enemy.getName(), Console.DEFAULT_COLOR);
                this.spells = unmodifiedSpells; //Reset all modifications to spells
                addGold(enemy.getGold());
                addKeys(enemy.getKeys());
                if (enemy.getSpellDrop() != null) {
                    addSpell(enemy.getSpellDrop());
                }
                return false;
            }
        }
    }

    public boolean hasFreePotionSlot() {
        for (int i = 0; i < potions.length; i++) {
            if (potions[i] == null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addSpell(Spell s) {
        s.setCaster(this);
        Console.printDefault("Obtienes " + s.getName());
        this.spells.add(s);
    }

    public void addKeys(int amount) {
        if (amount == 1) {
            Console.printDefault("Obtienes " + Console.KEY_COLOR + "llave" + Console.RESET);
        } else if (amount > 1) {
            Console.printDefault("Obtienes " + Console.KEY_COLOR + amount + " llaves" + Console.RESET);
        }

    }

    public void addGold(int amount) {
        super.gold += amount;
        Console.printDefault("Obtienes " + Console.GOLD_COLOR + amount + "g" + Console.RESET);
    }

    public void addRelic(Relic r) {
        r.activate(this);
        Console.printDefault("Obtienes " + r.getName());
        Console.printDefault(r.getFoundText());
        this.relics.add(r);
    }

    public void addPotion(Potion p) {
        if (hasFreePotionSlot()) {
            for (int i = 0; i < potions.length; i++) {
                if (potions[i] == null) {
                    potions[i] = p;
                    Console.printDefault("Obtienes " + p.getName());
                    break;
                }
            }
        } else {
            Console.printDefault("Obtienes " + p.getName() + Console.DEFAULT_COLOR + " pero no tienes hueco para guardar mas pociones");
            Console.printDefault("Quieres tirar alguna pocion para hacer hueco?");
            int discardPotionsOption = Integer.parseInt(Console.printMenu(getPotionsDiscardMenu(p)));
            if (discardPotionsOption == potions.length + 1) {
                Console.printDefault("Te quedas con las pociones que tenias");
            } else {
                Console.printDefault("Tiras " + potions[discardPotionsOption - 1].getName());
                potions[discardPotionsOption - 1] = null;
                addPotion(p);
            }
        }
    }

    public boolean hasRelic(String relicId) {
        for (Relic r : relics) {
            if (r.getId().equalsIgnoreCase(relicId)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasSpell(Spell spell) {
        for (Spell s : spells) {
            if (spell.getName().equalsIgnoreCase(s.getName())) {
                return true;
            }
        }
        return false;
    }

    public void useKey() {
        this.keys -= 1;
        if (keys < 0) {
            keys = 0;
        }
    }

    public boolean buy(Potion p, int price) {
        if (this.gold >= price) {
            addPotion(p);
            this.gold -= price;
            return true;
        } else {
            Console.printDefault("No tienes dinero suficiente");
            return false;
        }
    }

    public boolean buy(Relic r, int price) {
        if (this.gold >= price) {
            this.gold -= price;
            addRelic(r);
            return true;
        } else {
            Console.printDefault("No tienes dinero suficiente");
            return false;
        }

    }

    public boolean buy(Spell s, int price) {
        if (this.gold >= price) {
            this.gold -= price;
            addSpell(s);
            return true;
        } else {
            Console.printDefault("No tienes dinero suficiente");
            return false;
        }

    }


    //A partir de aqui metodos privados

    private void generatePotions() {
        this.potions[0] = new PocionDeFuego();
        this.potions[1] = null;
        this.potions[2] = null;
    }

    private void generatePlayerSpells() {
        super.spells = new ArrayList<>();
        AtaqueBasico s1 = new AtaqueBasico();
        DefensaBasica s2 = new DefensaBasica();
        LLuviaDePiedras s3 = new LLuviaDePiedras();
        s1.setCaster(this);
        s2.setCaster(this);
        s3.setCaster(this);
        super.spells.add(s1);
        super.spells.add(s2);
        super.spells.add(s3);
    }

    private ArrayList<String> getCombatMenu(String enemySpellName) {
        ArrayList<String> combatMenu = new ArrayList<>();
        String s1 = "1.- Hechizos";
        String s2 = "2.- Bolsa de pociones";
        String s3 = "3.- Tesoros";
        String s4 = "4.- Grimorio";
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
        for (int i = 0; i < potions.length; i++) {
            if (this.potions[i] != null) {
                potionsMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + this.potions[i].getName() + Console.DEFAULT_COLOR + " [" + this.potions[i].getDesc() + "]");
            } else {
                potionsMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + "Vacio");
            }
        }
        potionsMenu.add(Console.DEFAULT_COLOR + (maxPotions + 1) + ".- Volver");
        return potionsMenu;
    }

    private ArrayList<String> getPotionsDiscardMenu(Potion extraPotion) {
        ArrayList<String> potionsDiscardMenu = new ArrayList<>();
        for (int i = 0; i < potions.length; i++) {
            potionsDiscardMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + this.potions[i].getName() + Console.DEFAULT_COLOR + " [" + this.potions[i].getDesc() + "]");
        }
        potionsDiscardMenu.add(Console.DEFAULT_COLOR + (potions.length + 1) + ".- No quiero " + extraPotion.getName() + Console.DEFAULT_COLOR + " [" + extraPotion.getDesc() + "]");
        return potionsDiscardMenu;
    }
}
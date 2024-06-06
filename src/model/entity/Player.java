package model.entity;

import model.spell.*;
import util.Console;

import java.util.ArrayList;

public class Player extends Entity{

    public Player (String name) {
        super.name = name;
        init();
    }

    private void init() {
        super.maxHp = 25;
        super.hp = super.maxHp;
        super.armor = 0;
        super.gold = 0;
        generatePlayerSpells();
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
            System.out.println(Console.DEFAULT_COLOR + enemy.getName() + " va a usar " + Console.SPELL_COLOR + enemySpell.getName() + enemySpell.getSummary() + Console.RESET);
            String option = Console.printMenu(getCombatMenu(enemySpell.getName()));

            switch (option) {
                case "1": //Spells
                    int spellsOption = Integer.parseInt(Console.printMenu(getSpellsMenu()));
                    if (spellsOption <= super.spells.size()) { //Si no ha elegido volver
                        Spell playerSpell = super.spells.get(spellsOption - 1);
                        Console.printSpell("Usas ", playerSpell.getName());
                        playerSpell.cast(enemy);
                        if (enemy.getHp() > 0) {
                            enemySpell.cast(this);
                        }
                    }
                    nextTurn = true;
                    break;
                case "2": //Potions
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

    void generatePlayerSpells() {
        super.spells = new ArrayList<>();
        super.spells.add(new AtaqueBasico(this));
        super.spells.add(new DefensaBasica(this));
        super.spells.add(new LLuviaDePiedras(this));
        super.spells.add(new VivaGym(this));
    }

    //A partir de aqui metodos privados

    private ArrayList<String> getCombatMenu(String enemySpellName) {
        ArrayList<String> combatMenu = new ArrayList<>();
        String s1 = "1.- Hechizos";
        String s2 = "2.- Pociones";
        String s3 = "3.- Tesoros";
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
            spellsMenu.add(Console.DEFAULT_COLOR + (i + 1) + ".- " + Console.SPELL_COLOR + spells.get(i).getName() + Console.RESET +  spells.get(i).getSummary());
        }
        spellsMenu.add(Console.DEFAULT_COLOR + (spells.size() + 1) + ".- Volver" + Console.RESET);
        return spellsMenu;
    }
}
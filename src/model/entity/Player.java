package model.entity;

import model.spell.AtaqueBasico;
import model.spell.DefensaBasica;
import model.spell.Spell;
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
        int turn = 0;
        boolean fin = false;
        while (!fin) {
            turn ++;
            Console.printFightStage(this, enemy);
            Spell enemySpell = enemy.getRandSpell();
            System.out.println(Console.DEFAULT_COLOR + enemy.getName() + " va a usar " + Console.SPELL_COLOR + enemySpell.getName() + Console.RESET);
            String option = Console.printMenu(getCombatMenu(enemySpell.getName()));

            switch (option) {
                case "1": //Spells
                    int spellsOption = Integer.parseInt(Console.printMenu(getSpellsMenu()));
                    if (spellsOption <= super.spells.size()) { //Si no ha elegido volver
                        Spell playerSpell = super.spells.get(spellsOption - 1);
                        Console.printSpell("Usas ", playerSpell.getName());
                        playerSpell.cast(enemy);
                        enemySpell.cast(this);
                    }
                    break;
                case "2": //Potions
                    break;
                case "3": //Relics
                    break;
                case "4": //Info
                    break;
                default:
                    System.out.println("Si estas leyendo esto es que hay un error en el codigo");
            }

            if (super.hp <= 0) {
                return true;
            }
            if (enemy.getHp() <= 0) {
                return false;
            }
        }
        return false;
    }

    void generatePlayerSpells() {
        super.spells = new ArrayList<>();
        super.spells.add(new AtaqueBasico(this));
        super.spells.add(new DefensaBasica(this));
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
        spellsMenu.add(Console.DEFAULT_COLOR + spells.size() + 1 + ".- Volver" + Console.RESET);
        return spellsMenu;
    }
}
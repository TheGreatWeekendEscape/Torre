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

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int armor;
    protected ArrayList<Spell> spells;
    protected int gold;

    private void init() {
        super.maxHp = 25;
        super.hp = super.maxHp;
        super.armor = 0;
        generatePlayerSpells();
    }

    public boolean fight(Entity enemy) {
        boolean fin = false;
        while (!fin) {
            Console.printFightStage(this, enemy);
            Spell enemySpell = enemy.getRandSpell();
            Console.print(Console.DEFAULT_COLOR + enemy.getName() + " va a usar " + Console.SPELL_COLOR + enemySpell.getName() + Console.DEFAULT_COLOR);
            String option = Console.printMenu(getCombatMenu(enemySpell.getName()));

            switch (option) {
                case "1": //Spells
                    String spellsOption = Console.printMenu(getSpellsMenu());
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
        ArrayList<String> spellsMenu = new ArrayList<>(); //Spells es null corregir mañana
        for (int i = 0; i < spells.size(); i++) {
            spellsMenu.add((i + 1) + ".- " + spells.get(i).getName());
        }
        return spellsMenu;
    }
}
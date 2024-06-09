package model.floor;

import controller.PotionController;
import controller.RelicController;
import controller.SpellController;
import model.entity.Player;
import model.potion.Potion;
import model.relic.Relic;
import model.spell.Spell;
import util.Console;

import java.util.ArrayList;

public class ShopFloor extends Floor {

    public ShopFloor() {
        this.prob = 5;
    }

    @Override
    public boolean trigger(Player p) {
        p.setGold(200);
        Console.printDefault("Encuentras un anciano");
        Console.printDefault("No habla pero te muestra objetos que tiene a la venta");
        boolean shopEnd = false;
        int basePrice = 25;
        Potion potion = PotionController.getRandPotion();
        Spell spell = SpellController.getNewRandSpell(p);
        Relic relic = RelicController.getNewRandRelic(p);
        ArrayList<Object> shop = new ArrayList<>();
        shop.add(potion);
        shop.add(spell);
        shop.add(relic);
        while (!shopEnd) {
            Console.printGold(p);
            String shopOption = Console.printMenu(getShopMenu(shop, basePrice));
            switch (shopOption) {
                case "1": //Salir
                    shopEnd = true;
                    break;
                case "2": //Potion 1
                    if (shop.get(0) != null) {
                        if (p.buy(potion, basePrice)) {
                            shop.set(0, null);
                        }
                    } else {
                        Console.printDefault("Producto agotado");
                    }
                    break;
                case "3": //Spell 1
                    if (shop.get(1) != null) {
                        if (p.buy(spell, basePrice*2)) {
                            shop.set(1, null);
                        }
                    } else {
                        Console.printDefault("Producto agotado");
                    }
                    break;
                case "4": //Relic 1
                    if (shop.get(2) != null) {
                        if (p.buy(relic, basePrice*3)) {
                            shop.set(2, null);
                        }
                    } else {
                        Console.printDefault("Producto agotado");
                    }
                    break;
                default:
                    System.out.println("No deberia pasar esto");
            }
        }

        return false;
    }

    private ArrayList<String> getShopMenu(ArrayList<Object> shop, int basePrice) {
        ArrayList<String> shopMenu = new ArrayList<>();
        shopMenu.add("1.- Salir");
        for (int i = 0; i < shop.size(); i++) {
            if (shop.get(i) == null) {
                shopMenu.add((i + 2) + ".- AGOTADO");
            } else if (shop.get(i) instanceof Potion) {
                Potion p = (Potion) shop.get(i);
                shopMenu.add(Console.DEFAULT_COLOR + (i + 2) + ".- " + p.getName() + Console.DEFAULT_COLOR + " [" + Console.GOLD_COLOR + basePrice + "g" + Console.DEFAULT_COLOR + "]");
            } else if (shop.get(i) instanceof Spell) {
                Spell s = (Spell) shop.get(i);
                shopMenu.add(Console.DEFAULT_COLOR + (i + 2) + ".- " + s.getName() + Console.DEFAULT_COLOR + " [" + Console.GOLD_COLOR + basePrice * 2 + "g" + Console.DEFAULT_COLOR + "]");
            } else if (shop.get(i) instanceof Relic) {
                Relic r = (Relic) shop.get(i);
                shopMenu.add(Console.DEFAULT_COLOR + (i + 2) + ".- " + r.getName() + Console.DEFAULT_COLOR + " [" + Console.GOLD_COLOR + basePrice * 3 + "g" + Console.DEFAULT_COLOR + "]");
            }
        }
        return shopMenu;
    }
}

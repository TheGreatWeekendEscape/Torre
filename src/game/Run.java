package game;

import controller.FloorController;
import controller.RelicController;
import model.floor.Floor;
import model.entity.Player;
import util.Console;

import java.sql.Array;
import java.util.ArrayList;

public class Run {

    private Player player;
    private int floorNum;
    private boolean fin;

    public Run (Player p) {
        this.player = p;
        configure();
    }

    private void configure() {
        this.floorNum = 0;
        this.fin = false;
    }

    public boolean play() {
        //Cosas antes de que empiece una run
        RelicController.initRelics();

        while (!fin) {
            floorNum++;
            Console.printBackground("PISO " + floorNum + ":", Console.FLOOR_COLOR, Console.FLOOR_BACKGROUND);
            Floor floor = FloorController.getRandFloor(floorNum);
            fin = floor.trigger(player);
        }

        String option = Console.printMenu(getPlayagainMenu());
        if (option.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    private ArrayList<String> getPlayagainMenu() {
        ArrayList<String> playagainMenu = new ArrayList<>();
        String s1 = Console.DEFAULT_COLOR + "1.- Si";
        String s2 = Console.DEFAULT_COLOR + "2.- No";
        playagainMenu.add(s1);
        playagainMenu.add(s2);
        return playagainMenu;
    }
}

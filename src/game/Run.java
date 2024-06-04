package game;

import controller.FloorController;
import model.floor.Floor;
import model.entity.Player;
import util.Console;

public class Run {

    private Player player;
    private int floorNum;
    private boolean fin;

    public Run (Player p) {
        this.player = p;
        configure();
        play();
    }

    private void configure() {
        this.floorNum = 0;
        this.fin = false;
    }

    private void play() {
        while (!fin) {
            floorNum++;
            Console.printBackground("PISO " + floorNum + ":", Console.FLOOR_COLOR, Console.FLOOR_BACKGROUND);
            Floor floor = FloorController.getRandFloor(floorNum);
            fin = floor.trigger(player);
        }
    }
}

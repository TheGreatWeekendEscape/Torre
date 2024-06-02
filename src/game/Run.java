package game;

import model.Floor;
import model.entity.Player;

public class Run {

    private Player p;
    private int floorNum;
    private boolean fin;

    public Run (Player p) {
        this.p = p;
        configure();
        play();
    }

    private void configure() {
        this.floorNum = 0;
        this.fin = false;
    }

    private void play() {
        while (!fin) {
            Floor f = new Floor(this.floorNum);
        }
    }
}

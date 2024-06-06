import game.Run;
import model.entity.Player;


public class Main {
    public static void main(String[] args) {
        boolean playAgain = true;
        while (playAgain) {
            Player p = new Player("Weekend");
            Run r = new Run(p);
            playAgain = r.play();
        }

    }

}
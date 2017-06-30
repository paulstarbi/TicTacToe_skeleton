package ps;

import ps.BoardGame.BoardManager;
import ps.Players.Player;
import ps.Players.PlayerCreator;

public class Main {

    public static void main(String[] args) {
        BoardManager boardManager = new BoardManager();
        PlayerCreator creator = new PlayerCreator(System.in);
        Player p1 = creator.createPlayer();
        Player p2 = creator.createPlayer(p1.getSign());

        GameEngine game = new GameEngine(p1,p2);
        game.play(boardManager,creator);

    }
}


package ps;

import ps.BoardGame.BoardManager;

public class Main {

    public static void main(String[] args) {
        BoardManager boardManager = new BoardManager();
        Stremer creator = new Stremer();
        Player p1 = creator.createPlayer();
        Player p2 = creator.createPlayer(p1.getSign());

        GameEngine game = new GameEngine();
        game.play(boardManager, p1, p2,creator);

    }
}


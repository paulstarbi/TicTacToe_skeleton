package ps;

import ps.BoardGame.BoardManager;
import ps.Players.Player;
import ps.Streamers.Stremer;

import java.util.SortedMap;

public class GameEngine {
    final int numberOfGames=3;
    Player p1;
    Player p2;
    private boolean win;

    public GameEngine(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.win = false;
    }

    void play(BoardManager boardManager, Stremer in) {
        SortedMap<Integer,String> myBoard =boardManager.boardCreator();
        Player currentPlayer = p1;
        for(int i=0;i<numberOfGames;i++){
            while(!win) {
                boardManager.drawBoard();
                win=boardManager.updateBoard(in.doYourMove(myBoard,currentPlayer), currentPlayer.getSign());
                if(win){
                    System.out.println("Congratulation "+currentPlayer.name+" win");
                    currentPlayer.pPoints+=3;
                }
            }
            currentPlayer = switchPlayer(currentPlayer);
            win=false;
        }
        System.out.println("Final results:");
        System.out.println(p1);
        System.out.println(p2);
    }

    Player switchPlayer(Player currPlayer){
        if(currPlayer==p1)
            currPlayer=p2;
        else currPlayer=p1;
    return  currPlayer;
    }
}

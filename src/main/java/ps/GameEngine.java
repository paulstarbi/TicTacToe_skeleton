package ps;

import ps.BoardGame.BoardManager;

import java.util.SortedMap;

public class GameEngine {
    boolean win=false;

    int numberOfGames=3;

    public void play(BoardManager boardManager, Player p1, Player p2, Stremer in) {
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
                if(currentPlayer==p1)
                    currentPlayer=p2;
                else currentPlayer=p1;
            }
            win=false;
        }
        System.out.println("Final results:");
        System.out.println(p1);
        System.out.println(p2);
    }
}

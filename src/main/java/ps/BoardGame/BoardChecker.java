package ps.BoardGame;

import java.util.SortedMap;

public class BoardChecker {

    SortedMap<Integer, String> board;
    int size;
    String sign;
    int hitCounter=0;

    public BoardChecker(SortedMap<Integer, String> board, int size, String sign) {
        this.board = board;
        this.size = size;
        this.sign = sign;
    }

    public int hitCheckerUpDown(int startPosition){
        int currentPosition;
        if(startPosition<=0)startPosition+=size;
        if(board.containsKey(startPosition)){
            if(board.get(startPosition)==sign){
                hitCounter++;
            }else hitCounter--;
            currentPosition =startPosition+size;
            hitCheckerUpDown(currentPosition);
        }
        return hitCounter;
    }

    public boolean isWin(int position) {
        int hitUD = hitCheckerUpDown(position-((position/size)*size));
        if (hitUD==3) return true;

        else return false;
    }



}

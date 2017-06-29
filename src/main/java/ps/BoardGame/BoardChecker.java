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

    public void hitCheckerUp(int position){
        if(board.containsKey(position-size)&&board.get(position-size)==sign){
            int currentPosition = position-size;
            hitCounter++;
            hitCheckerUp(currentPosition);
        }

        isWin(hitCounter);
    }

    private void isWin(int hitCounter) {

    }

}

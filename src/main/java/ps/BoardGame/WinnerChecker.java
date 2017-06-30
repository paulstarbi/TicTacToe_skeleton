package ps.BoardGame;

import java.util.SortedMap;

public class WinnerChecker {

    SortedMap<Integer, String> board;
    int size;
    String sign;
    private int verticalCheck;
    private int horizontalCheck;

    public WinnerChecker(SortedMap<Integer, String> board, int size, String sign) {
        this.board = board;
        this.size = size;
        this.sign = sign;
        this.verticalCheck =0;
        this.horizontalCheck =0;
    }

    public int hitCheckerUpDown(int startPosition){
        int currentPosition;
        if(startPosition<=0)startPosition+=size;
        if(board.containsKey(startPosition)){
            if(board.get(startPosition).equals(sign)){
                verticalCheck++;
            }else verticalCheck--;
            currentPosition =startPosition+size;
            hitCheckerUpDown(currentPosition);
        }
        return verticalCheck;
    }

    private int hitCheckerHorizontal(int startPosition) {
        for (int i=0;i<size;i++) {
            if(board.get(startPosition).equals(sign)){
                horizontalCheck++;
            }
            startPosition++;
        }return horizontalCheck;
    }

    public boolean isWin(int position) {
        verticalCheck = hitCheckerUpDown(position-((position/size)*size));
        horizontalCheck = hitCheckerHorizontal(1+(((position-1)/size)*size));
        if (verticalCheck==3) return true;
        else if (horizontalCheck==3) return true;
        else return false;
    }


}

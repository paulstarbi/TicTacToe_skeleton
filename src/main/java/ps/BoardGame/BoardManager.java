package ps.BoardGame;

import java.util.*;


public class BoardManager {

    SortedMap<Integer, String> board;
    int counter;
    int boardWidth;
    int boardHeight;
    int boardLengt;


    public BoardManager() {
        this.boardWidth = 12;
        this.boardHeight =16;
        this.counter =0;
        this.boardLengt = boardHeight *boardWidth;
    }

    public SortedMap<Integer, String> boardCreator(){
        SortedMap<Integer, String> hmap= new TreeMap<>();
        for (int i=1;i<=boardLengt;i++){
            hmap.put(i,"|");
        }
        this.board=hmap;
        return this.board;
    }

    public void  drawBoard(){
        Set set = board.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mEntry = (Map.Entry) iterator.next();
            if (counter!=0&& counter%boardWidth ==0)
                System.out.println();
            if(mEntry.getValue().equals("|"))
                System.out.printf(mEntry.getKey().toString() + mEntry.getValue());
            else
                System.out.printf(mEntry.getValue()+"|");
            counter++;
        }
        System.out.println();
    }

    public boolean updateBoard(int where, String sign) {
        if (board.containsKey(where)){
        board.put(where,sign);}else {
            throw new InputMismatchException();
        }
        WinnerChecker checker = new WinnerChecker(board, boardWidth,sign);
        return checker.isWin(where);
    }
}



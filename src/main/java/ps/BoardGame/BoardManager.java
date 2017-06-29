package ps.BoardGame;

import java.util.*;


public class BoardManager {

    SortedMap<Integer, String> board;
    int licznik;
    int width;

    public BoardManager() {
        this.width = 3;
        this.licznik=0;
    }

    public  SortedMap<Integer, String> boardCreator(){
        SortedMap<Integer, String> hmap= new TreeMap<>();
        for (int i=1;i<=9;i++){
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
            if (licznik!=0&&licznik%width==0)
                System.out.println();
            if(mEntry.getValue().equals("|"))
                System.out.printf(mEntry.getKey().toString() + mEntry.getValue());
            else
                System.out.printf(mEntry.getValue()+"|");
            licznik++;
        }
        System.out.println();
    }

    public boolean updateBoard(int where, String sign) {
        if (board.containsKey(where)){
        board.put(where,sign);}else {
            throw new InputMismatchException();
        }
        BoardChecker checker = new BoardChecker(board,width,sign);
        return checker.isWin(where);
    }
}



package ps.BoardGame;

import java.util.SortedMap;

public class BoardUpdater  {


    public void updateBoard(int where, String sign, SortedMap<Integer, String> board) {
        try{
            if (where>board.lastKey().intValue()) throw new IndexOutOfBoundsException();
                        board.put(where,sign);
        }
        catch (IndexOutOfBoundsException ex){
            System.out.println("Wrong position ! Chose number from board !");
        }
    }
}

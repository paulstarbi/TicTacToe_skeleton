package ps.BoardGame;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class BoardDrawer {
    int licznik;
    int size;

    public BoardDrawer() {
    }

    public BoardDrawer(int licznik, int size) {
        this.licznik = licznik;
        this.size = size;
    }

    void  drawBoard(Map<Integer,String> board){
          Set set = board.entrySet();
          Iterator iterator = set.iterator();
          while (iterator.hasNext()) {
              Map.Entry mEntry = (Map.Entry) iterator.next();
              if (licznik!=0&&licznik%size==0)
                  System.out.println();
              if(mEntry.getValue().equals("|"))
              System.out.printf(mEntry.getKey().toString() + mEntry.getValue());
              else
              System.out.printf(mEntry.getValue()+"|");
                licznik++;
          }
    }
}

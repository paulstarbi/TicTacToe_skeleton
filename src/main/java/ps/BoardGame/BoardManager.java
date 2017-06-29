package ps.BoardGame;

import java.util.SortedMap;
import java.util.TreeMap;


public class BoardManager {

    public SortedMap<Integer, String> boardCreator(){
        BoardDrawer drawer = new BoardDrawer(0,3);
        SortedMap<Integer, String> hmap= new TreeMap<>();
        for (int i=1;i<=9;i++){
            hmap.put(i,"|");
        }
        return  hmap;
    }



}



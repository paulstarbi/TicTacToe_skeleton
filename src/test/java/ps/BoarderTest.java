package ps;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ps.BoardGame.*;

import java.util.SortedMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoarderTest {


    BoardManager boardMan = new BoardManager();
    BoardUpdater updater = new BoardUpdater();
    BoardChecker checker = new BoardChecker();

    @DataProvider(name = "mapTester")
    public static Object[][] startEntry(){
        return new Object[][] {
        {1,"|"},{9,"|"},{5,"|"}};
    }

    @Test
    public void isCreatedBordNoEmpty(){

        assertFalse(boardMan.boardCreator().isEmpty());
    }

    @Test(dataProvider = "mapTester")
    public void isFieldContainsCorrectValues(Integer key,String val){
        SortedMap<Integer,String> myBoard = boardMan.boardCreator();
        assertEquals(myBoard.get(key),val);

    }
    @Test public void isBoradUpdatesAfterMovesCorrect(){
        SortedMap<Integer,String> board = boardMan.boardCreator();
        updater.updateBoard(3,"X",board);
        assertEquals(board.get(3),"X");
    }

    @Test public void isWin(){

        assertTrue(checker.hitChecker(3));
    }

}

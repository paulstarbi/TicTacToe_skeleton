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

    @DataProvider(name = "mapTester")
    public static Object[][] startEntry(){
        return new Object[][] {
        {1,"|"},{9,"|"},{5,"|"}};
    }
    @DataProvider(name = "win")
    public static Object[][] win() {
        return new Object[][]{
                {1, "X"}, {4, "X"}, {7, "X"}};
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
        assertEquals(board.get(3),"X");
    }

    @Test(dataProvider = "win")
    public void isWin(Integer i,String val){
        SortedMap<Integer,String> board = boardMan.boardCreator();
        boardMan.updateBoard(i,val);
        assertEquals(false,boardMan.updateBoard(2,"O"));
        assertEquals(false,boardMan.updateBoard(5,"O"));
        assertEquals(true, boardMan.updateBoard(8,"O"));

        boardMan.drawBoard();
    }

}

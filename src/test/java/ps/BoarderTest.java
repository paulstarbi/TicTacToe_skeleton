package ps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ps.BoardGame.*;

import java.io.ByteArrayInputStream;
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
    @DataProvider(name = "simplePleayers")
    public static Object[][] startPlayers(){
        return new Object[][] {
                {"Zupelnie Nikt","X"},{"Darth Vader","O"},{"Aragorn","O"}};
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

    }
    @Test(dataProvider = "simplePleayers")
    public void simplePlayerCreation(String name, String sign){
        Player p = new Player(name,sign);
        assertEquals(p.name,name);
        assertEquals(p.getSign(),sign);
    }
    @Test
    public void isWinConditionVerticalThree(){
        SortedMap<Integer,String> board = boardMan.boardCreator();
        assertFalse(boardMan.updateBoard(2,"O"));
        assertFalse(boardMan.updateBoard(8,"O"));
        assertTrue(boardMan.updateBoard(5,"O"));

    }
    @Test
    public void isWinConditionHorizontalThree(){
        SortedMap<Integer,String> board = boardMan.boardCreator();
        assertFalse(boardMan.updateBoard(1,"O"));
        assertFalse(boardMan.updateBoard(3,"O"));
        assertTrue(boardMan.updateBoard(2,"O"));
    }



}

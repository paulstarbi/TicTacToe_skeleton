package ps;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ps.BoardGame.*;
import ps.Players.Player;
import ps.Players.PlayerCreator;
import ps.Streamers.Stremer;

import java.io.ByteArrayInputStream;
import java.util.SortedMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class BoarderTest {


    BoardManager boardMan = new BoardManager();

    @DataProvider(name = "mapTester")
    public static Object[][] startEntry() {
        return new Object[][]{
                {1, "|"}, {9, "|"}, {5, "|"}};
    }

    @DataProvider(name = "simplePleayers")
    public static Object[][] startPlayers() {
        return new Object[][]{
                {"Zupelnie Nikt", "X"}, {"Darth Vader", "O"}, {"Aragorn", "O"}};
    }

    @DataProvider(name = "allowedMoves")
    public static Object[][] movesEntry() {
        return new Object[][]{
                {"9"}, {"2"}, {"1"}, {"5"}};
    }

    @DataProvider(name = "noAllowedMoves")
    public static Object[][] movesNotAllowedEntry() {
        return new Object[][]{
                {"15"}, {"11"}, {"21"}, {"5"}};
    }

    @Test
    public void isCreatedBordNoEmpty() {

        assertFalse(boardMan.boardCreator().isEmpty());
    }

    @Test(dataProvider = "mapTester")
    public void isFieldContainsCorrectValues(Integer key, String val) {
        SortedMap<Integer, String> myBoard = boardMan.boardCreator();
        assertEquals(myBoard.get(key), val);

    }

    @Test
    public void isBoradUpdatesAfterMovesCorrect() {
        SortedMap<Integer, String> board = boardMan.boardCreator();
    }

    @Test(dataProvider = "simplePleayers")
    public void simplePlayerCreation(String name, String sign){
        Player p = new Player(name,sign);
        assertEquals(p.name,name);
        assertEquals(p.getSign(),sign);
    }

    @Test
    public void creatingSecondPlayerByStream(){
        ByteArrayInputStream newIn = new ByteArrayInputStream("Player".getBytes());
        PlayerCreator creator = new PlayerCreator(newIn);
        Player p2 = creator.createPlayer("X");
        assertEquals(p2.name,"Player");
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

    @Test(dataProvider = "allowedMoves")
    public void allowedMoveChecker(String move){
        ByteArrayInputStream allowedIn = new ByteArrayInputStream(move.getBytes());
        SortedMap<Integer,String> board = boardMan.boardCreator();
        Stremer creator = new Stremer(allowedIn);
        Player p1 = new Player("PL","X");
        creator.doYourMove(board,p1);
        assertEquals(board.get(Integer.parseInt(move)),"X");
    }

}

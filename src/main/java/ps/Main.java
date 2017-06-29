package ps;

import ps.BoardGame.BoardManager;

import java.util.Scanner;

/**
 * Created by paul on 28.06.17.
 */
public class Main {

    public static void main(String[] args) {
        String p1 = "X";
        String p2 = "O";
        BoardManager board = new BoardManager();
//  TODO player clas
//  TODO BoardManager Class enable to chose how big the board should be, and appropriate prompting

        board.boardCreator();

        System.out.println("Which mark (O or X) start? ");
        Scanner in = new Scanner(System.in);
        String start = in.nextLine();
//  TODO Validation class - checking if appropriate value was giving by users
//        if (start.equals("X")){
//            System.out.println(p1 + " begin");
//             next = p2;
//             start = p1;
//    }
//        else {System.out.println(p2 + " begin");
//         next = p1;
//        start = p2;
//        }


//  TODO BoardUpdater - updating board with actualr player mark on appropriate position
//  TODO BusyField - checking if the field which player chose hadn't choosen before ?
//    TODO Winner - checking if someone already win
    }
}

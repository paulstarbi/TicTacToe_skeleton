package ps;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Stremer {
    Scanner in = new Scanner(System.in);

    public Player createPlayer() {
        return new Player(getName(),getSign());
    }
    public Player createPlayer(String sign) {
        if(sign.equals("X"))
        return new Player(getName(),"O");
        else return new Player(getName(),"X");
    }

    private String getName() {
        System.out.println("Player name: ");
        return in.nextLine();
    }

    private String getSign() {

        System.out.println("Chose sign: X or O");
        String sign = in.nextLine().toUpperCase();
        if (sign.equals("O") || sign.equals("X"))
            return sign;
        else {
            System.out.println("Wrong choice only : O or X are avaiable");
            return getSign();
        }
    }
    public int doYourMove(SortedMap<Integer,String> board, Player p){
            System.out.println("Where to put " +p.getSign());
            Scanner in = new Scanner(System.in);
         try{   int move = in.nextInt();
        if (board.containsKey(move)){
            board.put(move,p.getSign());
            return move;
        }
            else {
            throw new InputMismatchException();
        }}catch (InputMismatchException ex){
             System.err.println("Chose number from board");
             return doYourMove(board,p);

         }
    }

}
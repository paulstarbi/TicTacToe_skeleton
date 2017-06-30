package ps;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.SortedMap;

public class Stremer {
    InputStream in;

    public Stremer(InputStream in) {
        this.in = in;
    }

    public Player createPlayer() {
        return new Player(getName(),getSign());
    }

    public Player createPlayer(String sign) {
        if(sign.equals("X"))
        return new Player(getName(),"O");
        else return new Player(getName(),"X");
    }

    private String getName() {
        Scanner keyboard = new Scanner(in);
        System.out.println("Player name: ");
        return keyboard.nextLine();
    }

    private String getSign() {
        Scanner keyboard = new Scanner(in);
        System.out.println("Chose sign: X or O");
        String sign = keyboard.nextLine().toUpperCase();
        if (sign.equals("O") || sign.equals("X"))
            return sign;
        else {
            System.out.println("Wrong choice only : O or X are avaiable");
            return getSign();
        }
    }
    public int doYourMove(SortedMap<Integer,String> board, Player p){
            System.out.println("Where to put " +p.getSign());
            Scanner keyboard = new Scanner(in);
         try{   int move = keyboard.nextInt();
        if (board.containsKey(move)&&!board.get(move).equals("X")&&!board.get(move).equals("O")){
            board.put(move,p.getSign());
            return move;
        }
            else {
            throw new InputMismatchException();
        }}catch (InputMismatchException ex){
             System.err.println("Chose appropriate number from board");
             return doYourMove(board,p);

         }
    }

}
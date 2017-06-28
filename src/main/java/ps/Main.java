package ps;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by paul on 28.06.17.
 */
public class Main {

    public static void main(String[] args) {
        String p1 = "X";
        String p2 = "O";
        String next;
        boolean win =false;
        int licznik=0;
//  TODO player class
        System.out.println("Which mark (O or X) start? ");
        Scanner in = new Scanner(System.in);
        String start = in.nextLine();
//  TODO Validation class - checking if appropriate value was giving by users
        if (start.equals("X")){
            System.out.println(p1 + " begin");
             next = p2;
             start = p1;
    }
        else {System.out.println(p2 + " begin");
         next = p1;
        start = p2;
        }

//  TODO BoardCreator Class enable to chose how big the board should be, and appropriate prompting

        String[] simpleBoard = new String[9];
        for (int i = 0; i < simpleBoard.length; i++) {
            simpleBoard[i] = Integer.toString(i+1);
        }
        System.out.println(Arrays.toString(simpleBoard));


//  TODO BoardUpdater - updating board with actualr player mark on appropriate position
//  TODO BusyField - checking if the field which player chose hadn't choosen before ?
    while (!win){
        System.out.println(start + " give a number where you want to put your mark ?");
        simpleBoard[in.nextInt()-1] = start;
        System.out.println(Arrays.toString(simpleBoard));
        System.out.println(next +" give a number where you want to put your mark ?" );
        simpleBoard[in.nextInt()-1] = next;
        System.out.println(Arrays.toString(simpleBoard));

        licznik++;
        if (licznik==2)win=true;
    }
//    TODO Winner - checking if someone already win
    }
}

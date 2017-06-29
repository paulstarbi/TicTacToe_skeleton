package ps;

import java.util.Scanner;

/**
 * Created by paul on 29.06.17.
 */
class Player {

    String name;
    String sign;
    int pPoints;

    public Player() {
    }

    public Player(String name, String sign) {
        this.name = name;
        this.sign = sign;
    }



    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return "Player " + name +
                " get " + pPoints +" points";
    }
}


package ps.Players;

public class Player {

    public String name;
    String sign;
    public int pPoints;

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


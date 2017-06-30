package ps.Players;

import ps.Streamers.Stremer;

import java.io.InputStream;

/**
 * Created by paul on 30.06.17.
 */
public class PlayerCreator extends Stremer {


    public PlayerCreator(InputStream in) {
        super(in);
    }

    public Player createPlayer() {
        return new Player(setName(), setSign());
    }

    public Player createPlayer(String sign) {
        if(sign.equals("X"))
            return new Player(setName(),"O");
        else return new Player(setName(),"X");
    }
}

package codeclan.com.rockpaperscissors;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by user on 21/03/2018.
 */

public class Game implements Serializable {

    private String player1Move;
    private String player2Move;
    private HashMap<String, String> referee;

    public Game(){
//        HashMap<String,String> results = new HashMap<>();
//        results.put("");
        referee = new HashMap<>();
        referee.put("ROCK", "PAPER");
        referee.put("PAPER", "SCISSOR");
        referee.put("SCISSOR", "ROCK");

    }

    public void setPlayer1Move(String move){
        player1Move = move;
    }

    public void setPlayer2Move(String move){
        player2Move = move;
    }

//    public String getResult(){
////        return referee.get(player1Move).get(player2Move).get("result").toString();
//    }

    public String getWinner(){
        if(referee.get(player1Move)  == player2Move ) {
            return "Player 2 wins";
        } else if(referee.get(player2Move) == player1Move) {
            return "Player 1 wins";
        } else {
            return "draw";
        }
//        return referee.get(player1Move).get(player2Move).get("winner").toString();
    }
}

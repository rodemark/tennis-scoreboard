package com.rodemark.models.for_tennis;

public class BaseGame extends Game{

    @Override
    public void updateGameStatus() {
        int player1Points = getPlayersPoints(getPLAYER1());
        int player2Points = getPlayersPoints(getPLAYER2());

        if (player1Points == 4 && player1Points - player2Points >= 2){
            setGameStatus(Status.PLAYER_1_WIN);
        } else if (player2Points == 4 && player2Points - player1Points >= 2){
            setGameStatus(Status.PLAYER_2_WIN);
        } else if (player1Points >= 3 && player2Points >= 3) {
            if (player1Points - player2Points >= 2) {
                setGameStatus(Status.PLAYER_1_WIN);
            } else if (player2Points - player1Points >= 2){
                setGameStatus(Status.PLAYER_2_WIN);
            }
        }
    }

}

package com.rodemark.models.for_tennis;

public class TieBreakGame extends Game{
    @Override
    public void updateGameStatus(){
        int player1Points = getPlayersPoints(getPLAYER1());
        int player2Points = getPlayersPoints(getPLAYER2());

        if (player1Points >= 7 & player1Points - player2Points >= 2){
            setGameStatus(Status.PLAYER_1_WIN);
        }
        if (player2Points >= 7 & player2Points - player1Points >= 2){
            setGameStatus(Status.PLAYER_2_WIN);
        }
    }
}

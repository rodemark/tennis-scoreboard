package com.rodemark.models.for_tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public class Set {
    private int PLAYER1 = 1;
    private int PLAYER2 = 2;

    @Setter
    private Status setStatus;

    private Game currentGame;

    // < Key: Player's index; Value: His number of games won. >
    private HashMap<Integer, Integer> games;

    public Set(){
        games = new HashMap<>();
        games.put(PLAYER1, 0);
        games.put(PLAYER2, 0);

        setStatus = Status.IN_PROGRESS;
        currentGame = new BaseGame();
    }

    public void addPoint(int indexPlayer){
        currentGame.addPoint(indexPlayer);
        updateSetStatus();
    }

    public void updateSetStatus(){
        if (!currentGame.getGameStatus().equals(Status.IN_PROGRESS)){
            if (currentGame.getGameStatus().equals(Status.PLAYER_1_WIN)){
                games.put(PLAYER1, games.get(PLAYER1) + 1);
            }
            else{
                games.put(PLAYER2, games.get(PLAYER2) + 1);
            }

            int player1Games = games.get(PLAYER1);
            int player2Games = games.get(PLAYER2);

            if (playerIsWonSet(player1Games, player2Games) ||
                    playerIsWonSetAfterTieBreak(player1Games, player2Games)){
                if (player1Games > player2Games){
                    setStatus = Status.PLAYER_1_WIN;
                }
                else{
                    setStatus = Status.PLAYER_2_WIN;
                }
            }
            else {
                if (isNextGameTiebreaker(player1Games, player2Games)){
                    currentGame = new TieBreakGame();
                }
                else{
                    currentGame = new BaseGame();
                }

            }
        }
    }

    private Boolean playerIsWonSet(int player1Games, int player2Games){
        if (player1Games >= 6 || player2Games >= 6) {
            return Math.abs(player1Games - player2Games) >= 2;
        }
        return false;
    }

    private Boolean playerIsWonSetAfterTieBreak(int player1Games, int player2Games) {
        if (player1Games == 7 || player2Games == 7) {
            return Math.abs(player1Games - player2Games) == 1;
        }
        return false;
    }

    private boolean isNextGameTiebreaker(int player1Games, int player2Games) {
        return player1Games == 6 && player2Games == 6;
    }

}

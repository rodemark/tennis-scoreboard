package com.rodemark.models.for_tennis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@AllArgsConstructor
public abstract class Game {
    private int PLAYER1 = 1;
    private int PLAYER2 = 2;

    @Setter
    private Status gameStatus;

    // < Key: Player's index; Value: His sum of points. >
    private HashMap<Integer, Integer> points = new HashMap<>();

    public Game(){
        points.put(PLAYER1, 0);
        points.put(PLAYER2, 0);
        gameStatus = Status.IN_PROGRESS;
    }

    public void addPoint(int indexPlayer){
        points.put(indexPlayer, points.get(indexPlayer) + 1);
        updateGameStatus();
    }

    public int getPlayersPoints(int indexPlayer){
        return points.get(indexPlayer);
    }

    public abstract void updateGameStatus();

}

package com.rodemark.models.for_tennis;

import lombok.Getter;

import java.util.HashMap;

@Getter
public class Score {
    private final int SETS_TO_WIN = 2;

    private final int PLAYER1 = 1;
    private final int PLAYER2 = 2;

    private Set currentSet;
    private Status status;

    private final HashMap<Integer, Integer> sets;
    private final HashMap<Integer, Set> setsDetailsHistory;

    private int winSetsPlayer1;
    private int winSetsPlayer2;

    private int winGamesPlayer1;
    private int winGamesPlayer2;

    private int winPointsPlayer1;
    private int winPointsPlayer2;

    public Score() {
        status = Status.IN_PROGRESS;
        currentSet = new Set();

        sets = new HashMap<>();
        sets.put(PLAYER1, 0);
        sets.put(PLAYER2, 0);

        setsDetailsHistory = new HashMap<>();
        setsDetailsHistory.put(1, currentSet);
        updateStatistics();
    }

    public void addPoint(Integer playerIndex) {
        currentSet.addPoint(playerIndex);
        updateStatistics();
        updateStatus();
    }

    public void updateStatus() {
        if (!currentSet.getSetStatus().equals(Status.IN_PROGRESS)) {
            int currentPoint = sets.get(currentSet.getSetStatus().ordinal());
            sets.replace(currentSet.getSetStatus().ordinal(), currentPoint + 1);

            int player1Score = sets.get(PLAYER1);
            int player2Score = sets.get(PLAYER2);

            if (player1Score == SETS_TO_WIN || player2Score == SETS_TO_WIN) {
                status = player1Score > player2Score
                        ? Status.PLAYER_1_WIN
                        : Status.PLAYER_2_WIN;
                updateStatistics();
            } else {
                currentSet = new Set();
                setsDetailsHistory.put(setsDetailsHistory.size() + 1, currentSet);
                updateStatistics();
            }
        }
    }

    private void updateStatistics(){
        this.winSetsPlayer1 = sets.get(1);
        this.winSetsPlayer2 = sets.get(2);

        this.winGamesPlayer1 = currentSet.getGames().get(1);
        this.winGamesPlayer2 = currentSet.getGames().get(2);

        this.winPointsPlayer1 = currentSet.getCurrentGame().getPlayersPoints(1);
        this.winPointsPlayer2 = currentSet.getCurrentGame().getPlayersPoints(2);
    }

    public String getFormattedPoints(int points1, int points2) {
        if (currentSet.getCurrentGame() instanceof BaseGame){
            if (points1 == 0) {
                return "0";
            } else if (points1 == 1) {
                return "15";
            } else if (points1 == 2) {
                return "30";
            } else if (points1 == 3) {
                return "40";
            } else if (points1 - points2 == 1){
                return "Ad";
            } else {
                return "40";
            }
        }
        else {
            return String.valueOf(points1);
        }
    }

}
package com.rodemark.services;

import com.rodemark.models.Match;
import com.rodemark.models.MatchScoreModel;
import com.rodemark.models.Player;
import com.rodemark.repositories.DAO.MatchDAO;
import com.rodemark.repositories.DAO.PlayerDAO;

import java.util.UUID;

public class FinishedMatchesService {
    private final MatchDAO matchDAO;
    private final PlayerDAO playerDAO;
    private final OngoingMatchesService ongoingMatchesService;

    public FinishedMatchesService(OngoingMatchesService ongoingMatchesService) {
        this.ongoingMatchesService = ongoingMatchesService;
        this.matchDAO = new MatchDAO();
        this.playerDAO = new PlayerDAO();
    }

    public void finish(MatchScoreModel match, int winner) throws Exception {
        UUID uuid = match.getUuid();
        Player player1 = new Player(match.getPlayerFirst().getName());
        Player player2 = new Player(match.getPlayerSecond().getName());

        playerDAO.save(player1);
        playerDAO.save(player2);

        Match finichedMatch = new Match();
        finichedMatch.setPlayerFirstID(player1.getID());
        finichedMatch.setPlayerSecondID(player2.getID());

        int PLAYER_FIRST_NUMBER = 1;

        if (winner == PLAYER_FIRST_NUMBER){
            finichedMatch.setWinner(player1.getID());
        }
        else{
            finichedMatch.setWinner(player2.getID());
        }

        matchDAO.save(finichedMatch);
    }

    public String getWinnerName(MatchScoreModel match, int winner){
        if(winner == 1){
            return match.getPlayerFirst().getName();
        }
        else{
            return match.getPlayerSecond().getName();
        }
    }

}

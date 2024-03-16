package com.rodemark.services;

import com.rodemark.models.Match;
import com.rodemark.models.Player;
import com.rodemark.repositories.DAO.MatchDAO;
import com.rodemark.repositories.DAO.PlayerDAO;

import java.util.ArrayList;
import java.util.List;

public class MatchesService {
    private final MatchDAO matchDAO = new MatchDAO();
    private final PlayerDAO playerDAO = new PlayerDAO();

    public List<Match> getMatchesByPlayerName(String playerName){
        List<Player> players = playerDAO.findByName(playerName);
        List<Match> matches = new ArrayList<>();
        for (Player player : players){
            List<Match> playerMatches = matchDAO.findMatchesByPlayer(player);
            matches.addAll(playerMatches);
        }
        return matches;
    }

    public List<Match> getAllMatches(){
        return matchDAO.findAll();
    }

    public String getNameByID(Long ID){
        return playerDAO.findById(ID).getName();
    }
}

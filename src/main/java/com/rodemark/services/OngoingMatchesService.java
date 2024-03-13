package com.rodemark.services;

import com.rodemark.models.MatchScoreModel;

import java.util.HashMap;
import java.util.UUID;

public class OngoingMatchesService {
    HashMap<UUID, MatchScoreModel> currentMatches = new HashMap<UUID, MatchScoreModel>();

    public void startNewMatch(MatchScoreModel newMatch) throws Exception {
        if (!newMatch.getPlayerFirst().getName().equals(newMatch.getPlayerSecond().getName())){
            currentMatches.put(newMatch.getUuid(), newMatch);
        }
        else{
            throw new Exception("Names is equals!");
        }
    }

    public MatchScoreModel getMatchByUUID(UUID uuid) throws Exception {
        if (currentMatches.containsKey(uuid)){
            return currentMatches.get(uuid);
        }
        else{
            throw new Exception(String.format("A match with UUID=%s was not found!", uuid));
        }
    }

    public void removeMatch(UUID uuid) throws Exception {
        if (currentMatches.containsKey(uuid)){
            currentMatches.remove(uuid);
        }
        else{
            throw new Exception(String.format("A match with UUID=%s was not found!", uuid));
        }
    }

}

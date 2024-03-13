package com.rodemark.services;

import com.rodemark.models.for_tennis.Score;
import com.rodemark.models.for_tennis.Status;

import java.util.UUID;

public class MatchScoreService {
    private final OngoingMatchesService ongoingMatchesService;

    public MatchScoreService(OngoingMatchesService ongoingMatchesService) {
        this.ongoingMatchesService = ongoingMatchesService;
    }

    public synchronized Status addScoreToPlayer(Integer playerIndex, UUID matchUUID) throws Exception {
        Score currentScore = getMatchScore(matchUUID);
        currentScore.addPoint(playerIndex);
        return currentScore.getStatus();
    }

    private synchronized Score getMatchScore(UUID matchUUID) throws Exception {
        return ongoingMatchesService.getMatchByUUID(matchUUID).getScore();
    }
}

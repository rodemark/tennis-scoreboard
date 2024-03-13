package com.rodemark.services;

import com.rodemark.models.Match;
import com.rodemark.models.MatchScoreModel;
import com.rodemark.repositories.DAO.MatchDAO;

import java.util.UUID;

public class FinishedMatchesService {

    private final MatchDAO matchDAO;
    private final OngoingMatchesService ongoingMatchesService;

    public FinishedMatchesService(OngoingMatchesService ongoingMatchesService) {
        this.ongoingMatchesService = ongoingMatchesService;
        this.matchDAO = new MatchDAO();
    }

    public synchronized void finish(Match match, UUID uuid) throws Exception {
        matchDAO.save(match);
        ongoingMatchesService.removeMatch(uuid);
    }
}

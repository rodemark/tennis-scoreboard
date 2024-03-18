package com.rodemark.other;

import com.rodemark.services.OngoingMatchesService;
import lombok.Getter;

public class AppInitializer {
    private static volatile OngoingMatchesService ongoingMatchesService;

    private AppInitializer() {}

    public static OngoingMatchesService getOngoingMatchesService() {
        if (ongoingMatchesService == null) {
            synchronized (AppInitializer.class) {
                if (ongoingMatchesService == null) {
                    ongoingMatchesService = new OngoingMatchesService();
                }
            }
        }
        return ongoingMatchesService;
    }

}


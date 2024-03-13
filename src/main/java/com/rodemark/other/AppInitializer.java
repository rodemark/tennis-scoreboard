package com.rodemark.other;

import com.rodemark.services.OngoingMatchesService;
import lombok.Getter;

public class AppInitializer {
    @Getter
    private static OngoingMatchesService ongoingMatchesService;

    public static void init() {
        ongoingMatchesService = new OngoingMatchesService();
    }

}


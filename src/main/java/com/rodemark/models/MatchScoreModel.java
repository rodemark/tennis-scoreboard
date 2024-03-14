package com.rodemark.models;

import com.rodemark.models.Player;
import com.rodemark.models.for_tennis.Score;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class MatchScoreModel {
    private Player playerFirst;
    private Player playerSecond;
    private UUID uuid = UUID.randomUUID();
    private Score score = new Score();
    private String uuidStr = String.valueOf(this.uuid);
}

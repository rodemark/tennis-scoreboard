package com.rodemark.models;

import com.rodemark.models.Player;
import com.rodemark.models.for_tennis.Score;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class MatchScoreModel {
    Player playerFirst;
    Player playerSecond;
    UUID uuid = UUID.randomUUID();
    Score score = new Score();
}

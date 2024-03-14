import com.rodemark.models.for_tennis.Score;
import com.rodemark.models.for_tennis.Status;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    private Score score;

    @BeforeEach
    public void setUp() {
        score = new Score();
    }

    @Test
    public void testAddPoint_Player1() {
        score.addPoint(1);
        assertEquals(0, score.getWinSetsPlayer1());
        assertEquals(0, score.getWinSetsPlayer2());
        assertEquals(0, score.getWinGamesPlayer1());
        assertEquals(0, score.getWinGamesPlayer2());
        assertEquals(1, score.getWinPointsPlayer1());
        assertEquals(0, score.getWinPointsPlayer2());
    }

    @Test
    public void testAddPoint_Player2() {
        score.addPoint(2);
        assertEquals(0, score.getWinSetsPlayer1());
        assertEquals(0, score.getWinSetsPlayer2());
        assertEquals(0, score.getWinGamesPlayer1());
        assertEquals(0, score.getWinGamesPlayer2());
        assertEquals(0, score.getWinPointsPlayer1());
        assertEquals(1, score.getWinPointsPlayer2());
    }

    @Test
    public void testUpdateState_InProgress() {
        score.addPoint(1);
        score.addPoint(2);
        score.addPoint(1);
        assertEquals(Status.IN_PROGRESS, score.getStatus());
    }
}


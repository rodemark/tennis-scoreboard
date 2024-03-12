import com.rodemark.models.for_tennis.Set;
import com.rodemark.models.for_tennis.Status;
import com.rodemark.models.for_tennis.TieBreakGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SetTest {
    private final int AMOUNT_GAMES = 6;
    private final int AMOUNT_POINTS = 4;

    @Test
    public void testSetPlayer1Wins() {
        Set set = new Set();
        assertEquals(Status.IN_PROGRESS, set.getSetStatus());

        for (int i = 0; i < AMOUNT_GAMES; i++) {
            for (int j = 0; j < AMOUNT_POINTS; j++) {
                set.addPoint(1);
            }
        }
        assertEquals(Status.PLAYER_1_WIN, set.getSetStatus());
    }

    @Test
    public void testSetPlayer2Wins() {
        Set set = new Set();
        assertEquals(Status.IN_PROGRESS, set.getSetStatus());

        for (int i = 0; i < AMOUNT_GAMES; i++) {
            for (int j = 0; j < AMOUNT_POINTS; j++) {
                set.addPoint(2);
            }
        }

        assertEquals(Status.PLAYER_2_WIN, set.getSetStatus()); // Второй игрок побеждает
    }

    @Test
    public void testSetTiebreaker() {
        Set set = new Set();
        assertEquals(Status.IN_PROGRESS, set.getSetStatus());

        for (int i = 1; i <= AMOUNT_GAMES * 2; i++) {
            for (int j = 0; j < AMOUNT_POINTS; j++) {
                if (i % 2 == 0) {
                    set.addPoint(1);
                } else {
                    set.addPoint(2);
                }
            }
        }

        assertInstanceOf(TieBreakGame.class, set.getCurrentGame());

        for (int i = 0; i < 7; i++) {
            set.addPoint(1);
        }

        assertEquals(Status.PLAYER_1_WIN, set.getSetStatus());
    }
}

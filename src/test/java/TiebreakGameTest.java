import com.rodemark.models.for_tennis.Game;
import com.rodemark.models.for_tennis.Status;
import com.rodemark.models.for_tennis.TieBreakGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TiebreakGameTest {
    private final int POINTS_TO_WIN_TIE_BREAK = 7;
    @Test
    public void testPlayer1WinsTiebreak(){
        Game game = new TieBreakGame();

        for (int i = 0; i < POINTS_TO_WIN_TIE_BREAK; i++) {
            game.addPoint(1);
        }

        assertEquals(Status.PLAYER_1_WIN, game.getGameStatus());
    }
    @Test
    public void testPlayer2WinsTiebreak(){
        Game game = new TieBreakGame();

        for (int i = 0; i < POINTS_TO_WIN_TIE_BREAK; i++) {
            game.addPoint(2);
        }

        assertEquals(Status.PLAYER_2_WIN, game.getGameStatus());
    }

    @Test
    public void testTiebreakInProgress(){
        Game game = new TieBreakGame();

        for (int i = 0; i < POINTS_TO_WIN_TIE_BREAK; i++) {
            game.addPoint(1);
            game.addPoint(2);
        }

        assertEquals(Status.IN_PROGRESS, game.getGameStatus());
    }

    @Test
    public void testPlayer1WinsAfterTiebreak(){
        Game game = new TieBreakGame();

        for (int i = 0; i < POINTS_TO_WIN_TIE_BREAK; i++) {
            game.addPoint(1);
            game.addPoint(2);
        }

        game.addPoint(1);
        game.addPoint(1);
        assertEquals(Status.PLAYER_1_WIN, game.getGameStatus());
    }
}

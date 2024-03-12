import com.rodemark.models.for_tennis.BaseGame;
import com.rodemark.models.for_tennis.Status;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BaseGameTest {

    private final int AMOUNT_POINTS = 4;
    @Test
    public void testPlayer1WinsWithFourPoints() {
        BaseGame game = new BaseGame();
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());

        for (int i = 0; i < AMOUNT_POINTS - 1; i++) {
            game.addPoint(1);
            assertEquals(Status.IN_PROGRESS, game.getGameStatus());
        }
        game.addPoint(2);
        game.addPoint(1);
        assertEquals(Status.PLAYER_1_WIN, game.getGameStatus());
    }

    @Test
    public void testPlayer2WinsWithFourPoints(){
        BaseGame game = new BaseGame();
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());

        for (int i = 0; i < AMOUNT_POINTS - 1; i++) {
            game.addPoint(2);
            assertEquals(Status.IN_PROGRESS, game.getGameStatus());
        }

        game.addPoint(2);
        game.addPoint(1);
        assertEquals(Status.PLAYER_2_WIN, game.getGameStatus());
    }

    @Test
    public void testGameInProgressAfterBothPlayersScoreFourPoints(){
        BaseGame game = new BaseGame();
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());

        for (int i = 0; i < AMOUNT_POINTS; i++) {
            game.addPoint(1);
            game.addPoint(2);
            assertEquals(Status.IN_PROGRESS, game.getGameStatus());
        }

        game.addPoint(2);
        game.addPoint(1);
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());
    }

    @Test
    public void testPlayer2WinsWithTwoPointAdvantage(){
        BaseGame game = new BaseGame();
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());

        for (int i = 0; i < AMOUNT_POINTS; i++) {
            game.addPoint(1);
            game.addPoint(2);
            assertEquals(Status.IN_PROGRESS, game.getGameStatus());
        }

        game.addPoint(2);
        game.addPoint(2);
        assertEquals(Status.PLAYER_2_WIN, game.getGameStatus());
    }

    @Test
    public void testPlayer1WinsWithTwoPointAdvantage(){
        BaseGame game = new BaseGame();
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());

        for (int i = 0; i < AMOUNT_POINTS; i++) {
            game.addPoint(1);
            game.addPoint(2);
            assertEquals(Status.IN_PROGRESS, game.getGameStatus());
        }

        game.addPoint(1);
        game.addPoint(1);
        assertEquals(Status.PLAYER_1_WIN, game.getGameStatus());
    }

    @Test
    public void testPlayer1WinsWithTwoPointAdvantageManyPoints(){
        BaseGame game = new BaseGame();
        assertEquals(Status.IN_PROGRESS, game.getGameStatus());

        for (int i = 0; i < AMOUNT_POINTS + 2; i++) {
            game.addPoint(1);
            game.addPoint(2);
            assertEquals(Status.IN_PROGRESS, game.getGameStatus());
        }

        game.addPoint(1);
        game.addPoint(1);
        assertEquals(Status.PLAYER_1_WIN, game.getGameStatus());
    }
}

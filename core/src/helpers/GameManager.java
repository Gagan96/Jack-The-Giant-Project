package helpers;

/**
 * Created by gagan on 07/04/2018.
 */

public class GameManager {
    private static final GameManager ourInstance = new GameManager();

    public boolean gameStartedFromMainMenu, isPaused = true;
    public int lifeScore, coinScore, score;

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
    }
}

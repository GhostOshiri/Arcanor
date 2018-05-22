package arcanor;

/**
 * Interface containing useful methods for the game
 */
public interface IGame {

  /**
   * Save the game.
   */
  public void save();

  /**
   * Load the game.
   */
  public void load();

  /**
   * Start the game
   */
  public void start();

  /**
   * Stop and close the game
   */
  public void endOfGame();

  /**
   * Description of the game
   */
  public void description();
}

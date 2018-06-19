package arcanor;

/**
 * Interface containing useful methods for the game
 */
public interface IGame {

  /**
   * Save the game.
   */
  public void save(String fileName);

  /**
   * Load the game.
   */
  public void load(String fileName);

  /**
   * Start the game
   */
  public void start();

  /**
   * Description of the game
   */
  public void description();
}

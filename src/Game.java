package arcanor;

public class Game implements IGame{

  //Definition des attributs

  private int nbTurn;           //Time of the game in turn
  private Mod mod;            // mod of the Mod interface
  private Player player1;       // first player
  private Player player2;       // Second player
  private Player current;       // Current player at this turn
  private Extension aExtension; // DLC added
  private Option aOption;       // Game options
  private Board aBoard;         // Board of the game

  //Implementation of the method herited by the interface

  /**
   * Save the game.
   */
  public void save(){}

  /**
   * load the game.
   */
  public void load(){}

  /**
   * start the game
   */
  public void start() {

  }

  /**
   * End the game
   * @return (boolean) true if the game is end false otherwise
   */
  public boolean endOfGame() {
    boolean end = false;
    if ((player1.checkWin()) || (player2.checkWin())) {
      end = true;
    }
    return end;
  }

  /**
   * Description of the game
   */
  public void description(){}

  //Class' methods

  /**
   * Game Contructor
   * Initializes the game
   * @param  TODO
   */
  public Game(String nameP1,PawnColor color1,int point1,String nameP2,PawnColor color2,int point2) {
    this.aBoard = new Board();

  }

  /**
   * Create a player
   * @param name (String) player's name
   * @param color (PawnColor) player's team color
   * @param point (int) player's amount of point
   */
  private void createPlayer(String name, PawnColor color, int point){}

  /**
   * Menu containing option start quit and other informations
   */
  public void startMenu(){}

  /**
   * Start a new game with a new player1, new player2 and new Board
   */
  public void newGame(){}

  /**
   * Save differents information of the game like a scoreboard
   */
  public void scoreMenu(){}

  /**
   * Allow the user to quit the game
   */
  public void quit(){}
}

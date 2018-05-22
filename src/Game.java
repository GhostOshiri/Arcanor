package arcanor;

public class Game implements IGame{

  //Definition des attributs

  private int nbTour;           //Durée de la partie en tour
  private Mode mode;            // mode de l'interface Mode
  private Player player1;       // premier joueur
  private Player player2;       // deuxiemme joueur
  private Player current;       // joueur devant jouer a ce tour ci
  private Extension aExtension; // Extensions rajoutées
  private Option aOption;       // Options de jeu
  private Board aBoard;         // Board sur lequel se déroule le jeu.

  //Definitions des méthodes héritées de l'interface

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
  public void start(){}

  /**
   * End the game
   */
  public void endOfGame(){}

  /**
   * Description of the game
   */
  public void description(){}

  //Defintions des methodes de classe

  /**
   * Game Contructor
   * Initializes the game
   * @param  TODO
   */
  public Game(TODO){}

  /**
   * Create a player
   * @param name (String) player's name
   * @param team (PionColor) player's team color
   * @param point (int) player's amount of point
   */
  private void createPlayer(String name, PionColor team, int point){}

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

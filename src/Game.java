package arcanor;

public class Game {

  //Definition des attributs

  private int nbTurn;           //Time of the game in turn
  private Mod mod;            // mod of the Mod interface
  private Player player1;       // first player
  private Player player2;       // Second player
  private Player current;       // Current player at this turn
  //private Extension aExtension; // DLC added
  //private Option aOption;       // Game options
  private Board aBoard;         // Board of the game

  //Class' methods

  /**
  * Game Contructor
  * Initializes the game
  * @param  TODO
  */
  public Game(Mod mod,String nameP1,PawnColor color1,String nameP2,PawnColor color2) {
    this.aBoard = new Board();
    this.mod = mod;
    this.createPlayer(nameP1,color1,nameP2,color2,mod);

  }

  /**
  * Create a player
  * @param name (String) player's name
  * @param color (PawnColor) player's team color
  * @param point (int) player's amount of point
  */
  private void createPlayer(String name1, PawnColor color1,String name2, PawnColor color2, Mod mod){
    if (this.mod == Mod.HH) {
      this.player1 = new HumanPlayer(name1, PawnColor.WHITE, this.aBoard);
      this.player2 = new HumanPlayer(name2, PawnColor.BLACK, this.aBoard);
    } else if (this.mod == Mod.HA) {
      this.player1 = new HumanPlayer(name1, PawnColor.WHITE, this.aBoard);
      this.player2 = new IAPlayer("IAPlayer", PawnColor.BLACK, this.aBoard);
    } else if (this.mod == Mod.AA) {
      this.player1 = new IAPlayer("IAPlayer", PawnColor.WHITE, this.aBoard);
      this.player2 = new IAPlayer("IAPlayer", PawnColor.BLACK, this.aBoard);
    } else {
      System.out.println("Game - createPlayer : ");
    }
  }

  /**
   * Allow the user to quit the game
   */
  public void quit(){
    System.out.println("quiter");                                               //provisoire
  }

  //Implementation of the method herited by the interface



  /**
   * start the game
   */
  public void startGame() {
    this.current = player2;
    System.out.println(aBoard.toString());
    while (!this.endOfGame()) {
      this.changeCurrent();
      if (!current.play()) {
        this.changeCurrent();
        System.out.println("Invalid number of column");
      } else {
        System.out.println(this.aBoard.toString());
      }
    }

    System.out.println("►     RESULTS :     ◄\n");
    String winner = "   ☬ Winner : " + this.current.getTeam() + " ☬";
    // add space to adjust the display
    for (int i = winner.length();i < 21;i++) {
      winner = winner + " ";
    }
    System.out.println(winner);
  }

  /**
   * Change the current playing player.
   */
  private void changeCurrent(){
    if (current == player1) {
      this.current = player2;
    } else {
      this.current = player1;
    }
  }

  public Player getPlayer1() {
    return this.player1;
  }

  public Player getPlayer2() {
    return this.player2;
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
}

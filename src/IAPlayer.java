package arcanor;

/**
 * Class IAPlayer subclass of Player
 */
public class IAPlayer extends Player{

  /**
   * Constructor of the IAPlayer class using the constructor herited from the player class
   * @param name (String) name of the player
   * @param color (PawnColor) color of the player
   * @param grid (Board) grid of the game
   */
  public IAPlayer(String name, PawnColor color, Board grid){
    super(name,color,grid);
  }

  /**
   * Method used to play on the board
   */
  public boolean play(){
    return false;
  }

  /**
   * Clone the IAPlayer to securize it.
   * @return (IAPlayer) the cloned version of the IAPlayer
   */
  //public IAPlayer clone(){}
}

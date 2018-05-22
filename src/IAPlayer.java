package arcanor;

/**
 * Class IAPlayer subclass of Player
 */
public class IAPlayer extends Player{

  /**
   * Constructor of the IAPlayer class using the constructor herited from the player class
   * @param (String) name of the player
   * @param (String) team of the player
   * @param (int) point of the player
   */
  public IAPlayer(String player, String team, int point){
    super(name,team,point);
  }

  /**
   * Method used to play on the board
   */
  public void play(){

  }

  /**
   * Clone the IAPlayer to securize it.
   * @return (IAPlayer) the cloned version of the IAPlayer
   */
  public IAPlayer clone(){

  }
}

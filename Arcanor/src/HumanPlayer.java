package arcanor;
import java.util.Scanner;

/**
 * HumanPlayer Class
 */
public class HumanPlayer extends Player{
  private Scanner scan;

  /**
   * HumanPlayer Constructor
   * Initialise the Scanner and use super to initialize the name, team and point
   * @param name (String) HumanPlayer's name
   * @param team (PionColor) HumanPlayer's team color
   * @param point (int) HumanPlayer's amount of point
   */
  public HumanPlayer(String name, PionColor team, int point){}

  /**
   * Method to play the game. Using choiceOfPion too
   */
  public void play(){} 

  /**
   * Allows the player to choose the pawn he want to use-move
   * @return (Pion) if
   */
  private Pion choiceOfPion(){}

  /**
   * Clone the HumanPlayer to securize it
   * @return (HumanPlayer) the cloned Pion
   */
  public HumanPlayer clone(){}
}

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
   * @param color (PawnColor) HumanPlayer's team color
   * @param point (int) HumanPlayer's amount of point
   */
  public HumanPlayer(String name, PawnColor color, int point){}

  /**
   * Method to play the game. Using choiceOfPawn too
   */
  public void play(){}

  /**
   * Allows the player to choose the pawn he want to use-move
   * @return (Pawn) if he selected pawn is free, return this pawn. null otherwise.
   */
  private Pawn choiceOfPawn(){}

  /**
   * Clone the HumanPlayer to securize it
   * @return (HumanPlayer) the cloned Player
   */
  public HumanPlayer clone(){}
}

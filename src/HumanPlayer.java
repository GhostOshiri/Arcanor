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
     * @param grid (Board) Board of the game
     */
    public HumanPlayer(String name, PawnColor color, Board grid){
      super(name,color,grid);
    }

    /**
     * Method to play the game. Using choiceOfPawn too
     */
    public boolean play(){
      boolean check = false;
      int x;
      int y;
      String pawn;
      String move;
      Pawn pion;
      Scanner sc = new Scanner(System.in);

      pion = null;
      while(pion == null) {
        System.out.println("Which pawn do you want to select ? (x y)"); // line column
        pawn = sc.nextLine();
        pion = choiceOfPawn(pawn);
      }
      check = false;
      while(!check){
        System.out.println("In which case do you want to move/eat/split it ? (choice x y)"); // idem
        move = sc.nextLine();
        String[] choice = move.split(" ");
        if (choice[0].equals("move")) {
          check = pion.move(this.grid,Integer.parseInt(choice[1]),Integer.parseInt(choice[2]));
        } else if(choice[0].equals("eat")) {
          check = pion.eat(this.grid,Integer.parseInt(choice[1]),Integer.parseInt(choice[2]));
        } else if (choice[0].equals("split")) {
          check = pion.split(this.grid,Integer.parseInt(choice[1]),Integer.parseInt(choice[2]));
        }
      }
      return check;
    }

    /**
     * Allows the player to choose the pawn he want to use-move
     * @return (Pawn) if the selected pawn is free, return this pawn. null otherwise.
     */
    private Pawn choiceOfPawn(String response){
      int x;
      int y;
      Pawn selected = null;
      String[] choice = response.split(" ");
      try {
        x = Integer.parseInt(choice[0]);
        y = Integer.parseInt(choice[1]);

        for (Pawn pw : getTabPawn()) {
          if (!pw.getIsEaten()) {
            if ((pw.getPosX() == x) && (pw.getPosY() == y)) {
              selected = pw;
            }
          }
        }
      } catch (NumberFormatException e) {
        System.out.println("Ce n'est pas un entier");
      }

      return selected;
  }


  /*
   1 2 3 4 5 6 7 8
1  X-X-0-X-X-0-X-X
2  0-0-0-0-0-0-0-0
3  0-0-0-0-0-0-0-0
4  0-0-0-0-0-0-0-0
5  0-0-0-0-0-0-0-0
6  0-0-0-0-0-0-0-0
7  X-X-0-X-X-0-X-X
  */

    /**
     * Clone the HumanPlayer to securize it
     * @return (HumanPlayer) the cloned Player
     */
    //public HumanPlayer clone(){}
}

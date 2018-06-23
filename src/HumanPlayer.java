package arcanor;
import java.util.Scanner;

/**
 * HumanPlayer Class
 */
public class HumanPlayer extends Player implements java.io.Serializable{

    /**
     * HumanPlayer Constructor
     * Use super to initialize the name, team and point of the human player
     * @param name (String) HumanPlayer's name
     * @param color (PawnColor) HumanPlayer's team color
     * @param grid (Board) Board of the game
     */
    public HumanPlayer(String name, PawnColor color, Board grid){
      super(name,color,grid);
    }

    /**
     * Method to play the game. Using choiceOfPawn()
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
        if (choice.length >= 3) {
          try {
            if (choice[0].equals("move")) {
              check = pion.move(this.grid,Integer.parseInt(choice[1]),Integer.parseInt(choice[2]));
            } else if(choice[0].equals("eat")) {
              check = pion.eat(this.grid,Integer.parseInt(choice[1]),Integer.parseInt(choice[2]));
            } else if (choice[0].equals("split")) {
              check = pion.split(this.grid,Integer.parseInt(choice[1]),Integer.parseInt(choice[2]));
            }
          } catch (NumberFormatException e) {
            System.out.println("Format not valid");
          }
        }
      }
      if (this.getTeam() == PawnColor.WHITE) {
        if (pion.getPosY() == 6) {
          pion.setBlocked(true);
          this.addPoint(pion.getValue());
        }
      } else if (this.getTeam() == PawnColor.BLACK) {
        if (pion.getPosY() == 0) {
          System.out.println("==-");
          pion.setBlocked(true);
          this.addPoint(pion.getValue());
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
        if (choice.length >= 2) {
          x = Integer.parseInt(choice[0]);
          y = Integer.parseInt(choice[1]);

          for (Pawn pw : getTabPawn()) {
            if ((!pw.getIsEaten()) && (!pw.getBlocked())) {
              if ((pw.getPosX() == x) && (pw.getPosY() == y)) {
                selected = pw;
              }
            }
          }
        } else {
          System.out.println("Il manque des données !");
        }
      } catch (NumberFormatException e) {
        System.out.println("Ce n'est pas un entier");
      }

      return selected;
  }
}

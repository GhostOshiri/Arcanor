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
  /*public boolean play(){
    boolean done = false;
    boolean found = false;
    int random = (int)(Math.random()*12);
    Pawn[] table = this.getTabPawn();
    Pawn p;
    int[][] tab;
    int px;
    int py;

    while(found){
      if ((table[random].getIsEaten() == false) && (table[random].getBlocked() == false)) {
        p = table[number];
        found = true;
      } else{
      random = (int)(Math.random()*12);
      }
    }


    tab = p.possiblePos();
    int number = (int)(Math.random()*8);
    px = tab[0][number];
    py = tab[1][number];

    if (p.changePos(this.getBoard(),px,py)) {
      done = true;
    }
    return done;
  }*/
  public boolean play() {
    return false;
  }








/*
  public boolean play(){

    boolean done = false;
    boolean found = false;
    int random = (int)(Math.random()*12);
    Pawn[] table = this.getTabPawn();
    Pawn p;
    int[][] tab;
    int px;
    int py;

    while(found){
      if ((table[random].getIsEaten() == false) && (table[random].getBlocked() == false)) {
        p = table[number];
        found = true;
      } else{
      random = (int)(Math.random()*12);
      }
    }


    tab = p.possiblePos();
    for (int i = 0;i<tab.length;i++) {

    }

    if (p.changePos(this.getBoard(),px,py)) {
      done = true;
    }
    return done;
  }*/

}

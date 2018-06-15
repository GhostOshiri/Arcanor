package arcanor;

/**
 * Public class Player
 */
public abstract class Player{
  protected String name;
  protected PawnColor team;
  protected int point;
  protected Board grid;

  /**
   * Contructor of the Player class. Initializes all the attributes of the class
   * @param name (String) player's name
   * @param team (PawnColor) player's team color
   * @param grid (Board) Board of the game
   */
  public Player(String name, PawnColor team, Board grid){
    if ((name != null) && (team != null) && (grid != null)) {
      this.name = name;
      this.team = team;
      this.grid = grid;
      this.point = 0;
    } else {
      System.out.println("Player - Constructor : error parameter");
    }
  }

  /**
   * Used to have the name of the player
   * @return (String) player's name
   */
  public String getName(){
    return this.name;
  }

  /**
   * Used to set the name of the player
   * @param name (String) new player's name
   */
  public void setName(String name){
    if (name != null) {
      this.name = name;
    } else{
      System.out.println("Player - setName - Parameter Error ");
    }
  }

  /**
   * Used to have the color of the player's team color
   * @return (PawnColor) player's team color
   */
  public PawnColor getTeam(){
    return this.team;
  }

  /**
   * Used to set the color of the player's team
   * @param team (PawnColor)
   */
  public void setTeam(PawnColor team){
    if (team !=null) {
      this.team = team;
    } else{
      System.out.println("Player - setTeam - Parameter Error");
    }
  }

  /**
   * Check the amount of point to declare a winner
   * @return (boolean) true if winner false otherwise
   */
  public boolean checkWin(){
    boolean check = false;
    if (this.point >= 12) {
      check = true;
    }

    return check;
  }

  /**
   * Add amount of point to the player
   * @param amount (int) the amount of point to add at the attribute point of the player
   */
  public void addPoint(int amount){
    if (amount >= 1) {
      this.point = this.point + amount;
    } else {
      System.out.println("Player - addPoint - Parameter error");
    }
  }

  public void setPoint(int point){
    if ((point >= 0) && (point < 12)) {
      this.point = point;
    }
  }

  /**
   * Give the amount of point of the player.
   * @return (int) amount of point
   */
  public int getPoint(){
    return this.point;
  }

  /**
   * Allows the player to play and move his pawn, add point or declare a winner
   */
  public abstract boolean play();
}

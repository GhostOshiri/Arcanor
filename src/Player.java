package arcanor;

/**
 * Public class Player
 */
public abstract class Player{
  protected String name;
  protected PionColor team;
  protected int point;

  /**
   * Contructor of the Player class. Initializes all the attributes of the class
   * @param name (String) player's name
   * @param team (PionColor) player's team color
   * @param point (int) player's amount of point
   */
  public Player(String name, PionColor team, int point){

  }
  /**
   * Used to have the name of the player
   * @return (String) player's name
   */
  public String getNom(){

  }

  /**
   * Used to set the name of the player
   * @param nom (String) new player's name
   */
  public void setNom(String nom){

  }

  /**
   * Used to have the color of the player's team color
   * @return (PionColor) player's team color
   */
  public PionColor getTeam(){

  }

  /**
   * Used to set the color of the player's team
   * @param team (PionColor)
   */
  public void setTeam(String team){

  }

  /**
   * Check the amount of point to declare a winner
   * @return (boolean) true if winner false otherwise
   */
  public boolean checkWin(){

  }

  /**
   * Add amount of point to the player
   * @param amount (int) the amount of point to add at the attribute point of the player
   */
  public void addPoint(int amount){

  }

  /**
   * Give the amount of point of the player.
   * @return (int) amount of point
   */
  public int getPoint(){
    return this.point;
  }

  /**
   * Initializes the pawn of the player on the board
   */
  private void initTabPion(){

  }

  /**
   * Allows the player to play and move his pawn, add point or declare a winner
   */
  public abstract void play();
}

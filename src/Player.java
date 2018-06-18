package arcanor;

/**
 * Public class Player
 */
public abstract class Player{
  protected String name;
  protected PawnColor team;
  protected int point;
  protected Board grid;
  protected Pawn[] tabPawn;


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
      this.initTabPawn();
    } else {
      System.out.println("Player - Constructor : error parameter");
    }
  }

  /**
   * Initializes the pawn of the player on the board
   */
  private void initTabPawn(){
    tabPawn = new Pawn[12];
    if (team == PawnColor.WHITE) {
      System.out.println("WHITE");
      tabPawn[0] = new Pawn(2,0,0,PawnColor.WHITE,null,true);
      tabPawn[1] = new Pawn(1,0,0,PawnColor.WHITE,tabPawn[0],false);
      System.out.println("--");
      tabPawn[2] = new Pawn(4,0,1,PawnColor.WHITE,null,true);
      tabPawn[3] = new Pawn(3,0,1,PawnColor.WHITE,tabPawn[2],false);

      tabPawn[4] = new Pawn(2,0,3,PawnColor.WHITE,null,true);
      tabPawn[5] = new Pawn(1,0,3,PawnColor.WHITE,tabPawn[4],false);
      System.out.println("--");
      tabPawn[6] = new Pawn(4,0,4,PawnColor.WHITE,null,true);
      tabPawn[7] = new Pawn(3,0,4,PawnColor.WHITE,tabPawn[6],false);

      tabPawn[8] = new Pawn(2,0,6,PawnColor.WHITE,null,true);
      tabPawn[9] = new Pawn(1,0,6,PawnColor.WHITE,tabPawn[8],false);
      System.out.println("--");
      tabPawn[10] = new Pawn(4,0,7,PawnColor.WHITE,null,true);
      tabPawn[11] = new Pawn(3,0,7,PawnColor.WHITE,tabPawn[10],false);
    } else if (team == PawnColor.BLACK){
      System.out.println("BLACK");
      tabPawn[0] = new Pawn(2,6,0,PawnColor.BLACK,null,true);
      tabPawn[1] = new Pawn(1,6,0,PawnColor.BLACK,tabPawn[0],false);
      System.out.println("--");
      tabPawn[2] = new Pawn(4,6,1,PawnColor.BLACK,null,true);
      tabPawn[3] = new Pawn(3,6,1,PawnColor.BLACK,tabPawn[2],false);

      tabPawn[4] = new Pawn(2,6,3,PawnColor.BLACK,null,true);
      tabPawn[5] = new Pawn(1,6,3,PawnColor.BLACK,tabPawn[4],false);
      System.out.println("--");
      tabPawn[6] = new Pawn(4,6,4,PawnColor.BLACK,null,true);
      tabPawn[7] = new Pawn(3,6,4,PawnColor.BLACK,tabPawn[6],false);

      tabPawn[8] = new Pawn(2,6,6,PawnColor.BLACK,null,true);
      tabPawn[9] = new Pawn(1,6,6,PawnColor.BLACK,tabPawn[8],false);
      System.out.println("--");
      tabPawn[10] = new Pawn(4,6,7,PawnColor.BLACK,null,true);
      tabPawn[11] = new Pawn(3,6,7,PawnColor.BLACK,tabPawn[10],false);
  }
    for (Pawn pw : tabPawn) {
      if (!pw.getIsEaten()) {
        this.grid.getBoard()[pw.getPosY()][pw.getPosX()] = pw;
      }
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

  public Pawn[] getTabPawn() {
    return this.tabPawn;
  }

  /**
   * Allows the player to play and move his pawn, add point or declare a winner
   */
  public abstract boolean play();
}

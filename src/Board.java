package arcanor;

public class Board {

  private Pawn[][] board;     //  game board
  private final int SIZE_X = 8;   //  board size on the x-axis
  private final int SIZE_Y = 7;   //  board size on the y-axis

  /**
   * Board constructor
   * Call the initBoard method
   */
  public Board() {
    initBoard();
    initTabPawn();
  }

  /**
   * Initialize the board with SIZE_X and SIZE_Y
   */
  private void initBoard() {
    board = new Pawn[SIZE_Y][SIZE_X];
    // Initialize the board with no-color pawn
    for (int i=0;i<SIZE_Y;i++) {
      for (int j=0;j<SIZE_X;j++) {
        this.board[i][j] = new Pawn(-1,i,j,PawnColor.NONE,null,false);
      }
    }
  }

  /**
   * Initializes the pawn of the player on the board
   */
  private void initTabPawn(){

    for (int i=0;i<8;i= i+3) {
      System.out.println("1");
      Pawn pw2 = new Pawn(2,i,0,PawnColor.WHITE,null,true);
      Pawn pw1 = new Pawn(1,i,0,PawnColor.WHITE,pw2,false);
      System.out.println("2");
      Pawn pw4 = new Pawn(4,i+1,0,PawnColor.WHITE,null,true);
      Pawn pw3 = new Pawn(3,i+1,0,PawnColor.WHITE,pw4,false);
      System.out.println("3");
      Pawn pb2 = new Pawn(2,i+1,6,PawnColor.BLACK,null,true);
      Pawn pb1 = new Pawn(1,i+1,6,PawnColor.BLACK,pb2,false);
      System.out.println("4");
      Pawn pb4 = new Pawn(4,i+1,6,PawnColor.BLACK,null,true);
      Pawn pb3 = new Pawn(3,i+1,6,PawnColor.BLACK,pb4,false);
    }
  }

  /**
   * Get the board
   * @return (char[][]) The board
   */
  public Pawn[][] getBoard() {
    return this.board;
  }

  /**
   * Set the board
   * @param board (char[][]) New board
   */
  public void setBoard(Pawn[][] board) {
    if (board != null) {
      this.board = board;
    }
  }

  /**
   * Get the value of the attribut SIZE_X
   * @return (int) The attribut SIZE_X
   */
  public int getSIZE_X() {
    return this.SIZE_X;
  }

  /**
   * Get the value of the attribut SIZE_Y
   * @return (int) The attribut SIZE_Y
   */
  public int getSIZE_Y() {
    return this.SIZE_Y;
  }

  /**
   * Check if a case of the board is free, and the color of the pawn on this case
   * @param  x (int) X-axis coordonate of the case to check
   * @param  y (int) Y-axis coordonate of the case to check
   * @param  color (PawnColor) Color of the pawn on the case
   * @param  value (int) Value of the pawn you want to take.
   * @return (boolean) true if the case is free, false otherwise
   */
  public boolean isFree(int x,int y,PawnColor color, int value) {
    boolean free = false;
    if (this.board[x][y].getColor() == PawnColor.NONE) {
      free = true;
    } else if ((this.board[x][y].getColor() != color) && (this.board[x][y].getValue() == value+1)) {
      free = true;
    }
    return true;
  }

  /**
   * ToString is used to display the board
   * @return (String) The board display
   */
  public String toString() {
    String ret = "";
    for (int y = 0;y < this.SIZE_Y;y++){
      ret = ret + "\n ";
      for (int x = 0;x < this.SIZE_X;x++){
          ret = ret + this.board[y][x].toString();
      }
    }
    return ret + "\n";
  }
}

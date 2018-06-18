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
    if ((x >= 0) && (x < SIZE_X) && (y >= 0) && (y < SIZE_Y)) {
      if (this.board[y][x].getColor() == PawnColor.NONE) {
        free = true;
      } else if ((this.board[y][x].getColor() != color) && (this.board[y][x].getValue() == value+1)) {
        free = true;
      }
    }

    return free;
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
    ret = ret + "\n";
    for (int i = 0;i < SIZE_X;i++) {
      ret = ret + "  " + i + "";
    }
    return ret + "\n";
  }
}

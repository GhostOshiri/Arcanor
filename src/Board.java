public class Board {

  private char[][] board;     //  game board
  private final int SIZE_X;   //  board size on the x-axis
  private final int SIZE_Y;   //  board size on the y-axis

  /**
   * Board constructor
   * Call the initialize method
   */
  public Board() {}

  /**
   * Initialize the board with SIZE_X and SIZE_Y
   */
  private void initBoard() {}

  /**
   * Get the board
   * @return (char[][]) The board
   */
  public char[][] getBoard() {}

  /**
   * Set the board
   * @param board (char[][]) New board
   */
  public void setBoard(char[][] board) {}

  /**
   * Get the value of the attribut SIZE_X
   * @return (int) The attribut SIZE_X
   */
  public int getSIZE_X() {}

  /**
   * Get the value of the attribut SIZE_Y
   * @return (int) The attribut SIZE_Y
   */
  public int getSIZE_Y() {}

  /**
   * Check if a case of the board is free, and the color of the pawn on this case
   * @param  x (int) X-axis coordonate of the case to check
   * @param  y (int) Y-axis coordonate of the case to check
   * @param  color (PionColor) Color of the pawn on the case
   * @return (boolean) true if the case is free, false otherwise
   */
  public boolean isFree(int x,int y,PionColor color) {}

  /**
   * ToString is used to display the board
   * @return (String) The board display
   */
  public String toString() {}

  /**
   * Clone the board to securize it
   * @return (Board) the cloned Board
   */
  public Board clone() {}

}

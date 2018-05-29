public class Board {

  private Pawn[][] board;     //  game board
  private final int SIZE_X;   //  board size on the x-axis
  private final int SIZE_Y;   //  board size on the y-axis

  /**
   * Board constructor
   * Call the initialize method
   */
  public Board() {
    this.SIZE_X = 8;
    this.SIZE_Y = 7;
    initBoard();
  }

  /**
   * Initialize the board with SIZE_X and SIZE_Y
   */
  private void initBoard() {
    for (int i=0;i<getSIZE_Y();i++) {
      for (int j=0;j<getSIZE_X();j++) {
        board[i][j] = new Pawn(null,i,j,NONE,null,false);
      }
    }

    i=0;
    j=0;
    for (i;i<2;i++) {
      for (j;j<getSIZE_X();j++) {
        board[i][j] = new Pawn() //TODO LES Pions NOIRS METHODE INIT TAB Pawn DE PLAYER ????
      }
    }

    i=0;
    j=0;
    for (i;i<2;i++) {
      for (j;j<(getSIZE_Y()-2);j++) {
        board[i][j] = new Pawn() //TODO LES PawnS BLANCS
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
      if ((board.getSIZE_X%2 ==0)&&(board.getSIZE_X%2 ==1)) {
        this.board = board;
      }
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
   * @return (boolean) true if the case is free, false otherwise
   */
  public boolean isFree(int x,int y,PawnColor color) {
    boolean free;
    if (board[x][y].getColor() == NULL) {
      free = true;
    } else{
      System.out.println("La case est déja prise par un Pawn !\n");
    }

    if (board[x][y].getValue() < this.getValue()) {
      System.out.println("La case contient un Pawn de valeur inférieure");
      if (board[x][y].getColor() != this.getColor()) {
        System.out.println("Et le Pawn est de l'équipe adverse !");
        free =true;
      } else{
        System.out.println("Le Pawn est de la meme équipe !");
        free = false;
      }
    }

  }

  /**
   * ToString is used to display the board
   * @return (String) The board display
   */
  public String toString() {
    String ret = new String("Le plateau mesure" + this.getSIZE_X() + "x" + this.getSIZE_Y() + "\n");
    return ret;
  }
  /**
   * Clone the board to securize it
   * @return (Board) the cloned Board
   */
  public Board clone() {
    Board clone = this.getBoard();
}

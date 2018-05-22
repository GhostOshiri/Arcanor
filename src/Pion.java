package arcanor;

/**
 * Pion class
 */
public class Pion {

    private int value;          // the value of the pawn [1-4].
    private int posX;           // the position on the X axis of the pawn.
    private int posY;           // the position on the Y axis of the pawn.
    private boolean etat;       // state of the pawn, if he is on the board or not.
    private boolean estMange;   // boolean who's definding if the pawn is eatean by another.
    private Pion aMange;        // if this attribute is set, the Pion has another pawn under him.
    private PionColor color;

    /**
     * Constructor of the Pion method
     * Initializes value and position
     * @param value (int) the value of the pawn
     * @param posX (int) the position on the X axis of the pawn
     * @param posY (int) the position on the Y axis of the pawn
     * @param aMange (Pion)
     * @param estMange (boolean)
     */
    public Pion(int value, int posX, int posY,PionColor color,Pion aMange,boolean estMange) {
      if ((value >= 1) && (value <=4) && (posX >= 0) && (posX <= 7) && (posY >= 0) && (posY <= 6) && (color != null)) {
        this.value = value;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.aMange = aMange;
        this.estMange = estMange;
      } else {
        System.out.println("Pion - Constructor : error parameter");
      }
    }

    /**
     * Get the color of the pawn
     * @return (PionColor) color
     */
    public PionColor getColor(){
      return this.color;
    }

    /**
     * Set the color of the pawn
     * @param color color of the pawn
     */
    public void setColor(PionColor color) {
      if (color != null) {
        this.color = color;
      } else {
        System.out.println("Pion - setColor : error parameter");
      }
    }

    /**
     * Get the value of the pawn
     * @return (int) the value of the pawn
     */
    public int getValue() {
      return this.value;
    }

    /**
     * Set the value of the pawn
     * @param value (int) the new value of the pawn
     */
    public void setValue(int value) {
      if ((value >= 1) && (value <=4)) {
        this.value = value;
      } else {
        System.out.println("Pion - setValue : error parameter");
      }
    }

    /**
     * Get the position on the pawn on the X axis
     * @return (int) the position of the pawn on the X axis
     */
    public int getPosX() {
      return this.posX;
    }

    /**
     * Get the position of the pawn on the Y axis
     * @return (int) the position of the pawn on the Y axis
     */
    public int getPosY() {
      return this.posY;
    }

    /**
     * Check the possibilities to move the pawn on a certain case of the board
     * 0-1-2
     * 3-P-4
     * 5-6-7
     * if the position is not possible then the line concerned will contain -1
     * @return (int [][]) Matrix containing the position couples allowed to receive the pawn on.
     */
    public int[][] posPossible(Board board) {
      if (board != null) {
        int[][] deplacement = new int[8][2];
        int xMove = -1;
        int yMove = -1;
        for (int i = 0;i < 8;i++) {
          if ((xMove == 1) && (yMove == 1)) {
            //fin
          } else if ((xMove == 1) && (yMove != 1)) {
            xMove = -1;
            yMove = yMove++;
          } else if ((xMove <= 1) && (yMove != 0)) {

          } else if ((xMove <= 1) && (yMove == 0)) {
            if (xMove == -1) {

            } else {

            }
          } else {
            
          }

        }

      }
    }

    /**
     * Change the position of the pawn directly in the board
     * @param board (Board) board of the current game where the pawn's position will be changed
     * @param newPosX (int) new position of the pawn on the X axis
     * @param newPosY (int) new position of the pawn on the Y axis
     */
    public void changePos(char[][] board, int newPosX, int newPosY) {}

    /**
     * Get the value of the attribute estMange.
     * True if the pawn is eaten false otherwise
     */
    public boolean getEstMange() {}

    /**
     * Set the value of the attribute estMange.
     * True if the pawn has to be eaten false otherwise
     */
    public void setEstMange(boolean estMange){}

    /**
     * Set the value of the attribute aMange.
     * The attribute is set if the pawn is containing another pawn.
     */
    public void setAMange(Pion aManger) {}

    /**
     * Get the value of the attribute estMange.
     * @return (Pion) The attribute is not null if the pawn is containing another pawn.
     */
    public Pion getAMange() {}

    /**
     * Clone the Pion to securize it
     * @return (Pion) the cloned Pion
     */
    public Pion clone() {}
}

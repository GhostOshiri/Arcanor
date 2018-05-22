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
     */
    public Pion(int value, int posX, int posY,PionColor color) {}

    /**
     * Get the color of the pawn
     * @return (PionColor) color
     */
    public PionColor getColor(){}

    /**
     * Set the color of the pawn
     * @param color color of the pawn
     */
    public void setColor(PionColor color) {}

    /**
     * Get the value of the pawn
     * @return (int) the value of the pawn
     */
    public int getValue() {}

    /**
     * Set the value of the pawn
     * @param value (int) the new value of the pawn
     */
    public void setValue(int value) {}

    /**
     * Get the position on the pawn on the X axis
     * @return (int) the position of the pawn on the X axis
     */
    public int getPosX() {}

    /**
     * Get the position of the pawn on the Y axis
     * @return (int) the position of the pawn on the Y axis
     */
    public int getPosY() {}

    /**
     * Check the possibilities to move the pawn on a certain case of the board
     * @return (int [] []) Matrix containing the position couples allowed to receive the pawn on.
     */
    public int[][] posPossible() {}

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

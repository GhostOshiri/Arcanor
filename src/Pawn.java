package arcanor;

/**
 * Pawn class
 */
public class Pawn implements java.io.Serializable{

    private int value;          // the value of the pawn [1-4].
    private int posX;           // the position on the X axis of the pawn.
    private int posY;           // the position on the Y axis of the pawn.
    private boolean isEaten;    // boolean who's definding if the pawn is eatean by another.
    private Pawn hasEat;        // if this attribute is set, the Pawn has another pawn under him.
    private PawnColor color;    // Color of the pawn(BLACK,WHITE,NONE)
    private boolean blocked;

    /**
     * Constructor of the Pawn class
     * Initializes value and position
     * @param value (int) the value of the pawn
     * @param posX (int) the position on the X axis of the pawn
     * @param posY (int) the position on the Y axis of the pawn
     * @param hasEat (Pawn)
     * @param isEaten (boolean)
     */
    public Pawn(int value, int posY, int posX,PawnColor color,Pawn hasEat,boolean isEaten) {
      if ((posX >= 0) && (posX <= 7) && (posY >= 0) && (posY <= 6) && (color != null)) {
        this.value = value;
        this.posX = posX;
        this.posY = posY;
        this.color = color;
        this.hasEat = hasEat;
        this.isEaten = isEaten;
        this.blocked = false;
      } else {
        System.out.println("Pawn - Constructor : error parameter");
      }
    }

    //Réalisation d'un Pawn null
    public Pawn(int posY,int posX) {
      if ((posX >= 0) && (posX <= 7) && (posY >= 0) && (posY <= 6)) {
        this.value = 0;
        this.posX = posX;
        this.posY = posY;
        this.color = PawnColor.NONE;
        this.hasEat = null;
        this.isEaten = false;
        this.blocked = false;
      } else {
        System.out.println("Pawn - Constructor : error parameter");
      }
    }

    public boolean getBlocked() {
      return this.blocked;
    }

    public void setBlocked(boolean block) {
      this.blocked = block;
    }

    /**
     * Get the color of the pawn
     * @return (PawnColor) color
     */
    public PawnColor getColor(){
      return this.color;
    }

    /**
     * Set the color of the pawn
     * @param color color of the pawn
     */
    public void setColor(PawnColor color) {
      if (color != null) {
        this.color = color;
      } else {
        System.out.println("Pawn - setColor : error parameter");
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
        System.out.println("Pawn - setValue : error parameter");
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
    public int[][] possiblePos(Board board) {
      int[][] deplacement = null;

      if (board != null) {
        deplacement = new int[8][2];
        int i = 0;

        System.out.println(this.posX + " " + this.posY);

        for (int yMove = -1;yMove <= 1;yMove++) {
          for (int xMove = -1;xMove <= 1;xMove++) {
            if (!((xMove == 0) && (yMove == 0))) {
              if(board.isFree((this.posX + xMove),(this.posY + yMove),this.color,this.value)) {
                deplacement[i][0] = this.posX + xMove;
                deplacement[i][1] = this.posY + yMove;
              } else {
                deplacement[i][0] = -1;
                deplacement[i][1] = -1;
              }
              i++;
            }
          }
        }
      }
      return deplacement;
    }

    /**
     * Change the position of the pawn directly in the board
     * @param board (Board) board of the current game where the pawn's position will be changed
     * @param newPosX (int) new position of the pawn on the X axis
     * @param newPosY (int) new position of the pawn on the Y axis
     */
    public boolean changePos(Board board, int newPosX, int newPosY) {
      boolean ret = false;
      int[][] deplacement = this.possiblePos(board);
      for (int i = 0;i < deplacement.length;i++) {
        if((deplacement[i][0] == newPosX) && (deplacement[i][1] == newPosY)) {
          ret = true;
        }
      }

      if (ret == true) {
        if (this.getHasEat() != null) {
          this.getHasEat().changePos(board,newPosX,newPosY);
        }
        if (!this.isEaten) {
          board.getBoard()[posY][posX] = new Pawn(posY,posX);
          board.getBoard()[newPosY][newPosX] = this;
          this.posX = newPosX;
          this.posY = newPosY;
        } else {
          this.posX = newPosX;
          this.posY = newPosY;
        }
      }

      return ret;
    }

    /**
     * Get the value of the attribute isEaten.
     * True if the pawn is eaten false otherwise
     */
    public boolean getIsEaten() {
      return this.isEaten;
    }

    /**
     * Set the value of the attribute isEaten.
     * True if the pawn has to be eaten false otherwise
     */
    public void setIsEaten(boolean isEaten) {
      this.isEaten = isEaten;
    }

    /**
     * Set the value of the attribute hasEat.
     * The attribute is set if the pawn is containing another pawn.
     */
    public void setHasEat(Pawn hasEat) {
      if (hasEat == null) {
        this.hasEat = null;
      } else {
        if (this.hasEat == null) {
          if (this.getValue()+1 == hasEat.getValue()) {
            this.hasEat = hasEat;
            System.out.println("Vous avez mangé le Pawn : " + hasEat.getValue() +"\n");
          } else{
            System.out.println("Vous ne pouvez manger le Pawn car il est plus gros que le votre !");
          }
        } else{
          System.out.println("Vous ne pouvez manger ce Pawn car le votre en contient déja un !");
        }
      }
    }


    /**
     * Get the value of the attribute isEaten.
     * @return (Pawn) The attribute is not null if the pawn is containing another pawn.
     */
    public Pawn getHasEat() {
      return this.hasEat;
    }

    public String toString() {
      String ret = " . ";
      if (this.color == PawnColor.WHITE) {
        if (this.value == 1) {
          ret = " ▅ ";
        } else if (this.value == 2){
           ret = " ▄ ";
        } else if (this.value == 3){
           ret = " ▃ ";
        } else if (this.value == 4){
           ret = " ▂ ";
        }
      } else if (this.color == PawnColor.BLACK){
        if (this.value == 1) {
          ret = " \033[34m▅\033[37m ";
        } else if (this.value == 2){
           ret = " \033[34m▄\033[37m ";
        } else if (this.value == 3){
           ret = " \033[34m▃\033[37m ";
        } else if (this.value == 4){
           ret = " \033[34m▂\033[37m ";
        }
      }
      return ret;
    }

    public boolean split(Board board, int newPosX, int newPosY){
      boolean worked = false;

      if (this.getHasEat() != null) {
        int elderX = this.getPosX();
        int elderY = this.getPosY();
        Pawn stay = this.getHasEat();

        this.setHasEat(null);
        worked = this.changePos(board,newPosX,newPosY);
        stay.setIsEaten(false);
        board.getBoard()[elderY][elderX] = stay;
      } else {
        worked = this.changePos(board,newPosX,newPosY);
      }

      return worked;
    }

    public boolean move(Board board, int newPosX, int newPosY) {
      return (this.changePos(board,newPosX,newPosY));
    }

    public boolean eat(Board board, int newPosX, int newPosY){
      boolean worked = false;
      Pawn target = board.getBoard()[newPosY][newPosX];
      if ((this.getHasEat() != null) && (this.allowedToEat(board,newPosX,newPosY) == true)) {
        target.setIsEaten(true);
        worked = this.split(board,newPosX,newPosY);
        this.setHasEat(target);
      } else {
        worked = this.changePos(board,newPosX,newPosY);
        this.setHasEat(target);
      }

      return worked;
    }

    private boolean allowedToEat(Board board,int posX,int posY){
      boolean ret = false;
      if ((board.getBoard()[posY][posX].getColor() != this.color) && (board.getBoard()[posY][posX].getValue() == this.value + 1)) {
        ret = true;
      }
      return ret;
    }

}

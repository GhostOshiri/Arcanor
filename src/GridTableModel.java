package view;

import javax.swing.table.AbstractTableModel;
import javax.swing.ImageIcon;
import arcanor.*;

public class GridTableModel extends AbstractTableModel {

  private int noOfRows, noOfCols;
  private Pawn[][] grid;
  private static final String PATH = "../image/";
  private String imageFree = "free.jpg";
  private String imageWhite1 = "white1.PNG";
  private String imageWhite2 = "white2.PNG";
  private String imageWhite3 = "white3.PNG";
  private String imageWhite4 = "white4.PNG";
  private String imageBlack1 = "black1.PNG";
  private String imageBlack2 = "black2.PNG";
  private String imageBlack3 = "black3.PNG";
  private String imageBlack4 = "black4.PNG";


 /*
  * Constructor
  * @param grid : the table to display
  */
  public GridTableModel(Pawn[][] grid) {
    this.grid = grid;
    noOfRows = this.grid.length;
    noOfCols = this.grid[0].length;
  }

// Implementing the tree abstract methods:

   public int getRowCount() {
    return(noOfRows);
  }
  public int getColumnCount() {
    return(noOfCols);
  }

  public Object getValueAt(int r,int c) {
    Object result = new Object();
    Pawn pw = this.grid[r][c];
    if (pw.getColor() == PawnColor.NONE) {
      result = new ImageIcon(PATH + imageFree);
    } else if (pw.getColor() == PawnColor.BLACK) {
      if (pw.getValue() == 1) {
        result = new ImageIcon(PATH + imageBlack1 );
      } else if (pw.getValue() == 2) {
        result = new ImageIcon(PATH + imageBlack2 );
      } else if (pw.getValue() == 3) {
        result = new ImageIcon(PATH + imageBlack3 );
      } else if (pw.getValue() == 4) {
        result = new ImageIcon(PATH + imageBlack4 );
      }
    } else {
      if (pw.getValue() == 1) {
        result = new ImageIcon(PATH + imageWhite1 );
      } else if (pw.getValue() == 2) {
        result = new ImageIcon(PATH + imageWhite2 );
      } else if (pw.getValue() == 3) {
        result = new ImageIcon(PATH + imageWhite3 );
      } else if (pw.getValue() == 4) {
        result = new ImageIcon(PATH + imageWhite4 );
      }
    }
    return result;
  }


  /**
   * get the name of the column
   * @param c : the number of the column
   * @return a String for the name of the column
   */
  public String getColumnName(int c){
    return (new Integer(c).toString());
  }

   /**
   * get the class of the object at column c
   * @param c : the number of the column
   * @return the class of the object at column c
   */
   public Class getColumnClass(int c) {
      return this.getValueAt(0, c).getClass();
   }
}

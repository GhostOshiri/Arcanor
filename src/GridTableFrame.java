package view;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.Color;
import arcanor.*;


public class GridTableFrame extends SimpleFrame {
  private final int rowHeight = 60;  //pixel

  public GridTableFrame(Pawn[][] grid) {
    // set the grid size
    this.setSize(rowHeight*grid.length,rowHeight*grid[0].length);
    GridTableModel otmodel = new GridTableModel(grid);
    JTable tab = new JTable(otmodel);
    // to adjust some parameters
    tab.setShowGrid(true);
    // color for the grid lines
    tab.setGridColor(Color.GRAY);
    tab.setRowHeight(rowHeight);

    this.getContentPane().add(tab);

  }

  public void actualized(){
    this.repaint();
  }
}

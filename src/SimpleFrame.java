package view;

import javax.swing.JFrame;

public class SimpleFrame extends JFrame {
  public SimpleFrame()
  {
     this.setSize(400,400);/*@\label{setsize:line}@*/
     this.setLocation(200,200);/*@\label{setloc:line}@*/
     // quitte l'application quand on ferme la fenetre
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*@\label{closeOp:line}@*/
  }

  // Makes the frame visible.
  public void showIt(){
    this.setVisible(true);
  }

  // Makes the frame visible and sets the title text.
  public void showIt(String title){
    this.setTitle(title);
    this.setVisible(true);
  }

  // Makes the frame visible and sets the title text
  // and the position of the window.

  public void showIt(String title,int x, int y){
    this.setTitle(title);
    this.setLocation(x,y);
    this.setVisible(true);
  }

  // Makes the frame invisible.
  public void hideIt(){
    this.setVisible(false);
  }
}

package arcanor;
import java.util.*;
import java.io.*;

public class Score{

  private String name;
  private Mod gameMod;
  private int score;
  private boolean firstTime;
  private ArrayList<Score> scoreBoard;
  private Game game;

  public Score(Game game){
    System.out.println("1");
    this.scoreBoard = this.loadScoreBoard();
    System.out.println("2");

    String p1Name = this.game.getPlayer1().getName();
    System.out.println("2321");
    String p2Name = this.game.getPlayer2().getName();
    System.out.println("3");

    if (!this.scoreBoard.isEmpty()) {
      System.out.println("4");

      if (this.checkFirstTime(p1Name)) {
        if (this.game.getPlayer1().checkWin()) {
          Score p1 = new Score(1000,p1Name,this.game.getMod());
          this.scoreBoard.add(p1);
        }
      } else {
        for (Score sc: this.scoreBoard) {
          if (sc.getName().equals(p1Name)) {
            if (this.game.getPlayer1().checkWin()) {
              sc.addScore();
            } else {
              sc.minusScore();
            }
          }
        }
      }

      if (this.checkFirstTime(p2Name)) {
        if (this.game.getPlayer2().checkWin()) {
          Score p2 = new Score(1000,p2Name,this.game.getMod());
          this.scoreBoard.add(p2);
        }
      } else {
        for (Score sc: this.scoreBoard) {
          if (sc.getName().equals(p2Name)) {
            if (this.game.getPlayer2().checkWin()) {
              sc.addScore();
            } else {
              sc.minusScore();
            }
          }
        }
      }
    } else {
      System.out.println("empty");

      if (this.game.getPlayer1().checkWin() == true) {
        Score p1 = new Score(1000,p1Name,this.game.getMod());
        this.scoreBoard.add(p1);
      } else {
        Score p2 = new Score(1000,p2Name,this.game.getMod());
        this.scoreBoard.add(p2);
      }
    }
    this.sort();
    this.saveScoreBoard();

  }

  public Score(int score,String name,Mod mod) {
    if ((name != null) && (mod != null)) {
      this.name = name;
      this.score = score;
      this.gameMod = mod;
    } else {
      System.out.println("Score - constructor : error parameter");
    }
  }

  public String getName(){return this.name;}
  public int getScore(){return this.score;}
  public Mod getGameMod(){return this.gameMod;}
  public void setName(String name){this.name = name;}
  public void setScore(int score){this.score = score;}
  public void setGameMod(Mod mod){this.gameMod = mod;}

  public boolean checkFirstTime(String name){
    boolean contains = false;
    for (Score e :scoreBoard ) {
      if (e.getName() == name) {
        contains = true;
      }
    }
    return contains;
  }

  private void addScore(){
    if (this.getScore() < 1000) {
      this.score = this.score + 50;
    } else if ((this.getScore() >= 1000) && (this.getScore() <1250)) {
      this.score = this.score + 25;
    }else if ((this.getScore() >= 1250) && (this.getScore() <1500)) {
      this.score = this.score + 15;
    } else {
      this.score = this.score + 5;
    }
  }

  private void minusScore(){
    if (this.getScore() < 1000) {
      this.score = this.score - 5;
    } else if ((this.getScore() >= 1000) && (this.getScore() <1250)) {
      this.score = this.score - 15;
    }else if ((this.getScore() >= 1250) && (this.getScore() <1500)) {
      this.score = this.score - 25;
    } else {
      this.score = this.score - 50;
    }
  }

  private void sort(){
    Collections.sort(this.scoreBoard, new ComparatorScore());
  }

  private Mod convert(String mod){
    Mod ret = null;
    if (mod != null) {
      if (mod.equals("HH")) {
        ret = Mod.HH;
      } else if (mod.equals("HA")) {
        ret = Mod.HA;
      } else if (mod.equals("AA")) {
        ret = Mod.AA;
      }
    } else{
      System.out.println("mod null - error parameter - ScoreBoard");
    }
    return ret;
  }

  public ArrayList<Score> loadScoreBoard() {
    ArrayList<Score> newScoreBoard = new ArrayList<Score>();
    try{
      FileReader fr = new FileReader("Score.txt");
      BufferedReader in = new BufferedReader(fr);
      String s = in.readLine();
      while (s != null) {
        String[] tabS = s.split(" ");
        Score score = new Score(Integer.parseInt(tabS[0]),tabS[1],convert(tabS[2]));
        newScoreBoard.add(score);
        s = in.readLine();
      }
      in.close();
      fr.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
    return newScoreBoard;
  }

  public void saveScoreBoard() {
    try{
      FileWriter out = new FileWriter("Score.txt");
      for (Score sc : scoreBoard) {
        System.out.println(sc.getScore() + " " + sc.getName() + " " + sc.getGameMod());
      }
      out.close();
    } catch (FileNotFoundException e) {
      System.out.println(e.getMessage());
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }

  public void display(){
    String str = "";
    System.out.println("╔═══════════════════════════════════════════╗\n"
                      +"║                ScoreBoard                 ║\n"
                      +"╠═══╦════════════════════╦═══════════╦══════╣\n"
                      +"║ i ║         Nom        ║   Score   ║ Mode ║\n"
                      +"╠═══╬════════════════════╬═══════════╬══════╣");
    int j =0;
    for (Score sc : scoreBoard) {
      str = "║ "+ j +" ║     " + sc.getName();
      for (int i =str.length();i<=25;i++ ) {
        str = str + " ";
      }
      str = str + "║";
      if (sc.getScore() >= 1000) {
        str = str + "   " + sc.getScore() + "   ";
      }else {
        str = str + "    " + sc.getScore() + "   ";
      }
      str = str + "║  " + sc.getGameMod() + "  ║";
      System.out.println(str);
      j++;
    }
    System.out.println("╚═══╩════════════════════╩═══════════╩══════╝\n");
  }

}

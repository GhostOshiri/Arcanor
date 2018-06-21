  public class Score{

    private String name;
    private String gameMod;
    private int score;
    private boolean firstTime;
    private ArrayList<Score> scoreBoard;
    private Game game;

    public Score(Game game){
      this.scoreBoard = this.loadScoreBoard();
      String p1Name = game.getPlayer1().getName();
      String p2Name = game.getPlayer2().getName();
      if (this.scoreBoard.isEmpty() != false) {
        if (checkFirstTime(p1Name)) {
          if (game.getPlayer1().checkWin() == true) {
            Score p1 = new Score(1000,p1Name,convert(game.mod));
            this.scoreBoard.add(p1);
          }
        } else {
          for (Score sc: scoreBoard) {
            if (sc.getName() == p1Name) {
              if (game.getPlayer1().checkWin() == true) {
                sc.addScore();
              } else {
                sc.minusScore();
              }
            }
          }
        }

        if (checkFirstTime(p2Name)) {
          if (game.getPlayer2().checkWin() == true) {
            Score p2 = new Score(1000,p2Name,convert(game.mod));
            this.scoreBoard.add(p2);
          }
        } else {
          for (Score sc: scoreBoard) {
            if (sc.getName() == p2Name) {
              if (game.getPlayer2().checkWin() == true) {
                sc.addScore();
              } else {
                sc.minusScore();
              }
            }
          }
        }
      }
    }

    public Score(int score,String name,Mod mod) {
      if ((name != null) && (mod != null)) {
        this.name = name;
        this.score = score;
        this.mod = convert(mod);
      } else {
        System.out.println("Score - constructor : error parameter");
      }
    }

    public void getName(){return this.name;}
    public void getScore(){return this.score;}
    public void getGameMod(){return this.gameMod;}
    public void setName(String name){this.name=name;}
    public void setScore(int score){this.score=score;}
    public void setGameMod(Mod mod){this.gameMod=convert(mod);}

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
      Collections.sort(this.scoreBoard);
    }

    private String convert(Mod mod){
      String ret ="";
      if (mod != null) {
        if (mod == Mod.HH) {
          ret = "Human vs Human";
        } else if (mod == Mod.HA) {
          ret = "Human vs IA";
        } else  (mod == Mod.AA) {
          ret = "IA vs IA";
        }
      } else{
        System.out.println("mod null - error parameter - ScoreBoard");
      }
      return ret;
    }

    public ArrayList<Score> loadScoreBoard() {
      ArrayList<Score> newScoreBoard = new ArrayList<Score>();
      try{
        FileReader fr = new FileReader("Score.java");
        BufferReader in = new BufferReader(fr);
        String s = in.readLine();
        while (s != null) {
          String[] tabS = s.split(" ");
          Score score = new Score(tabS[0],tabS[1],tabS[2]);
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
        FileWriter out = new FileWriter("Score.java");
        for (Score sc : scoreBoard) {
          System.out.println(sc.getScore(),sc.getName(),sc.getGameMod());
        }
        in.close();
        fr.close();
      } catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
      } catch (IOException e) {
        System.out.println(e.getMessage());
      }
    }


  }

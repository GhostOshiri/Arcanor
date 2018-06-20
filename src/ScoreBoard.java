  public class ScoreBoard{

    private String name;
    private String level;
    private int score;
    private TreeMap<Integer,Scoreboard> scoreboard;

    public ScoreBoard(String name, String level){
      if ((name != null) && (level != null)) {
        this.name = name;
        this.level = convert(mod);
        this.score = 1000;
      }
    }

    public void toString(){}


    public void addPlayerToScoreBoard(int score, String name, Mod mod){
      if (score>=1000) {
        ScoreBoard p1 = new ScoreBoard(name,mod);
        this.scoreboard.add(score,p1);
      }
    }

    public void sort(){

    }

    public String convert(Mod mod){
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

  }

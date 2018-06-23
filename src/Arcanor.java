package arcanor;
import java.io.*;
import java.util.*;

public class Arcanor implements java.io.Serializable{

  private Game game;
  private ArrayList<Game> tabGame;

  public Arcanor() {
    this.game = null;
    this.tabGame = new ArrayList<Game>();
    this.load();
  }

  public void acceuil() {
    this.startMenu();
    int[] answer = new int[1];
    while (answer[0] != 5) {
      answer[0] = 0;
      while ((answer[0] < 1) || (answer[0] > 5)) {
        answer = this.intIn();
      }
      if (answer[0] == 1) {
        this.newGame();
        System.out.println("sc");
        Score sc = new Score(this.game);
        sc.display();
        System.out.println("finsc");
        this.startMenu();
      } else if (answer[0] == 2) {
        this.loadMenu();
        this.startMenu();
      } else if (answer[0] == 3) {
        this.option();
        this.startMenu();
      } else if (answer[0] == 4) {
        System.out.println("EXTENSION");
      }
    }
    this.quit();
  }

  public void option() {
    System.out.println("OPTION\n 1 : option1\n 2 : option2\n 3 : retour");
    int[] answer = new int[1];
    while (answer[0] != 3) {
      answer[0] = 0;
      while ((answer[0] < 1) || (answer[0] > 3)) {
        answer = this.intIn();
      }
      if (answer[0] == 1) {
        System.out.println("option1");
      } else if (answer[0] == 2) {
        System.out.println("option2");
      }
    }
  }

  /**
   * Menu containing option start quit and other informations
   */
  public void startMenu(){
    System.out.println("╔═══════════════════════════════════════════════════════════════╗\n"
                      +"║ ───────────────────────────────────────────────────────────── ║\n"
                      +"║  \033[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +"║                                                               ║\n"
                      +"║  \033[31m █████\033[0m╗ \033[31m██████\033[0m╗  \033[31m██████\033[0m╗ \033[31m█████\033[0m╗ \033[31m███\033[0m╗   \033[31m██\033[0m╗ \033[31m██████\033[0m╗ \033[31m██████\033[0m╗   ║\n"
                      +"║  \033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m╔════╝\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m████\033[0m╗  \033[31m██\033[0m║\033[31m██\033[0m╔═══\033[31m██\033[0m╗\033[31m██\033[0m╔══\033[31m██\033[0m╗  ║\n"
                      +"║  \033[31m███████\033[0m║\033[31m██████\033[0m╔╝\033[31m██\033[0m║     \033[31m███████\033[0m║\033[31m██\033[0m╔\033[31m██\033[0m╗ \033[31m██\033[0m║\033[31m██\033[0m║   \033[31m██\033[0m║\033[31m██████\033[0m╔╝  ║\n"
                      +"║  \033[31m██\033[0m╔══\033[31m██\033[0m║\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m║     \033[31m██\033[0m╔══\033[31m██\033[0m║\033[31m██\033[0m║╚\033[31m██\033[0m╗\033[31m██\033[0m║\033[31m██\033[0m║   \033[31m██\033[0m║\033[31m██\033[0m╔══\033[31m██\033[0m╗  ║\n"
                      +"║  \033[31m██\033[0m║  \033[31m██\033[0m║\033[31m██\033[0m║  \033[31m██\033[0m║╚\033[31m██████\033[0m╗\033[31m██\033[0m║  \033[31m██\033[0m║\033[31m██\033[0m║ ╚\033[31m████\033[0m║╚\033[31m██████\033[0m╔╝\033[31m██\033[0m║  \033[31m██\033[0m║  ║\n"
                      +"║  \033[0m╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝  ║\n"
                      +"║                                                               ║\n"
                      +"║  \033[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +"║ ───────────────────────────────────────────────────────────── ║\n"
                      +"║                                                               ║\n"
                      +"║                        \033[36m>>>\033[0m NewGame   (\033[33m1\033[0m)                      ║\n"
                      +"║                        \033[36m>>>\033[0m LoadGame  (\033[33m2\033[0m)                      ║\n"
                      +"║                        \033[36m>>>\033[0m Option    (\033[33m3\033[0m)                      ║\n"
                      +"║                        \033[36m>>>\033[0m Extension (\033[33m4\033[0m)                      ║\n"
                      +"║                        \033[36m>>>\033[0m Exit      (\033[33m5\033[0m)                      ║\n"
                      +"╚═══════════════════════════════════════════════════════════════╝\n");
  }

  /**
   * Start a new game with a new player1, new player2 and new Board
   */
  public void newGame(){
    System.out.println("╔═══════════════════════════════════════════════════════════════╗\n"
                      +"║ ───────────────────────────────────────────────────────────── ║\n"
                      +"║  \033[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +"║                                                               ║\n"
                      +"║  \033[31m █████\033[0m╗ \033[31m██████\033[0m╗  \033[31m██████\033[0m╗ \033[31m█████\033[0m╗ \033[31m███\033[0m╗   \033[31m██\033[0m╗ \033[31m██████\033[0m╗ \033[31m██████\033[0m╗   ║\n"
                      +"║  \033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m╔════╝\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m████\033[0m╗  \033[31m██\033[0m║\033[31m██\033[0m╔═══\033[31m██\033[0m╗\033[31m██\033[0m╔══\033[31m██\033[0m╗  ║\n"
                      +"║  \033[31m███████\033[0m║\033[31m██████\033[0m╔╝\033[31m██\033[0m║     \033[31m███████\033[0m║\033[31m██\033[0m╔\033[31m██\033[0m╗ \033[31m██\033[0m║\033[31m██\033[0m║   \033[31m██\033[0m║\033[31m██████\033[0m╔╝  ║\n"
                      +"║  \033[31m██\033[0m╔══\033[31m██\033[0m║\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m║     \033[31m██\033[0m╔══\033[31m██\033[0m║\033[31m██\033[0m║╚\033[31m██\033[0m╗\033[31m██\033[0m║\033[31m██\033[0m║   \033[31m██\033[0m║\033[31m██\033[0m╔══\033[31m██\033[0m╗  ║\n"
                      +"║  \033[31m██\033[0m║  \033[31m██\033[0m║\033[31m██\033[0m║  \033[31m██\033[0m║╚\033[31m██████\033[0m╗\033[31m██\033[0m║  \033[31m██\033[0m║\033[31m██\033[0m║ ╚\033[31m████\033[0m║╚\033[31m██████\033[0m╔╝\033[31m██\033[0m║  \033[31m██\033[0m║  ║\n"
                      +"║  \033[0m╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝  ║\n"
                      +"║                                                               ║\n"
                      +"║  \033[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +"║ ───────────────────────────────────────────────────────────── ║\n"
                      +"║                                                               ║\n"
                      +"║      Player vs Player (\033[33m1\033[0m)      Player vs IA                   ║\n"
                      +"║                                 Easy     (\033[33m2\033[0m)                  ║\n"
                      +"║                                 Medium   (\033[33m3\033[0m)                  ║\n"
                      +"║                                 Hard     (\033[33m4\033[0m)                  ║\n"
                      +"╚═══════════════════════════════════════════════════════════════╝\n");

    Mod mod = null;
    String nameP1 = null;
    String nameP2 = null;
    String nameGame = null;
    PawnColor color1 = PawnColor.WHITE;
    PawnColor color2 = PawnColor.BLACK;

    int[] answer = new int[1];
    answer[0] = 0;
    while ((answer[0] < 1) || (answer[0] > 4)) {
      answer = this.intIn();
    }
    if (answer[0] == 1) {
      mod = Mod.HH;
    } else if ((answer[0] >= 2) && (answer[0] <= 4)) {
      mod = Mod.HA;
    }
    System.out.println(" >>> Choose the name of the payer one (WHITE) :");
    nameP1 = this.stringIn()[0];
    System.out.println(" Name of the Player one : " + nameP1);

    System.out.println(" >>> Choose the name of the payer two (BLACK) :");
    nameP2 = this.stringIn()[0];
    System.out.println(" Name of the Player two : " + nameP2);

    System.out.println(" >>> Choose the name of the game :");
    nameGame = this.stringIn()[0];
    System.out.println(" Name of the game : " + nameGame);

    this.game = new Game(mod, nameP1, color1, nameP2, color2, nameGame);
    tabGame.add(game);
    this.game.save(tabGame);
    this.game.startGame(this.tabGame);
  }

  /**
   * Allow the user to quit the game
   */
  public void quit(){
    System.out.println("GoodBye !");
  }

  private int[] intIn(){
    int[] ans = null;
    try{
      Scanner sc = new Scanner(System.in);
      String str = sc.nextLine();
      String[] strTab = str.split(" ");
      ans = new int[strTab.length];
      for (int i = 0;i< strTab.length;i++) {
        ans[i] = Integer.parseInt(strTab[i]);
      }
    } catch (NumberFormatException e){
      System.out.println("Answer not valid");
    }
    return ans;
  }

  private String[] stringIn() {
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();
    String[] strTab = str.split(" ");

    return strTab;
  }

  /**
   * Description of the game
   */
  public void description(){
  }

  public void loadMenu() {
    System.out.println("╔═══════════════════════════════════════════════════════════════╗\n"
                      +"║ ───────────────────────────────────────────────────────────── ║\n"
                      +"║  \033[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +"║                                                               ║\n"
                      +"║  \033[31m █████\033[0m╗ \033[31m██████\033[0m╗  \033[31m██████\033[0m╗ \033[31m█████\033[0m╗ \033[31m███\033[0m╗   \033[31m██\033[0m╗ \033[31m██████\033[0m╗ \033[31m██████\033[0m╗   ║\n"
                      +"║  \033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m╔════╝\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m████\033[0m╗  \033[31m██\033[0m║\033[31m██\033[0m╔═══\033[31m██\033[0m╗\033[31m██\033[0m╔══\033[31m██\033[0m╗  ║\n"
                      +"║  \033[31m███████\033[0m║\033[31m██████\033[0m╔╝\033[31m██\033[0m║     \033[31m███████\033[0m║\033[31m██\033[0m╔\033[31m██\033[0m╗ \033[31m██\033[0m║\033[31m██\033[0m║   \033[31m██\033[0m║\033[31m██████\033[0m╔╝  ║\n"
                      +"║  \033[31m██\033[0m╔══\033[31m██\033[0m║\033[31m██\033[0m╔══\033[31m██\033[0m╗\033[31m██\033[0m║     \033[31m██\033[0m╔══\033[31m██\033[0m║\033[31m██\033[0m║╚\033[31m██\033[0m╗\033[31m██\033[0m║\033[31m██\033[0m║   \033[31m██\033[0m║\033[31m██\033[0m╔══\033[31m██\033[0m╗  ║\n"
                      +"║  \033[31m██\033[0m║  \033[31m██\033[0m║\033[31m██\033[0m║  \033[31m██\033[0m║╚\033[31m██████\033[0m╗\033[31m██\033[0m║  \033[31m██\033[0m║\033[31m██\033[0m║ ╚\033[31m████\033[0m║╚\033[31m██████\033[0m╔╝\033[31m██\033[0m║  \033[31m██\033[0m║  ║\n"
                      +"║  \033[0m╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═══╝ ╚═════╝ ╚═╝  ╚═╝  ║\n"
                      +"║                                                               ║\n"
                      +"║  \033[36m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +"║ ───────────────────────────────────────────────────────────── ║\n"
                      +"║                                                               ║");
    int j = 1;
    for (Game g : tabGame) {
      String str = "║                         " + g.getNameGame() + "  (" + j + ")";//64
      for (int i = str.length();i < 64;i++) {
        str = str + " ";
      }
      System.out.println(str + "║");
      j++;
    }
    System.out.println("║                           Return (0)                          ║");
    System.out.println("╚═══════════════════════════════════════════════════════════════╝\n");


    int[] answer = new int[1];
    answer[0] = -1;
    while ((answer[0] < 0) || (answer[0] > j)) {
      answer = this.intIn();
    }
    if (answer[0] != 0) {
      this.game = this.tabGame.get(answer[0]-1);
      this.game.startGame(this.tabGame);
    } else {
      System.out.println(" RETURN");
    }
  }

  /**
   * load the game.
   */
  public void load(){
    try {
      FileInputStream fis = new FileInputStream("save.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      Object o = ois.readObject();
      while (o != null) {
        this.tabGame.add((Game)o);
        o = ois.readObject();
      }
      ois.close();
      fis.close();
    } catch (FileNotFoundException f){
      System.out.println(f.getMessage());
    } catch (IOException i) {
      System.out.println("End of the Load");
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found\n" + c.getMessage());
    }
  }

}

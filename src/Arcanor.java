package arcanor;
import java.io.*;
import java.util.Scanner;

public class Arcanor implements java.io.Serializable{

  private Game game;

  public Arcanor() {
    this.game = null;
  }

  public void acceuil() {
    System.out.println("startMenu");
    int[] answer = new int[1];
    while (answer[0] != 3) {
      answer[0] = 0;
      while ((answer[0] < 1) || (answer[0] > 3)) {
        answer = this.saisie();
      }
      if (answer[0] == 1) {
        System.out.println("Start");
      } else if (answer[0] == 2) {
        this.option();
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
        answer = this.saisie();
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
    System.out.println(" ╔═════════════════════════════════════════════════════╗\n"
                      +" ║ \033[31m───────────────────────────────────────────────────\033[0m ║\n"
                      +" ║  \033[33m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +" ║                                                     ║\n ║    888   8888    8888   888   8   8   888   8888    ║\n"
                      +" ║   8   8  8   8  8      8   8  88  8  8   8  8   8   ║\n"
                      +" ║   88888  8888   8      88888  8 8 8  8   8  8888    ║\n"
                      +" ║   8   8  8 8    8      8   8  8  88  8   8  8 8     ║\n"
                      +" ║   8   8  8  8    8888  8   8  8   8   888   8  8    ║\n"
                      +" ║                                                     ║\n ║  \033[33m~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\033[0m  ║\n"
                      +" ║ \033[31m───────────────────────────────────────────────────\033[0m ║\n"
                      +" ║                                                     ║\n ║  \033[36m>>>\033[0m Play                                           ║\n"
                      +" ║  Player vs Player (\033[33m\033[33m1\033[0m)      Player vs IA             ║\n"
                      +" ║                            Easy      (\033[33m\033[33m2\033[0m)            ║\n"
                      +" ║                            Medium    (\033[33m3\033[0m)            ║\n"
                      +" ║                            Hard      (\033[33m4\033[0m)            ║\n"
                      +" ║                                                     ║\n ║  \033[36m>>>\033[0m Option  (\033[33m\033[33m5\033[0m)                                    ║\n"
                      +" ║  \033[36m>>>\033[0m Exit    (\033[33m\033[33m6\033[0m)                                    ║\n"
                      +" ╚═════════════════════════════════════════════════════╝");
  }

  /**
   * Start a new game with a new player1, new player2 and new Board
   */
  public void newGame(){
  }

  /**
   * Allow the user to quit the game
   */
  public void quit(){
    System.out.println("GoodBye !");
  }

  private int[] saisie(){
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
      System.out.println("Answer not vali");
    }
    return ans;
  }

  /**
   * Description of the game
   */
  public void description(){
  }

  /**
   * Save the game.
   */
  public void save(String fileName){
      try {
         FileOutputStream fileOut = new FileOutputStream("./save/" + fileName + ".ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(this);
         out.close();
         fileOut.close();
         System.out.printf("Serialized data is saved in ./save/game.ser");
      } catch (IOException i) {
         i.printStackTrace();
      }
  }

  /**
   * load the game.
   */
  public void load(String fileName){
    try {
      FileInputStream fis = new FileInputStream("./save/" + fileName + ".ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      this.game = (Game)ois.readObject();
      ois.close();
      fis.close();
    } catch (FileNotFoundException f){
      f.printStackTrace();
    } catch (IOException i) {
      i.printStackTrace();
    } catch (ClassNotFoundException c) {
      System.out.println("Employee class not found");
      c.printStackTrace();
    }
  }

}

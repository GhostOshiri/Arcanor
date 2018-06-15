import arcanor.*;

public class LaunchGame {
  public static void main(String[] args) {
    Game g = new Game(Mod.HH,"pl1",PawnColor.WHITE,"pl2",PawnColor.BLACK);
    g.start();
  }
}

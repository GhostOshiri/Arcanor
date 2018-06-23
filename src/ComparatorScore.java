package arcanor;
import java.util.*;

public class ComparatorScore implements Comparator<Score>{
  public int compare(Score s1, Score s2){
    int ret = 0;
    if (s1.getScore() > s2.getScore()) {
      ret = 1;
    } else if (s1.getScore() < s2.getScore()) {
      ret = -1;
    }
    return ret;
	}
}

import java.util.HashSet;
import java.util.Set;

class Finder {
  public static Node getCycleStart(Node start) {
    Set<Node> nodes = new HashSet<>();
    while (start.next != null){
      if (nodes.contains(start)){
        return start;
      }
      nodes.add(start);
      start = start.next;
    }
    return null;
  }
}

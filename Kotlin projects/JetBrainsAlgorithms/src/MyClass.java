import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class MyClass {

  public boolean bar(String[] arg1, String[] arg2) {
    for (int i = 0; i < arg1.length; i++) {
      boolean check = false;
      for (int j = 0; j < arg2.length; j++) {
        if (arg1[i].equals(arg2[j])) {
          check = true;
          break;
        }
      }
      if (!check) return false;
    }
    return true;
  }

  /* Return true if arg1[] is a subset of arg2[] */
  static boolean barMerge(String[] arg1, String[] arg2) {
    int i = 0;
    int j = 0;
    int n = arg1.length;
    int m = arg2.length;

    Comparator<String> comparator = new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return o1.compareTo(o2);
      }
    };

    Arrays.sort(arg1, comparator);
    Arrays.sort(arg2, comparator);

    while (i < n && j < m) {
      if (arg1[i].compareTo(arg2[j]) > 0) {
        j++;
      } else if (arg1[i].equals(arg2[j])) {
        i++;
      } else if (arg1[i].compareTo(arg2[j]) < 0) {
        return false;
      }
    }

    return i == n;
  }

  /* Return true if arg1[] is a subset of arg2[] */
  static boolean barHash(String[] arg1, String[] arg2) {
    int n = arg1.length;
    int m = arg2.length;
    HashSet<String> hset = new HashSet<>();

    for (int i = 0; i < m; i++) {
        hset.add(arg2[i]);
    }

    for (int i = 0; i < n; i++) {
      if (!hset.contains(arg1[i]))
        return false;
    }
    return true;
  }

}
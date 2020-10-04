import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

  public static void main(String[] args) {
//      String first = "a b a b b c kk k ccc";
//      String second = "b a c ccc m d kk k lm";
//      String[] strings1 = first.split(" ");
//      String[] strings2 = second.split(" ");
//      System.out.println(MyClass.barMerge(strings1, strings2));
//      System.out.println(MyClass.barHash(strings1, strings2));


//      Node node1 = new Node(null);
//      Node node2 = new Node(null);
//      Node node3 = new Node(null);
//      System.out.println(Finder.getCycleStart(node1));


    Dog dog1 = new Dog("Fleb", 25);
    Dog dog2 = new Dog("Gleb", 20);
    Dog dog3 = new Dog("Feeble", 5);
    Dog dog4 = new Dog("Booba", 51);
    Dog dog5 = new Dog("Trinki", 15);
    List<Dog> dogList = new ArrayList<>(Arrays.asList(dog1, dog2, dog3, dog4, dog5));

    System.out.println(index(dogList, dog1));
    System.out.println(index(dogList, dog5));

    Dog dog6 = new Dog("Trinki", 15);
    System.out.println(index(dogList, dog6));

    Dog dog7 = null;
    Dog dog8 = new Dog("Curious", 3);
    Dog dog9 = new Dog("Fabulous", 6);
    Dog dog10 = null;
    dogList.addAll(Arrays.asList(dog7, dog8, dog9));
    System.out.println();
    System.out.println(index(dogList, dog9));
    System.out.println(index(dogList, dog7));
    System.out.println(index(dogList, dog10));

    Gleb gleb1 = new Gleb("Gleb", 19, "Karina");
    dogList.add(gleb1);
    System.out.println(index(dogList, gleb1));

    Gleb gleb2 = new Gleb("broke", 19, "none");
    Gleb gleb3 = null;
    System.out.println(index(dogList, gleb3));

    Roma roma1 = new Roma("Roma", 19);
    System.out.println(index(dogList, roma1));
    System.out.println(dogList.contains(gleb3));
  }

  static boolean index(List c, Object a) {
    if (a == null) {
      for (int i = 0; i < c.size(); i++) {
        if (c.get(i) == null) return true;
      }
    } else {
      Object current;
      for (int i = 0; i < c.size(); i++) {
         current = c.get(i);
        if (current != null) {
          if (current.equals(a)) return true;
        }
      }
    }
    return false;
  }
}
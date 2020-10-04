import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //put your code here
    Scanner scanner = new Scanner(System.in);
    int a1 = scanner.nextInt();
    int a2 = scanner.nextInt();
    int b1 = scanner.nextInt();
    int b2 = scanner.nextInt();
    double len1 = Math.sqrt(Math.pow(a1, 2) + Math.pow(a2, 2));
    double len2 = Math.sqrt(Math.pow(b1, 2) + Math.pow(b2, 2));
    double mult = a1 * b1 + a2 * b2;
    System.out.println(Math.toDegrees(Math.acos(mult/(len1 * len2))));
  }
}
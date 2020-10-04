import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    //put your code here
    Scanner scanner = new Scanner(System.in);
    int value = scanner.nextInt();
    int a = value % 10;
    int b = value % 100 / 10;
    System.out.println(a ^ b);
  }
}
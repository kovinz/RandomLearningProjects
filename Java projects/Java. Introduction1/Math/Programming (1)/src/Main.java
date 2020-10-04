import java.util.Scanner;
import java.math.*;

public class Main {

  public static void main(String[] args) {
    //put your code here
    Scanner scanner = new Scanner(System.in);
    double a = scanner.nextDouble();
    double b = scanner.nextDouble();
    double c = scanner.nextDouble();
    double dif = Math.sqrt(Math.pow(b, 2) - 4 * a * c);
    double x1 = (-b - dif) / (2 * a);
    double x2 = (-b + dif) / (2 * a);
    if (x1 < x2){
        System.out.printf("%f %f\n", x1, x2);
    }
    else{
        System.out.printf("%f %f\n", x2, x1);
    }
  }
}
import java.io.FileReader;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(new FileReader("input.txt"));
    String word = scanner.next();
    int N = scanner.nextInt();
    long from = 0;
    long to = 0;
    long currentPosition = 0;
    int positionOfFrom = -1;
    long neededNumberInFrom = 0;

    int positionOfTo = -1;
    long neededNumberInTo = 0;

    int i = 0;
    long repeat = 0;
    Map<String, Integer> inquiries = new HashMap<>();

    if (word.matches("[a-z]+")) {
      for (int j = 0; j < N; j++) {
        from = scanner.nextLong();
        to = scanner.nextLong();
        System.out.println(to - from + 1);
      }
      return;
    }

    long[] numbers = new long[word.length()];
//////////////////////////////////////////////////////////////////////////
    while (i < word.length()) {
      repeat = 0;
      while (Character.isDigit(word.charAt(i))) {
        repeat = repeat * 10 + word.charAt(i) - '0';
        numbers[i] = currentPosition;
        i++;
      }

      if (repeat > 0) {
        currentPosition += repeat;
      } else {
        currentPosition++;
      }

      numbers[i] = currentPosition;
      i++;
    }

///////////////////////////////////////////////////////////////////
    for (int j = 0; j < N; j++) {
      from = scanner.nextLong();
      to = scanner.nextLong();
      int answer = inquiries.getOrDefault(from + " " + to, 0);
      if (answer != 0) {
        System.out.println(answer);
        continue;
      }

      currentPosition = 0;

      positionOfFrom = -1;
      neededNumberInFrom = 0;

      neededNumberInTo = 0;

      i = 0;
      repeat = 0;

      while (numbers[i] < from) i++;
      positionOfFrom = i;
      neededNumberInFrom = numbers[i] - from + 1;

      while (numbers[i] < to) i++;
      positionOfTo = i;
      long overTo = numbers[i] - to;
      neededNumberInTo = numbers[i - 1] - overTo;


      if (positionOfFrom == positionOfTo) {
        answer = countQuantityOfDigits(to - from + 1) + 1;
        System.out.println(answer);
        inquiries.put(from + " " + to, answer);
      } else {
        String ourWord = word.substring(positionOfFrom, positionOfTo + 1);

        int quantityOfDigitsInNeededInFrom = countQuantityOfDigits(neededNumberInFrom);
        int quantityOfDigitsToChangeInLast = countQuantityOfDigits(neededNumberInTo) - countQuantityOfDigits(repeat);
        answer = ourWord.length() + quantityOfDigitsInNeededInFrom + quantityOfDigitsToChangeInLast;
        System.out.println(answer);
        inquiries.put(from + " " + to, answer);
      }
    }
  }

  public static int countQuantityOfDigits(long number) {
    if (number == 1) {
      return 0;
    }

    int quantityOfDigits = 0;
    while (number != 0) {
      quantityOfDigits += 1;
      number /= 10;
    }
    return quantityOfDigits;
  }

}
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {

  // Complete the miniMaxSum function below.
  static void miniMaxSum(int[] arr) {
    long sum = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int val : arr) {
      sum += val;
      if (val > max) max = val;
      if (val < min) min = val;
    }
    System.out.printf("%d %d", sum - max, sum - min);
  }

  // Complete the birthdayCakeCandles function below.
  static int birthdayCakeCandles(int[] ar) {
    int max = Integer.MIN_VALUE;
    int result = 0;
    for (int val : ar) if (val > max) max = val;
    for (int val : ar) if (val == max) result++;
    return result;
  }

  // Complete the circularArrayRotation function below.
  static int[] circularArrayRotation(int[] a, int k, int[] queries) {
    int n = a.length;
    int[] answers = new int[queries.length];
    k = k % n;
    for (int i = 0; i < queries.length; i++) {
      int pos = queries[i];
      int tmpPos = pos - k;
      int actualPos = tmpPos >= 0 ? tmpPos : n + tmpPos;
      answers[i] = a[actualPos];
    }
    return answers;
  }


  // Complete the permutationEquation function below.
  static int[] permutationEquation(int[] p) {
    int n = p.length;
    int[] answers = new int[p.length];
    int[] positions = new int[p.length];
    for (int i = 0; i < n; i++) {
      positions[p[i] - 1] = i + 1;
    }
    for (int i = 0; i < n; i++) {
      answers[i] = positions[positions[i] - 1];
    }
    return answers;
  }

  // Complete the jumpingOnClouds function below.
  static int jumpingOnClouds(int[] c, int k) {
    int n = c.length;
    int e = 100;
    int i = 0;
    do {
      i = (i + k) % n;
      e--;
      if (c[i] == 1) e -= 2;
    } while (i > k - 1);
    return e;
  }

  // Complete the findDigits function below.
  static int findDigits(int n) {
    int ans = 0;
    int nTmp = n;
    while (nTmp > 0) {
      int number = nTmp % 10;
      if (number != 0) {
        if (n % number == 0) ans++;
      }
      nTmp /= 10;
    }
    return ans;
  }

//  static BigInteger ProdTree(long l, long r){
//    if (l > r)
//      return BigInteger.ONE;
//    if (l == r)
//      return BigInteger.valueOf(l);
//    if (r - l == 1)
//      return BigInteger.valueOf(l * r);
//    long m = (l + r) / 2;
//    return ProdTree(l, m) * ProdTree(m + 1, r);
//  }


  // Complete the extraLongFactorials function below.
  static void extraLongFactorials(int n) {
    if (n < 0) {
      System.out.println(0);
      return;
    }
    if (n == 0) {
      System.out.println(1);
      return;
    }
    if (n == 1 || n == 2) {
      System.out.println(n);
      return;
    }
    System.out.println(ProdTree((long) 2, (long) n));
  }

  static BigInteger ProdTree(long l, long r) {
    BigInteger bigInteger = BigInteger.ONE;
    while (l <= r) {
      if (l == r) {
        bigInteger = bigInteger.multiply(BigInteger.valueOf(l));
        break;
      }
      if (r - l == 1) {
        bigInteger = bigInteger.multiply(BigInteger.valueOf(l * r));
        break;
      }
      long m = (l + r) / 2;
      bigInteger = bigInteger.multiply(ProdTree(m + 1, r));
      r = m;
    }
    return bigInteger;
  }

  /*
   * Complete the timeConversion function below.
   */
  static String timeConversion(String s) {
    String timeType = s.substring(8);
    Integer resultHour = Integer.parseInt(s.substring(0, 2));

    if (timeType.equals("PM") && resultHour != 12) {
      resultHour = (resultHour + 12) % 24;
    }

    if (timeType.equals("AM") && resultHour == 12) {
      resultHour = 0;
    }

    String resultHourString = resultHour.toString();
    if (resultHourString.length() == 1) {
      resultHourString = "0".concat(resultHourString);
    }
    return resultHourString.concat(s.substring(2, 8));
  }

  // Complete the bigSorting function below.
  static String[] bigSorting(String[] unsorted) {
    int n = unsorted.length;
    String currentString;
    for (int i = 1; i < n; i++) {
      currentString = unsorted[i];
      int j = i - 1;
      while (j >= 0
              && (unsorted[j].length() > currentString.length()
              || (unsorted[j].length() == currentString.length() && unsorted[j].compareTo(currentString) > 0))) {
        unsorted[j + 1] = unsorted[j];
        j--;
      }
      unsorted[j + 1] = currentString;
    }
    return unsorted;
  }


  // Complete the insertionSort1 function below.
  static void insertionSort1(int n, int[] arr) {
    int element = arr[n - 1];
    int i;
    for (i = n - 1; i > 0; i--) {
      if (arr[i - 1] > element) {
        arr[i] = arr[i - 1];
        printArray(arr);
      }
      if (arr[i - 1] <= element) {
        arr[i] = element;
        printArray(arr);
        break;
      }
    }
    if (i == 0) {
      arr[0] = element;
      printArray(arr);
    }
  }


  static void printArray(int[] arr) {
    for (int j = 0; j < arr.length; j++) {
      System.out.printf("%d ", arr[j]);
    }
    System.out.println();
  }


  // Complete the insertionSort2 function below.
  static void insertionSort2(int n, int[] arr) {
    int curElem;
    for (int i = 1; i < n; i++) {
      curElem = arr[i];
      for (int j = i - 1; j >= 0; j--) {
        if (arr[j] > curElem) {
          arr[j + 1] = arr[j];
        } else {
          arr[j + 1] = curElem;
          break;
        }
      }
      if (arr[0] > curElem) {
        arr[0] = curElem;
      }
      printArray(arr);
    }
  }

  // Complete the insertionSort function below.
  public static void insertionSort(int[] A) {
    for (int i = 1; i < A.length; i++) {
      int value = A[i];
      int j = i - 1;
      while (j >= 0 && A[j] > value) {
        A[j + 1] = A[j];
        j = j - 1;
      }
      A[j + 1] = value;
      printArray(A);
    }
  }

  // Complete the runningTime function below.
  static int runningTime(int[] arr) {
    int shifts = 0;
    for (int i = 1; i < arr.length; i++) {
      int value = arr[i];
      int j = i - 1;
      while (j >= 0 && arr[j] > value) {
        arr[j + 1] = arr[j];
        shifts++;
        j = j - 1;
      }
      arr[j + 1] = value;
    }
    return shifts;
  }


  // Complete the quickSort function below.
  static int[] quickSort(int[] arr) {
    int n = arr.length;
    int[] left = new int[n];
    int i = 0;
    int[] equal = new int[n];
    int j = 0;
    int[] right = new int[n];
    int k = 0;
    int p = arr[0];
    for (int val : arr) {
      if (val < p) {
        left[i] = val;
        i++;
      }
      if (val == p) {
        equal[j] = val;
        j++;
      }
      if (val > p) {
        right[k] = val;
        k++;
      }
    }
    int w = 0;
    for (; w < j; i++, w++) {
      left[i] = equal[w];
    }
    w = 0;
    for (; w < k; i++, w++) {
      left[i] = right[w];
    }
    return left;
  }


  // Complete the countingSort1 function below.
  static int[] countingSort1(int[] arr) {
    int[] numbers = new int[100];
    for (int val : arr) {
      numbers[val]++;
    }
    return numbers;
  }

  // Complete the countingSort2 function below.
  static int[] countingSort2(int[] arr) {
    int n = 100;
    int[] numbers = new int[n];
    for (int val : arr) {
      numbers[val]++;
    }
    int[] sequence = new int[n];
    sequence[0] = 0;
    for (int i = 1; i < n; i++) {
      sequence[i] = sequence[i - 1] + numbers[i - 1];
    }
    int[] res = new int[arr.length];
    for (int val : arr) {
      res[sequence[val]] = val;
      sequence[val]++;
    }
    return res;
  }

  // Complete the countSort3 function below.
  static void countSort3(List<List<String>> arr) {
    int n = 100;
    int[] numbers = new int[n];
    arr.forEach(val -> {
      numbers[Integer.parseInt(val.get(0))]++;
    });

    int[] sequence = new int[n];
    sequence[0] = 0;
    for (int i = 1; i < n; i++) {
      sequence[i] = sequence[i - 1] + numbers[i - 1];
    }

    String[] strings = new String[arr.size()];
    int halfArrSize = arr.size() / 2;

    arr.subList(0, halfArrSize).forEach(val -> {
      int positionOfElement = Integer.parseInt(val.get(0));
      strings[sequence[positionOfElement]] = "-";
      sequence[positionOfElement]++;
    });

    arr.subList(halfArrSize, arr.size()).forEach(val -> {
      int positionOfElement = Integer.parseInt(val.get(0));
      strings[sequence[positionOfElement]] = val.get(1);
      sequence[positionOfElement]++;
    });

    StringBuilder stringBuilder = new StringBuilder();
    for (String string : strings) {
      stringBuilder.append(string);
      stringBuilder.append(" ");
    }
    System.out.println(stringBuilder);
  }


  // Complete the countSort function below.
  static void countSort(List<List<String>> arr) {
    int n = 100;
    StringBuilder[] stringBuilders = new StringBuilder[n];
    for (int i = 0; i < n; i++) {
      stringBuilders[i] = new StringBuilder();
    }
    int halfArrSize = arr.size() / 2;

    for (int i = 0; i < halfArrSize; i++) {
      int x = Integer.parseInt(arr.get(i).get(0));
      stringBuilders[x].append("- ");
    }

    for (int i = halfArrSize; i < arr.size(); i++) {
      int x = Integer.parseInt(arr.get(i).get(0));
      stringBuilders[x].append(arr.get(i).get(1));
      stringBuilders[x].append(" ");
    }

    StringBuilder result = new StringBuilder();
    for (StringBuilder stringBuilder : stringBuilders) {
      result.append(stringBuilder);
    }
    System.out.println(result);
  }

  public <T extends Comparable<T>> void sort(List<T> A, int p, int r) {
    if (p < r) {
      int q = (p + r) / 2;
      sort(A, p, q);
      sort(A, q + 1, r);
      merge(A, p, q, r);
    }
  }

  private  <T extends Comparable<T>> void merge(List<T> A, int p, int q, int r){
    int n1 = q - p + 1;
    int n2 = r - q;
    List<T> left = new ArrayList<>(n1);
    List<T> right = new ArrayList<>(n2);

    for (int i = 0; i < n1; i++){
      left.add(A.get(p + i - 1));
    }

    for (int j = 0; j < n2; j++){
      right.add(A.get(q + j));
    }

    int i = 0;
    int j = 0;
    int k = p - 1;
    while (i < n1 && j < n2){
      if (left.get(i).compareTo(right.get(j)) <= 0){
        A.set(k, left.get(i));
        i++;
      } else {
        A.set(k, right.get(j));
        j++;
      }
      k++;
    }

    while (i < n1){
      A.set(k, left.get(i));
      i++;
      k++;
    }
  }


  public static void main(String[] args) throws Exception {
    List<String> integers = new ArrayList<>(List.of("AAA", "BB", "A", "ACC", "KH", "Z", "ABC"));
    Main main = new Main();
    main.sort(integers, 1, integers.size());
    System.out.println(integers);
  }
}
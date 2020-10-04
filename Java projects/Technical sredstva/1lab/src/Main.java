import java.util.Date;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting project");

        byte v_byte = 120;
        short v_short = 129;
        char v_char = 'a';
        int v_int = 65999;
        long v_long = 429496729;
        float v_float = (float) 0.333334;
        double v_double = 0.333333333;
        boolean v_boolean = true;

        System.out.println("This is a v_byte: " + v_byte);
        System.out.println("This is a v_short: " + v_short);
        System.out.println("This is a v_char: " + v_char);
        System.out.println("This is a v_int: " + v_int);
        System.out.println("This is a v_long: " + v_long);
        System.out.println("This is a v_float: " + v_float);
        System.out.println("This is a v_double: " + v_double);
        System.out.println("This is a v_boolean: " + v_boolean);

        for (char letter = 'a'; letter <= 'z'; letter++) {
            System.out.println(letter);
        }

        long begin = new Date().getTime();
        for (int i = 0; i <= 100000000; i++) {}
        long end = new Date().getTime();
        System.out.printf("With int: %d\n", end-begin);

        begin = new Date().getTime();
        for (long i = 0; i <= 100000000; i++) {}
        end = new Date().getTime();
        System.out.printf("With long: %d\n", end-begin);

        int[] mas = {1, 5, 7, -10, 14, 154651, -13251, 156853};
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mas.length; i++) {
            if (max < mas[i]) {
                max = mas[i];
            }
        }
        System.out.println("Max: " + max);

        int[][] matrix = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) Math.round(Math.random() * 10);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        int[][] matrix_t = new int[3][3];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix_t[i][j] = matrix[j][i];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix_t[i][j] + " ");
            }
            System.out.println();
        }
    }
}

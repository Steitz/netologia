import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int SIZE = 8;
    public static final int MAX = 255;

    public static void printArr(int[][] a) {
        for (int[] ints : a) {
            for (int anInt : ints) {
                System.out.format("%4d", anInt);
            }
            System.out.println();
        }
    }

    public static void turnArr90(int[][] a) {
        int[][] arrT = new int[SIZE][SIZE];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                arrT[i][j] = a[SIZE - j - 1][i];
            }
        }
        printArr(arrT);
    }

    public static void turnArr180(int[][] a) {
        int[][] arrT180 = new int[SIZE][SIZE];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                arrT180[i][j] = a[SIZE - i - 1][SIZE - j - 1];
            }
        }
        printArr(arrT180);
    }


    public static void turnArr270(int[][] a) {
        int[][] arrT270 = new int[SIZE][SIZE];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                arrT270[j][i] = a[i][SIZE - j - 1];
            }
        }
        printArr(arrT270);
    }

    public static void main(String[] args) {
        int[][] arr = new int[SIZE][SIZE];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String input = new String();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = random.nextInt(256);
            }
        }
        //исходная таблица
        printArr(arr);
        while (true) {
            System.out.println("Введите угол поворота 90, 180, 270 или end:");
            input = scanner.next();
            if (input.equals("end")) {
                break;
            } else if (input.equals("90")) {
                turnArr90(arr);
            } else if (input.equals("180")) {
                turnArr180(arr);
            } else if (input.equals("270")) {
                turnArr270(arr);
            } else System.out.println("Некорректный ввод!");
        }
    }
}

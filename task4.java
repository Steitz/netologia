import java.util.Scanner;
public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите год в формате yyyy ");
            int y = scanner.nextInt();
            System.out.print("Введите количество дней ");
            int d = scanner.nextInt();
            int day = (y % 4 == 0) ? 366 : 365;
            if (d != day) {
                System.out.print("Неправильно! В этом году " + day + " дней");
                break;
            }
        } while (true);
    }
}

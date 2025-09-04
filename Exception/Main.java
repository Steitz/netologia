import java.util.Scanner;

public class Main {
    static int min;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PasswordChecker pc = new PasswordChecker();
        try {
            System.out.println("Введите мин. длину пароля: ");
            min = sc.nextInt();
            pc.setMinLength(min);
            System.out.println("Введите макс. допустимое количество повторений символа подряд: ");
            max = sc.nextInt();
            pc.setMaxRepeats(max);


            while (true) {
                System.out.println("Введите пароль или end:");
                String input = sc.next();
                if (input.equals("end")) {
                    System.out.println("Программа завершена");
                    break;
                } else {
                    if (verify(input, min, max)) {
                        System.out.println("Подходит!");
                    } else {
                        System.out.println("Не подходит!");
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean verify(String password, int min, int max) {
        char[] chars = password.toCharArray();
        int cnt = 0;
        if (password.length() < min) {
            return false;
        }
        ;
        for (int i = 0; i < password.length() - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                cnt++;
                if (cnt >= max) {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        return true;
    }
}

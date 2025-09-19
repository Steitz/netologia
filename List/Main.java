import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int numTask = 1;
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> task = new ArrayList<>();

        list.add("Выход из программы");
        list.add("Добавить дело");
        list.add("Показать дела");
        list.add("Удалить дело по номеру");
        list.add("Удалить дело по названию");
        boolean t = true;
        while (t) {
            System.out.println("Выберите операцию:");
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i) + " " + list.get(i));
            }
            String choice = sc.nextLine();
            System.out.println("Ваш выбор: " + choice + "\n");
            switch (choice) {
                case "0":
                    t = false;
                    break;
                case "1":
                    addTask(task);
                    break;
                case "2":
                    printTask(task);
                    break;
                case "3":
                    delToNumber(task);
                    break;
                case "4":
                    delToString(task);
                    break;
                default:
                    System.out.println("Неверный ввод");
                    break;
            }
        }
    }

    public static void printTask(List task) {
        for (int i = 0; i < task.size(); i++) {
            System.out.println((i + 1) + " " + task.get(i));
        }
    }

    public static void addTask(List task) {
        System.out.print("Введите название задачи: ");
        String t = sc.nextLine();
        task.add(t);
        System.out.println("Добавлено!");
        System.out.println("Ваш список дел: ");
        printTask(task);
        System.out.println();
    }

    public static void delToNumber(List task) {
        System.out.print("Введите номер для удаления: ");
        System.out.println("Удалено!");
        int t = sc.nextInt();
        task.remove(--t);
        printTask(task);
        System.out.println();
    }

    public static void delToString(List task) {
        System.out.print("Введите задачу для удаления: ");
        String str = sc.nextLine();
        if (task.contains(str)) {
            int t = task.indexOf(str);
            task.remove(t);
            printTask(task);
            System.out.println();
        } else System.out.println("Нет такой задачи\n");
    }
}


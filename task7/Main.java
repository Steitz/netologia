import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] products = {"Гречневая крупа", "Хлеб", "Яблоки", "Молоко"};
        int[] prices = {100, 50, 200, 300};
        int[] basket = new int[4];
        int sumProducts = 0;
        for (int i = 0; i < products.length; i++) {
            System.out.printf("%d %s %d руб/шт\n", i + 1, products[i], prices[i]);
        }
        while (true) {
            System.out.println(" Выберите товар и количество или введите end");
            String input = scanner.nextLine(); // "11 31"
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" "); // ["11", "31"]
            int ProductNumber = Integer.parseInt(parts[0]) - 1;
            int ProductCount = Integer.parseInt(parts[1]);
            basket[ProductNumber] += ProductCount;
            sumProducts += (prices[ProductNumber] * ProductCount);
        }
        System.out.println("Ваша корзина: " + sumProducts);
        for (int i = 0; i < products.length; i++) {
            if (0 < basket[i]) {
                System.out.printf("%d %s %d %d руб/шт %d в сумме\n", i + 1, products[i], basket[i], prices[i], basket[i] * prices[i]);
            }
        }
    }
}

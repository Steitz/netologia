import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Address, Integer> costPerAddress = new HashMap<>();

        costPerAddress.put(new Address("Россия", "Казань"), 1000);
        costPerAddress.put(new Address("Россия", "Москва"), 200);
        costPerAddress.put(new Address("Россия", "Владивосток"), 15000);
        costPerAddress.put(new Address("Польша", "Варшава"), 11000);
        int totalAmount = 0;
        int amount = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Заполнение нового заказа или end");
            System.out.print("  Введите страну:");
            String country = scanner.nextLine();
            if ("end".equals(country)) {
                break;
            }

            System.out.print("  Введите город:");
            String city = scanner.nextLine();


            System.out.print("  Введите вес (кг):");
            String weight = scanner.nextLine();

            Address addr = new Address(country, city);
            if (costPerAddress.containsKey(addr)) {
                amount = Integer.parseInt(weight) * costPerAddress.get(addr);
                totalAmount += amount;
                System.out.printf("Стоимость доставки составит: %d руб.\n", amount);
                System.out.printf("Общая стоимость всех доставок: %d руб.\n", totalAmount);
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
            System.out.println();

        }

    }
}

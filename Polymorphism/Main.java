import deals.Deal;
import deals.Expenditure;
import deals.Sale;
import taxes.Tax15;
import taxes.Tax6;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Tax6 tax6 = new Tax6();
        Tax15 tax15 = new Tax15();
        Company[] companies = {
                new Company('A', tax6),
                new Company('B', tax15),
                new Company('C', tax6),
                new Company('D', tax15),
                new Company('E', tax15)
        };
        Deal[][] dealsCompany = {
                {new Sale("мебель", 200), new Sale("инструменты", 300), new Expenditure("мебель", 100)},
                {new Sale("фрукты", 30), new Sale("овощи", 50), new Expenditure("фрукты", 1000)},
                {new Sale("мебель", 1000), new Sale("инструменты", 150)},
                {new Sale("путевка", 20000)},
                {new Sale("книги", 150), new Sale("канцелярия", 10), new Expenditure("мебель", 1000)}
        };
        // изменим УСН для компании 'E' с 15% на 6%
        companies[4].setTaxes(tax6);

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        // период, за который рассчитываем налог
        System.out.print("Введите целое число:");
        int amount;
        int days = Math.abs(scanner.nextInt());
        for (int i = 0; i < companies.length; i++) {
            System.out.printf("Компания %s (%s):\n", companies[i].title, companies[i].tax.typeTax());
            for (int j = 0; j < days; j++) {
                amount = random.nextInt(-100, 256);
                companies[i].shiftMoney(amount);
                System.out.format("%5d", amount);
            }
            System.out.println();
            System.out.println("Итого: доход = " + companies[i].debit + " расход = " + companies[i].credit + "\n");

            companies[i].applyDeals(dealsCompany[i]);
            // companies[i].payTaxes(companies[i].tax);
            System.out.println();
        }
    }

}




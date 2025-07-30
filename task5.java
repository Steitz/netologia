import java.util.Scanner;
public class Main {
    public static int taxEarningsMinusSps6(int earnings) {
        int tax = earnings * 6 / 100;
        if (tax >= 0) {
         return tax;
        } else {
         // если расходы оказались больше, то налог посчитается отрицательным
         return 0;
     }
    }
    public static int taxEarningsMinusSps15(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы
        String moneyStr;
        int money;
        while (true) {


            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход ");
            System.out.println("2. Добавить новый расход ");
            System.out.println("3. Выбрать систему налогообложения ");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            else{
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Введите сумму дохода:");
                        moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        money = Integer.parseInt(moneyStr);
                        earnings += money;
                        break;
                    case 2:
                        System.out.println("Введите сумму расхода:");
                        moneyStr = scanner.nextLine(); // Не используйте тут nextInt (!)
                        money = Integer.parseInt(moneyStr);
                        spendings += money;
                        break;
                    case 3:
                        int money15=taxEarningsMinusSps15(earnings, spendings);
                        int money6=taxEarningsMinusSps6(earnings);
                        int usn=money15-money6;
                        if (usn>0) {
                            System.out.println("Мы советуем вам УСН доходы");
                            System.out.println("Ваш налог составит: "+ money6+" рублей");
                            System.out.println("Налог на другой системе: "+ money15+" рублей");
                        }
                        else {
                            System.out.println("УСН доходы минус расходы");
                            System.out.println("Ваш налог составит: "+ money15+" рублей");
                            System.out.println("Налог на другой системе: "+ money6+" рублей");
                        }
                        System.out.println("Экономия: "+ Math.abs(usn)+" рублей");
                        break;
                    default:
                        System.out.println("Такой операции нет");
                }
            }

        }
        System.out.println("Программа завершена!");
    }
}

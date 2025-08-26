import deals.Deal;
import taxes.TaxSystem;

public class Company {
    public char title; // (название)
    public int debit = 0;  // (доходы)
    public int credit = 0; // (расходы)
    public TaxSystem tax;
    public Deal deal = new Deal("хлеб", 0, 100);

    Company(char title, TaxSystem tax) {
        this.title = title;
        this.tax = tax;
    }

    public void shiftMoney(int amount) {
        if (amount != 0) {
            if (amount > 0) this.debit += amount;
            else this.credit += Math.abs(amount);
        }
    }

    public void setTaxes(TaxSystem companyTax) {
        this.tax = companyTax;
    }

    //рассчитает с помощью выбранной этой компанией системы налогооблажения размер налогов;
    //выведет сообщение на экран вида: Компания <название> уплатила налог в размере: <сумма> руб.;
    //обнулит счётчики debit и credit.
    public void payTaxes(TaxSystem companyTax) {
        int sumTax;
        sumTax = companyTax.calcTaxFor(debit, credit);
        System.out.printf("Компания %s уплатила налог в размере: %d руб.\n", this.title, sumTax);
        credit = 0;
        debit = 0;

    }

    //В классе Company создайте метод int applyDeals(Deal[] deals), в результате вызова которого:
    //компания применяет все сделки из массива сделок (т. е. увеличивает credit на creditChange, debit на debitChange);
    //выплачивает все налоги;
    //возвращает из метода разницу доходов и расходов, которая была на момент старта уплаты налогов.
    public int applyDeals(Deal[] deals) {
        boolean flag = false;
        System.out.println("Сделки:");
        for (int i = 0; i < deals.length; i++) {
            this.credit += deals[i].creditChange;
            this.debit += deals[i].debitChange;
            if (deals[i].creditChange == 0) flag = false;
            else flag = true;
            System.out.println(deals[i].comment + (flag ? " расход = " + deals[i].creditChange : " доход  = " + deals[i].debitChange));
        }
        System.out.println("Итого: доход = " + this.debit + " расход = " + this.credit + "\n");
        payTaxes(tax);
        return (this.debit - this.credit);

    }
}

import deals.Deal;
import taxes.TaxSystem;

public class Company {
    protected char title; // (название)
    protected int debit = 0;  // (доходы)
    protected int credit = 0; // (расходы)
    protected TaxSystem USN;

    Company(char title, TaxSystem USN) {
        this.title = title;
        this.USN = USN;
    }

    public void shiftMoney(int amount) {
        if (amount != 0) {
            if (amount > 0) this.debit += amount;
            else this.credit += Math.abs(amount);
        }
    }

    public void setTaxes(TaxSystem companyTax) {
        this.USN = companyTax;
    }

    //рассчитает с помощью выбранной этой компанией системы налогооблажения размер налогов;
    //выведет сообщение на экран вида: Компания <название> уплатила налог в размере: <сумма> руб.;
    //обнулит счётчики debit и credit.
    public void payTaxes(TaxSystem companyTax) {
        System.out.printf("Компания %s уплатила налог в размере: %d руб.\n", this.title, companyTax.calcTaxFor(debit, credit));
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
            this.credit += deals[i].getCreditChange();
            this.debit += deals[i].getDebitChange();
            if (deals[i].getCreditChange() == 0) {
                flag = false;
            } else {
                flag = true;
            }
            System.out.println(deals[i].getComment() + (flag ? " расход = " + deals[i].getCreditChange() : " доход  = " + deals[i].getDebitChange()));
        }
        System.out.println("Итого: доход = " + this.debit + " расход = " + this.credit + "\n");
        payTaxes(USN);
        return (this.debit - this.credit);

    }
}


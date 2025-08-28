public class CreditAccount extends Account {
    protected long credLimit;

    public CreditAccount(long credLimit) {
        this.credLimit = credLimit;
    }

    public boolean add(long amount) {
        if ((this.balance+amount)<=0) {
            this.balance += amount;
            str = "Кредитный счет пополнен на сумму "+amount;
            return true;
        } else {
            str = "ERROR Кредитный счет не может превышать 0";
            return false;
        }
    }

    public boolean pay(long amount) {
        if ((this.balance-amount) >= -credLimit) {
            this.balance -= amount;
            str = "С кредитный счета списана сумма "+amount;
           return true;
        } else {
            str = "ERROR Превышен кредитный лимит"
            ;
            return false;
        }


    }



}

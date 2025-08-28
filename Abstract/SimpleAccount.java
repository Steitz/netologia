public class SimpleAccount extends Account {
    public boolean add(long amount) {
        this.balance += amount;
        str = "Пополнение счета на сумму "+amount;
        return true;
    }

    public boolean pay(long amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            return true;
        } else
            str = "error Недостаточно средств";
            return false;
    }


}

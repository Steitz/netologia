public abstract class Account {
    protected long balance = 0;
    protected String str;

    abstract boolean add(long amount);
    abstract boolean pay(long amount);

    public boolean transfer(Account account, long amount) {
        if (account.pay(amount)) {
            return this.add(amount);
        } else return false;
    }

    public long getBalance() {
        str="Баланс "+balance+" руб.";
        return balance;
    };
    public String log() {
        return str;
    }
}

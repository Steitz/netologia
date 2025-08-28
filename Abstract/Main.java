//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        CreditAccount credAcc = new CreditAccount(1000);
        SimpleAccount debAcc = new SimpleAccount();
        SmartLogger log1 = new SmartLogger();
        SmartLogger log2 = new SmartLogger();
        SimpleLogger log3 = new SimpleLogger();

        credAcc.pay(200);
        log1.log(credAcc.log());
        credAcc.getBalance();
        debAcc.add(700);
        log3.log(debAcc.log());
        credAcc.getBalance();
        log1.log(credAcc.log());
        debAcc.transfer(credAcc, 10000);
        log2.log(credAcc.log());
        credAcc.getBalance();
        debAcc.getBalance();
        log2.log(credAcc.log());
        log1.log(debAcc.log());


    }


}

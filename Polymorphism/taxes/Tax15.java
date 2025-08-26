package taxes;

public class Tax15 extends TaxSystem {
    protected String typeTax = "налог 15% от разницы доходов и расходов";

    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = (debit - credit) * 15 / 100;
        return Math.max(tax, 0);
    }

    @Override
    public String typeTax() {
        return typeTax;
    }
}


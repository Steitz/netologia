package taxes;

public class Tax6 extends TaxSystem {
    public String typeTax = "налог 6% от доходов";

    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = debit * 6 / 100;
        return Math.max(tax, 0);
    }

    @Override
    public String typeTax() {
        return typeTax;
    }
}

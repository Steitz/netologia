package deals;

//Создайте в вашем проекте дополнительный класс Deal, объект которого будет описывать сделку,
// что может провернуть компания. Каждая сделка сопровождается комментарием (comment),
// суммой расходов (creditChange) и суммой доходов (debitChange).
// Создайте конструктор, который принимает эти три параметра.
public class Deal {
    protected String comment;
    protected int creditChange;
    protected int debitChange;

    public Deal(String comment, int creditChange, int debitChange) {
        this.comment = comment;
        this.creditChange = creditChange;
        this.debitChange = debitChange;

    }
    public String getComment() {
        return comment;
    }
    public void setCreditChange(int creditChange) {
        this.creditChange = creditChange;
    }
    public int getCreditChange() {
        return creditChange;
    }
    public int getDebitChange() {
        return debitChange;
    }
    public void setDebitChange(int debitChange) {
        this.debitChange = debitChange;
    }
}


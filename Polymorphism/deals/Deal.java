package deals;

//Создайте в вашем проекте дополнительный класс Deal, объект которого будет описывать сделку,
// что может провернуть компания. Каждая сделка сопровождается комментарием (comment),
// суммой расходов (creditChange) и суммой доходов (debitChange).
// Создайте конструктор, который принимает эти три параметра.
public class Deal {
    public String comment;
    public int creditChange;
    public int debitChange;

    public Deal(String comment, int creditChange, int debitChange) {
        this.comment = comment;
        this.creditChange = creditChange;
        this.debitChange = debitChange;

    }
}

package deals;

// Объект Expenditure должен конструироваться от названия товара и его цены,
// являясь сделкой с комментарием (comment) вида Покупка <название товара> на <цена> руб.,
// creditChange размером в цену и нулевым debitChange
public class Expenditure extends Deal {
    public Expenditure(String comment, int debitChange) {
        super(comment, debitChange, 0);
    }
}

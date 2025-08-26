package deals;

//Объект Sale должен конструироваться от названия товара и его цены,
// являясь сделкой с комментарием (comment) вида Продажа <название товара> на <цена> руб.,
// debitChange размером в цену и нулевым creditChange.
public class Sale extends Deal {
    public Sale(String comment, int debitChange) {
        super(comment, 0, debitChange);
    }
}


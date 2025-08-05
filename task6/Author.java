public class Author {
    //Добавьте класс Author с полями name (имя), surname (фамилия) и rating (рейтинг, целое число), которые задаются конструктором.
    public String name;
    public String surname;
    public int rating;

    public Author(String name, String surname, int rating) {
        this.name = name;
        this.surname = surname;
        this.rating = rating;
    }

    public Author(String name, String surname) {
        this(name, surname, 10);
    }
}

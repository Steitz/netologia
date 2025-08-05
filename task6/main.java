public class Main {
    public static void main(String[] args) {
        Author a = new Author("Александр", "Пушкин", 6);
        Author a2 = new Author("Лев", "Толстой", 1);
        Book b = new Book("Евгений Онегин", 1833, a, 500);
        System.out.println("Книга большая? " + b.isBig());
        System.out.println("Стоимость " + b.estimatePrice());
        System.out.println(b.matches("Пушкин"));
        Book b2 = new Book("Пиковая дама", 1834, a, 2000);
        System.out.println("Книга большая? " + b2.isBig());
        System.out.println("Стоимость " + b2.estimatePrice());
        System.out.println(b2.matches("дама"));
        Book b3 = new Book("Анна Каренина", 1878, a2, 100);
        System.out.println("Книга большая? " + b3.isBig());
        System.out.println("Стоимость: " + b3.estimatePrice());
        System.out.println(b3.matches("анна"));
    }
}

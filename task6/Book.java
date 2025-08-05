public class Book {
    public String title;
    public int releaseYear;
    public Author author;
    public int pages;

    public boolean isBig() {
        return this.pages > 500;
    }

    public boolean matches(String word) {
        String text;
        text = this.title + this.author.name + this.author.surname;
        //System.out.println( text );
        System.out.printf("Поиск по слову <<%s>> :",word );
        return text.contains(word);
    }

    public int estimatePrice() {
        int price;
        //System.out.println(this.author.rating + " " + Math.sqrt(this.author.rating) + " " + this.pages * 3 * Math.sqrt(this.author.rating));
        price = (int) Math.floor(this.pages * 3 * Math.sqrt(this.author.rating));
        return price;
    }

    //конструктор
    public Book(String title, int releaseYear, Author author, int pages) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.author = author;
        this.pages = pages;
        System.out.printf("\nАвтор: %s \nПроизведение:  %s \n", this.author.name + " " + this.author.surname, this.title);
    }
}

package library;

/**
 * Created by macbook on 26.05.17.
 */
public class Book extends Edition{
    String genre;

    public Book(String name, String author, int yearOfIssue, String genre) {
        super(name, author, yearOfIssue);
        this.genre = genre;
    }

    public Book(String name, String author, int yearOfIssue, String anotation, String genre) {
        super(name, author, yearOfIssue, anotation);
        this.genre = genre;
    }
}

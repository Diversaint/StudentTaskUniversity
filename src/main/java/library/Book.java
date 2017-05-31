package library;

/**
 * Created by macbook on 26.05.17.
 */
public class Book extends Edition{
    Genre genre;

    public Book(String name, String author, int yearOfIssue, Genre genre) {
        super(name, author, yearOfIssue);
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book genre='" + genre + '\'' + super.toString();
    }
}

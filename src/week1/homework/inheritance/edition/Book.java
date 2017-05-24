package week1.homework.inheritance.edition;

/**
 * Created by saint on 23.05.17.
 */
public abstract class Book implements Edition{
    private String name;
    private String author;
    private String genre;


    private int numberOfPages;
    private int yearOfIssue;

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public void setYearOfIssue(int yearOfIssue) {
        this.yearOfIssue = yearOfIssue;
    }

    public Book(String name, String author, String genre, int numberOfPages, int yearOfIssue) {
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.numberOfPages = numberOfPages;
        this.yearOfIssue = yearOfIssue;
    }

    @Override
    public void printInfo() {
        System.out.println("It is book");
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", yearOfIssue=" + yearOfIssue +
                '}';
    }

    public abstract void printDescription();

}

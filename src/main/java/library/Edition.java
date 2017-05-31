package library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by macbook on 26.05.17.
 */
public class Edition implements Comparable<Object>{
    private static final int CURRENT_YEAR = 2017;
    private String name;
    private String author;
    private int yearOfIssue;
    private String anotation;
    private Person person;

    /**
     * Constructor without anotation
     * @param name
     * @param author
     * @param yearOfIssue
     */
    public Edition(String name, String author, int yearOfIssue) {
        this.name = name;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
    }

    /**
     * Constructor. person will setup only by setter
     * @param name
     * @param author
     * @param yearOfIssue
     * @param anotation
     */
    public Edition(String name, String author, int yearOfIssue, String anotation) {
        this.name = name;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
        this.anotation = anotation;
    }

    public Edition(Edition edition) {
        this.name = edition.name;
        this.author = edition.author;
        this.yearOfIssue = edition.yearOfIssue;
        this.anotation = edition.anotation;
        this.person = edition.person;
    }
/*

    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        Pattern alph = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = alph.matcher(this.author);
        if (matcher.matches())
            this.author = author;
        else {
            this.name = "";
            System.out.println("For author name use only letters");
        }
    }
    public void setYearOfIssue(int yearOfIssue) {
        if (yearOfIssue > 1800 && yearOfIssue <= CURRENT_YEAR)
        this.yearOfIssue = yearOfIssue;
        else
            System.out.println("Incorrect year of Issue");
    }

    public void setAnotation(String anotation) {
        this.anotation = anotation;
    }


    public String getAnotation() {
        return anotation;
    }
*/
    public void setPerson(Person person) {
        this.person = person;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    /**
     * Return clone of person
     * @return
     */
    public Person getPerson() {
        if (person == null) return null;
        return new Person(person);
    }


    @Override
    public int compareTo(Object o) {
        Edition edition = (Edition)o;
        int compareToResult = this.name.compareTo(edition.name);
        if (compareToResult != 0) return compareToResult;
        compareToResult = this.author.compareTo(edition.author);
        if (compareToResult != 0) return compareToResult;
        compareToResult = this.yearOfIssue - edition.yearOfIssue;
        return compareToResult;

    }

    @Override
    public String toString() {
        return "Edition" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", anotation='" + anotation + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.compareTo(o) == 0) return true;
        return false;

    }

}

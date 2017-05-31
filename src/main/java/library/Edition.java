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

    public Edition(String name, String author, int yearOfIssue) {
        this.name = name;
        this.author = author;
        this.yearOfIssue = yearOfIssue;
    }

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
    /** Add final method for convert info about edition to String. Used in find edition by keywords */
    public final String infoToString(){
        StringBuffer info = new StringBuffer();
        if (name != null) info = info.append(name);
        if (author != null) info = info.append(author);
        if (author != null) info = info.append(anotation);
        if (yearOfIssue != 0) info = info.append(yearOfIssue);
        return info.toString();

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

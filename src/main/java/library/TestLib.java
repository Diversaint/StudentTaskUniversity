package library;

import library.Book;
import library.Edition;
import library.Library;
import library.Reader;
import library.comparator.NameEditionComparator;
import library.comparator.NamePersonComparator;
import library.comparator.YearOfIssueComparator;

/**
 * Created by macbook on 26.05.17.
 */
public class TestLib {
    public static void main(String[] args) {
        Book bookFinancier = new Book("Financier", "Dreiser", 1986, Genre.Romance);
        Book bookTitan = new Book("Titan", "Dreiser", 1965, Genre.Romance);
        Book bookStoic = new Book("Stoic", "Dreiser", 1999, Genre.Romance);
        Edition constitution = new Edition("Constitution of Ukraine", "Goverment", 1991);


        Reader reader1 = new Reader("James", "Bond", 'm', 52);
        Reader reader1Copy = new Reader("James", "Bond", 'm', 52);
        Reader reader2 = new Reader("James1", "Bond", 'm', 52);
        Reader reader3 = new Reader("James", "Bond2", 'm', 52);
        Reader reader4 = new Reader("James", "Bond", 'w', 52);
        Reader reader5 = new Reader("James", "Bond", 'm', 54);
        Reader reader6 = new Reader("James", "Bond", 'm', 52);

        Library library = new Library();

        library.addEditionInList(bookTitan);
        library.addEditionInList(bookFinancier);
        library.addEditionInList(bookStoic);
        library.addEditionInList(constitution);

        library.addReader(reader4);
        library.addReader(reader3);
        library.addReader(reader2);
        library.addReader(reader1);
        library.addReader(reader5);
        library.addReader(reader6);

        library.addEditionToReader(bookStoic, reader1Copy);



    }
}

package library;

/**
 * Created by macbook on 26.05.17.
 */
public class TestLib {
    public static void main(String[] args) {
        Book bookFinancier = new Book("Financier", "Dreiser", 1990, "Roman");
        Book bookTitan = new Book("Titan", "Dreiser", 1990, "Roman");
        Book bookStoic = new Book("Stoic", "Dreiser", 1990, "Roman");

        Reader reader1 = new Reader("James", "Bond", 'm', 52);
        Reader reader2 = new Reader("James1", "Bond", 'm', 52);
        Reader reader3 = new Reader("James", "Bond2", 'm', 52);
        Reader reader4 = new Reader("James", "Bond", 'w', 52);
        Reader reader5 = new Reader("James", "Bond", 'm', 54);
        Reader reader6 = new Reader("James", "Bond", 'm', 52);

        Library library = new Library();

        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);
        library.addReader(reader4);
        library.addReader(reader5);
        library.addReader(reader6);

        reader1.addEdition(bookFinancier);
        reader1.addEdition(bookStoic);
        //System.out.println(reader1.getEditions());
        reader1.returnEditionToLib(bookFinancier);
        int a;

    }
}

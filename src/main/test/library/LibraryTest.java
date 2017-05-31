package library;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by macbook on 29.05.17.
 */
public class LibraryTest {
    private Library library;
    private Book bookFinancier;
    private Book bookTitan;
    private Book bookStoic;
    private Edition constitution;
    private Reader reader1;
    private Reader reader2;
    private Reader reader3;
    private Reader reader4Same1;
    private Reader reader5;
    private Reader reader6;


    @Before
    public void setUp(){
        library = new Library();
        bookFinancier = new Book("Financier", "Dreiser", 1990, "Roman");
        bookTitan = new Book("Titan", "Dreiser", 1990, "Roman");
        bookStoic = new Book("Stoic", "Dreiser", 1990, "Roman");
        constitution = new Edition("Constitution of Ukraine", "Goverment", 1991);

        reader1 = new Reader("James", "Bond", 'm', 52);
        reader2 = new Reader("James1", "Bond", 'm', 52);
        reader3 = new Reader("James", "Bond2", 'm', 52);
        reader4Same1 = new Reader("James", "Bond", 'm', 52);
        reader5 = new Reader("James", "Bond", 'm', 54);
        reader6 = new Reader("James", "Bond", 'm', 52);
    }
    @Test
    public void test_add_reader_null(){
        assertFalse(library.addReader(null));
    }
    @Test
    public void test_add_reader(){
        assertTrue(library.addReader(reader1));
    }
    @Test
    public void test_add_same_reader(){
        assertTrue(library.addReader(reader1));
        assertTrue(library.addReader(reader2));
        assertTrue(library.addReader(reader3));
        assertFalse(library.addReader(reader1));
    }
    @Test
    public void test_add_reader_same_info(){
        assertTrue(library.addReader(reader1));
        assertTrue(library.addReader(reader2));
        assertTrue(library.addReader(reader3));
        assertFalse(library.addReader(reader4Same1));
    }

    @Test
    public void test_add_edition_null(){
        assertFalse(library.addEditionInList(null));
    }

    @Test
    public void test_add_edition(){
        assertTrue(library.addEditionInList(bookFinancier));
    }

    @Test
    public void test_give_edition_to_reader_null(){
        assertFalse(library.giveEditionToReader(constitution, null));
    }
    @Test
    public void test_give_edition_null_to_reader(){
        assertFalse(library.giveEditionToReader(null, reader1));
    }

    @Test
    public void test_give_edition_to_reader_in_blacklist(){
        assertTrue(library.addReaderToBlacklist(reader1));
        assertFalse(library.giveEditionToReader(constitution, reader1));
    }

    @Test
    public void test_give_3_editions_to_reader(){
        assertTrue(library.giveEditionToReader(bookFinancier, reader1));
        assertTrue(library.giveEditionToReader(constitution, reader1));
        assertTrue(library.giveEditionToReader(bookTitan, reader1));
    }

    @Test
    public void test_give_edition_to_reader_which_have_3_books(){
        assertTrue(library.giveEditionToReader(bookFinancier, reader1));
        assertTrue(library.giveEditionToReader(bookStoic, reader1));
        assertTrue(library.giveEditionToReader(bookTitan, reader1));
        assertFalse(library.giveEditionToReader(constitution, reader1));
    }

    @Test
    public void test_give_edition_which_not_in_stock_to_reader(){
        assertTrue(library.giveEditionToReader(bookFinancier, reader1));
        assertFalse(library.giveEditionToReader(bookFinancier, reader2));
    }
    @Test
    public void test_give_edition_to_reader(){
        assertTrue(library.giveEditionToReader(bookFinancier, reader1));
        assertTrue(library.giveEditionToReader(constitution, reader1));
    }

    @Test
    public void test_add_to_black_list(){
        assertTrue(library.addReaderToBlacklist(reader1));
    }
    @Test
    public void test_add_to_black_list_null(){
        assertFalse(library.addReaderToBlacklist(null));
    }
    @Test
    public void test_add_to_black_list_already_in_list(){
        assertTrue(library.addReaderToBlacklist(reader1));
        assertFalse(library.addReaderToBlacklist(reader1));
    }
    @Test
    public void test_remove_from_black_list(){
        assertTrue(library.addReaderToBlacklist(reader1));
        assertTrue(library.removeFromBlackList(reader1));
    }
    @Test
    public void test_remove_from_black_list_null(){
        assertFalse(library.removeFromBlackList(null));
    }
    @Test
    public void test_remove_from_list_reader_which_not_in_list(){
        assertFalse(library.removeFromBlackList(reader1));
    }

    @Test
    public void test_show_editions_that_readers_have(){

    }










}
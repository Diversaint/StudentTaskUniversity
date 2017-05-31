package library;

import library.comparator.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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
    private ArrayList<Reader> readers = new ArrayList<>();
    private ArrayList<Edition> editions = new ArrayList<>();


    @Before
    public void setUp(){
        library = new Library();
        bookFinancier = new Book("Financier", "Dreiser", 1990, "Roman");
        bookTitan = new Book("Titan", "Dreiser", 1989, "Roman");
        bookStoic = new Book("Stoic", "Dreiser", 1990, "Roman");
        constitution = new Edition("Constitution of Ukraine", "Goverment", 1991);

        reader1 = new Reader("James", "Bond", 'm', 52);
        reader2 = new Reader("James1", "Bond", 'm', 52);
        reader3 = new Reader("James", "Bond2", 'm', 52);
        reader4Same1 = new Reader("James", "Bond", 'm', 52);
        reader5 = new Reader("James", "Bond", 'm', 54);
        reader6 = new Reader("James", "Bond", 'm', 18);
        readers.add(reader1);
        readers.add(reader2);
        readers.add(reader3);
        readers.add(reader5);
        readers.add(reader6);
        editions.add(bookFinancier);
        editions.add(bookTitan);
        editions.add(bookStoic);
        editions.add(constitution);

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
        assertFalse(library.addEditionToReader(constitution, null));
    }
    @Test
    public void test_give_edition_null_to_reader(){
        assertFalse(library.addEditionToReader(null, reader1));
    }

    @Test
    public void test_give_edition_to_reader_in_blacklist(){
        assertTrue(library.addReaderToBlacklist(reader1));
        assertFalse(library.addEditionToReader(constitution, reader1));
    }

    @Test
    public void test_give_3_editions_to_reader(){
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(constitution, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader1));
    }

    @Test
    public void test_give_edition_to_reader_which_have_3_books(){
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(bookStoic, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader1));
        assertFalse(library.addEditionToReader(constitution, reader1));
    }

    @Test
    public void test_give_edition_which_not_in_stock_to_reader(){
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertFalse(library.addEditionToReader(bookFinancier, reader2));
    }
    @Test
    public void test_give_edition_to_reader(){
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(constitution, reader1));
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
    public void test_show_readers_empty_lib(){
        assertNull(library.getShowAllReaders(new SurNamePersonComparator()));
    }
    @Test
    public void test_show_readers_comparator_null(){
        library.addReader(reader1);
        assertNull(library.getShowAllReaders(null));
    }

    @Test
    public void test_show_readers_by_size(){
        ArrayList<Reader> expected = new ArrayList<>(readers);
        library.addReader(reader1);
        library.addReader(reader2);
        library.addReader(reader3);
        library.addReader(reader5);
        library.addReader(reader6);
        ArrayList<Reader> actual = new ArrayList<>(library.getShowAllReaders(new NamePersonComparator()));
        actual = new ArrayList<>(library.getShowAllReaders(new SurNamePersonComparator()));
        actual = new ArrayList<>(library.getShowAllReaders(new AgePersonComparator()));
        assertEquals(actual.size(), expected.size());
    }

    @Test
    public void test_show_editions_empty_lib(){
        assertNull(library.getShowAllEditions(new AuthorEditionComparator()));
    }
    @Test
    public void test_show_editions_comparator_null(){
        assertTrue(library.addEditionInList(bookTitan));
        assertNull(library.getShowAllEditions(null));
    }

    @Test
    public void test_show_editions_by_size(){
        ArrayList<Edition> expected = new ArrayList<>(editions);
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));
        assertEquals(expected.size(), library.getShowAllEditions(new AuthorEditionComparator()).size());
    }
    @Test
    public void test_show_editions_from_readers(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader2));

        assertEquals(2, library.showGetEditionsFromReaders(new NameEditionComparator()).size());
    }

    @Test
    public void test_show_editions_from_readers_empty(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));

        assertEquals(0, library.showGetEditionsFromReaders(new YearOfIssueComparator()).size());
    }

    @Test
    public void test_show_editions_from_reader_empty(){
        assertNull(library.showGetEditionsFromTheReader(new AuthorEditionComparator(), reader1));
    }
    @Test
    public void test_show_editions_from_reader_comparator_null(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addReader(reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader1));
        assertNull(library.showGetEditionsFromTheReader(null, reader1));
    }
    @Test
    public void test_show_editions_from_reader_null(){
        assertNull(library.showGetEditionsFromTheReader(new AuthorEditionComparator(), null));
    }

    @Test
    public void test_show_editions_from_the_reader(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader1));

        assertEquals(2, library.showGetEditionsFromTheReader(new YearOfIssueComparator(), reader1).size());
    }

    @Test
    public void test_find_editions_by_arg_null(){
        assertNull(library.findShowEditionsByAuthorOrYear(null, new AuthorEditionComparator()));
    }
    @Test
    public void test_find_editions_by_arg_comparator_null(){
        assertNull(library.findShowEditionsByAuthorOrYear("Titan", null));
    }

    @Test
    public void test_find_editions_by_author_by_size(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader2));

        assertEquals(3, library.findShowEditionsByAuthorOrYear("Dreiser", new AuthorEditionComparator()).size());
    }
    @Test
    public void test_find_editions_by_year_by_size(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader2));

        assertEquals(2, library.findShowEditionsByAuthorOrYear(1990, new AuthorEditionComparator()).size());
    }

    @Test
    public void test_find_editions_by_key_null(){
        assertNull(library.findShowEditionByKeywords(new AuthorEditionComparator(), null));
    }
    @Test
    public void test_find_editions_by_key_comparator_null(){
        assertNull(library.findShowEditionByKeywords(null, "test"));
    }

    @Test
    public void test_find_editions_by_key_by_size(){
        assertTrue(library.addEditionInList(bookTitan));
        assertTrue(library.addEditionInList(bookFinancier));
        assertTrue(library.addEditionInList(bookStoic));
        assertTrue(library.addEditionInList(constitution));
        assertTrue(library.addEditionToReader(bookFinancier, reader1));
        assertTrue(library.addEditionToReader(bookTitan, reader2));

        assertEquals(3, library.findShowEditionByKeywords(new AuthorEditionComparator(), "1990", "1989").size());
    }

    @Test
    public void test_equals_editions_and_compareTo(){
        assertFalse(bookFinancier.equals(bookStoic));
    }

}
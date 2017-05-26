package library.comparator;

import library.Edition;

import java.util.Comparator;

/**
 * Created by macbook on 26.05.17.
 */
public class AuthorEditionComparator implements Comparator<Edition> {

    @Override
    public int compare(Edition o1, Edition o2) {
        return o1.getAuthor().compareTo(o2.getAuthor());
    }
}

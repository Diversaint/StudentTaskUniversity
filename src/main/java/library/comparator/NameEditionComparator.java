package library.comparator;

import library.Edition;
import library.Person;

import java.util.Comparator;

/**
 * Created by macbook on 26.05.17.
 */
public class NameEditionComparator implements Comparator<Edition> {

    @Override
    public int compare(Edition o1, Edition o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

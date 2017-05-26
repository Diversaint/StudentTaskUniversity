package library.comparator;

import library.Person;

import java.util.Comparator;

/**
 * Created by macbook on 26.05.17.
 */
public class SurNamePersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getSurName().compareTo(o2.getSurName());
    }
}

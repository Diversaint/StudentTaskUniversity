package library.comparator;

import library.Person;

import java.util.Comparator;

/**
 * Created by macbook on 26.05.17.
 */
public class AgePersonComparator implements Comparator <Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}

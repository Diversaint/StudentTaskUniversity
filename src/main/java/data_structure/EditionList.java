package data_structure;

import library.Edition;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by macbook on 31.05.17.
 */
public class EditionList extends ArrayList<Edition> implements Comparable<Edition>{

    public EditionList(Collection<? extends Edition> c) {
        super(c);
    }

    public EditionList() {

    }

    public EditionList(int initialCapacity) {

        super(initialCapacity);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int compareTo(Edition edition) {
        return this.compareTo(edition);
    }
    
    public int indexOf(Edition o) {
        for (int i = 0; i < super.size(); i++) {
            if (o.equals(super.get(i))) return i;
        }
        return -1;
    }

}

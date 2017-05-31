package data_structure;

import library.Edition;

import java.util.ArrayList;

/**
 * Created by macbook on 31.05.17.
 */
public class EditionList extends ArrayList<Edition> implements Comparable<Edition>{

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int compareTo(Edition edition) {
        return this.compareTo(edition);
    }
}

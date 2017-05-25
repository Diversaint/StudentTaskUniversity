package data_structure;

/**
 * Created by macbook on 25.05.17.
 */
public interface MyCollection {
    boolean add (Object o);
    boolean contains (Object o);
    void clear();
    boolean isEmpty();
    boolean remove(Object o);
    int size();
}

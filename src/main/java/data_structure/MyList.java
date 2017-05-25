package data_structure;

/**
 * Created by macbook on 25.05.17.
 */
public interface MyList extends MyCollection {
    boolean add(Object o, int index);
    Object get(int index);
    Object remove(int index);
    boolean set(Object o, int index);
}

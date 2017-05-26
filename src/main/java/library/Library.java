package library;

import com.sun.org.apache.regexp.internal.RE;

import java.util.TreeSet;

/**
 * Created by macbook on 26.05.17.
 */
public class Library {
    private TreeSet <Edition> listEditions;
    private TreeSet <Reader> listReaders;

    public Library() {
        listEditions = new TreeSet<>();
        listReaders = new TreeSet<>();
    }

    public Library(TreeSet<Edition> listEditions, TreeSet<Reader> listReaders) {
        this.listEditions = new TreeSet<>(listEditions);
        this.listReaders = new TreeSet<>(listReaders);
    }

    /*public boolean checkForReapetInList (Object object, TreeSet<Object> list) {
        if (object.getClass() == Reader.class)
            for (Reader reader :  (TreeSet<Reader>)list)

        for (Object object1 : list)
        return false;
    }*/

    public boolean addReader(Reader reader){
        if (listReaders.size() == 0) return listReaders.add(reader);
        for (Reader reader1 : listReaders) {
            return reader.compareTo(reader1) != 0 ? listReaders.add(reader) : false;
        }
    return false;
    }

    public boolean removeReader(Reader reader){
        if (listReaders.size() == 0) return false;
        for (Reader reader1 : listReaders) {
            return reader.compareTo(reader1) == 0 ? listReaders.remove(reader) : false;
        }
    return false;
    }

    public boolean addEditionInList(Edition edition){
        return listEditions.add(edition);
    }

    public boolean revomeEditionFromList(Edition edition){
        if (edition.getPerson() != null) return false;
        for (Edition edition1 : listEditions) {
            if (edition.compareTo(edition1) == 0 && edition1.getPerson() != null)
                return listEditions.remove(edition);
        }
    return false;
    }

}

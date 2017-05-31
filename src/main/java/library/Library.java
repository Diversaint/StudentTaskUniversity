package library;

import com.sun.org.apache.regexp.internal.RE;
import library.comparator.NameEditionComparator;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by macbook on 26.05.17.
 */
public class Library {
    private ArrayList<Edition> listEditions;
    private ArrayList <Reader> listReaders;

    public Library() {
        listEditions = new ArrayList<>();
        listReaders = new ArrayList<>();
    }

    public Library(ArrayList<Edition> listEditions, ArrayList<Reader> listReaders) {
        this.listEditions = new ArrayList<>(listEditions);
        this.listReaders = new ArrayList<>(listReaders);
    }

    public ArrayList<Edition> getListEditions() {
        return new ArrayList<Edition>(listEditions);
    }

    public ArrayList<Reader> getListReaders() {
        return new ArrayList<Reader>(listReaders);
    }

    public boolean addReader(Reader reader){
        if (reader == null) return false;
        if (listReaders.size() == 0) return listReaders.add(reader);
        for (Reader reader1 : listReaders) {
            if (reader.equals(reader1)) return false;
            if (listReaders.add(reader)) return true;
        }
    return false;
    }

/*** Wait for task for this function. !!!Dont forget edition.person = null when remove Person
    public boolean removeReader(Reader reader){
        if (listReaders.size() == 0) return false;
        for (Reader reader1 : listReaders)
            if (reader.equals(reader1)) return listReaders.remove(reader);
    return false;
    }

    public boolean revomeEditionFromList(Edition edition){
    if (edition.getPerson() != null) return false;
    for (Edition edition1 : listEditions) {
    if (edition.compareTo(edition1) == 0 && edition1.getPerson() != null)
    return listEditions.remove(edition);
    }
    return false;
    }
 public boolean checkForReapetInList (Object object, TreeSet<Object> list) {
 if (object.getClass() == Reader.class)
 for (Reader reader :  (TreeSet<Reader>)list)

 for (Object object1 : list)
 return false;
 }

 */

    public boolean addEditionInList(Edition edition){
        if (edition == null) return false;
        return listEditions.add(edition);
    }

    public ArrayList<Reader> getReadersAndShow(Comparator<Person> comparator){
        if (listReaders.size() == 0){
            System.out.println("No readers in list");
            return null;
        }
        System.out.println(listReaders.size() + " readers in lib:");
        int tempCount = 1;
        ArrayList <Reader> tempList = getListReaders();
        tempList.sort(comparator);
        for (Reader reader : tempList) {
            System.out.println(tempCount + "."+ reader.toString());
            tempCount++;
        }

        return getListReaders();
    }

    private void showListEditions(ArrayList<Edition> listEditions){
        if (listEditions.size() == 0) System.out.println("No editions");
        int tempCount = 1;
        System.out.println(listEditions.size() + " editions in list");
        for (Edition edition : listEditions) {
            System.out.println(tempCount + "." + edition.toString());
            tempCount++;
        }


    }
    public ArrayList<Edition> getAllEditionsAndShow(Comparator<Edition> comparator){
        if (listEditions.size() == 0) return null;
        ArrayList <Edition> tempList = getListEditions();
        tempList.sort(comparator);
        showListEditions(tempList);
        return getListEditions();
    }

    public boolean giveEditionToReader(Edition edition, Reader reader){
        if (edition == null || reader== null) return false;
        if (reader.isInBlackList()) return false;
        if (reader.getEditions().size() == 3) return false;
        if (edition.getPerson() != null) return false;
        return reader.addEdition(edition);
    }


    public boolean addReaderToBlacklist(Reader reader) {
        if (reader == null) return false;
        if (reader.isInBlackList()) return false;
        reader.setInBlackList(true);
        return true;
    }

    public boolean removeFromBlackList(Reader reader) {
        if (reader == null) return false;
        if (!reader.isInBlackList()) return false;
        reader.setInBlackList(false);
        return true;
    }

    public ArrayList<Edition> showAndGetListAditionsFromReaders(Comparator<Edition> comparator){
        ArrayList<Edition> tempList = new ArrayList();
        for (Edition edition : listEditions) {
            if (edition.getPerson() != null)
                tempList.add(edition);
        }
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }

    public ArrayList<Edition> showAndGetListEditionsFromThisReader(Comparator<Edition> comparator, Reader reader){
        if (reader == null) return null;
        if (reader.getEditions().size() == 0) return null;
        ArrayList<Edition> tempList = new ArrayList(reader.getEditions());
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }

    public ArrayList<Edition> showAndGetListEditionsByAuthorOrYear(Object arg, Comparator<Edition> comparator){
        if (arg == null) return null;

        ArrayList<Edition> tempList = new ArrayList();
        if (arg instanceof String)
            for (Edition edition : listEditions) {
                if (arg.equals(edition.getAuthor()))
                    tempList.add(edition);
            }
            else if (arg instanceof Integer)
            for (Edition edition : listEditions) {
                if ((int) arg == edition.getYearOfIssue()) {
                    tempList.add(edition);
                }
            }
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }

    public ArrayList<Edition> findEditionByKeywords(Comparator<Edition> comparator, String ...keywords){
        if (keywords == null) return null;
        ArrayList<Edition> tempList = new ArrayList();
        for (Edition edition : listEditions) {
            for (String kyeword : keywords) {
                if(edition.toString().contains(kyeword))
                    tempList.add(edition);
            }
        }
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }
}


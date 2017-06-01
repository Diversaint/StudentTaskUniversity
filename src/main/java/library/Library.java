package library;

import data_structure.EditionList;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by macbook on 26.05.17.
 */
public class Library {
    private EditionList listEditions;
    private ArrayList <Reader> listReaders;
    private static final int MAX_NUMBER_OF_EDITIONS = 3;

    public Library() {
        listEditions = new EditionList();
        listReaders = new ArrayList<>();
    }

    public EditionList getListEditions() {
        return new EditionList(listEditions);
    }

    public ArrayList<Reader> getListReaders() {
        return new ArrayList<>(listReaders);
    }

    public boolean addReader(Reader reader){
        if (reader == null) return false;
        if (listReaders.size() == 0) return listReaders.add(reader);
        if (listReaders.contains(reader)) return false;
        if (listReaders.add(reader)) return true;
        return false;
    }
    /** Fixed! Add edition in list. Check if same edition(object) edition == edition in list). If edition equals edition
     * in list add to list and copy number(exampler) +1 */
    public boolean addEditionInList(Edition edition){
        if (edition == null) return false;
        if (edition.getPerson() != null) return false;
        for (Edition edition1 : listEditions) {
            if (edition == edition1) return false;
            if (edition.equals(edition1)) edition.setExemplar(edition.getExemplar() + 1);
        }
        return listEditions.add(edition);
    }
    /** Return sorted readers list (by comparator) and show it */
    public ArrayList<Reader> getShowAllReaders(Comparator<Person> comparator){
        if (comparator == null) return null;
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
    /** Method for print edition list */
    private void showListEditions(EditionList listEditions){
        if (listEditions.size() == 0) System.out.println("No editions");
        int tempCount = 1;
        System.out.println(listEditions.size() + " editions in list");
        for (Edition edition : listEditions) {
            System.out.println(tempCount + "." + edition.toString());
            tempCount++;
        }


    }
    /** Return sorted edition list (by comparator) and show it */
    public EditionList getShowAllEditions(Comparator<Edition> comparator){
        if (listEditions.size() == 0 || comparator == null) return null;
        EditionList tempList = getListEditions();
        tempList.sort(comparator);
        showListEditions(tempList);
        return getListEditions();
    }

    /** Give edition to reader. Check max editions in list of reader and check blacklist */
    public boolean addEditionToReader(Edition edition, Reader reader){
        if (edition == null || reader== null) return false;
        /** Check for arg == object in list */
        edition = listEditions.indexOf(edition) >= 0 ? listEditions.get(listEditions.indexOf(edition)) : null;
        reader = listReaders.indexOf(reader) >= 0 ? listReaders.get(listReaders.indexOf(reader)) : null;
        if (edition == null || reader== null) return false;
        //tempIndex > 0 ? tempIndex = 1 : false;
        //> 0 ? tempIndex = listEditions.indexOf(edition) : tempIndex = 0;

        if (!listEditions.contains(edition) || !listReaders.contains(reader)) return false;
        if (reader.isInBlackList()) return false;
        if (reader.getEditions().size() == MAX_NUMBER_OF_EDITIONS) return false;
        if (edition.getPerson() != null) return false;
        return reader.addEdition(edition);
    }

    /** Add/remove reader to/from blacklist. Check reader already in list. */
    public boolean addReaderToBlacklist(Reader reader) {
        return addRemoveBlacklist(reader, true);
    }

    public boolean removeFromBlackList(Reader reader) {
        return addRemoveBlacklist(reader, false);
    }

    private boolean addRemoveBlacklist(Reader reader, boolean addRemove){
        if (reader == null) return false;
        reader = listReaders.indexOf(reader) >= 0 ? listReaders.get(listReaders.indexOf(reader)) : null;
        if (reader == null) return false;
        if (reader.isInBlackList() == addRemove) return false;
        reader.setInBlackList(addRemove);
        return true;
    }
    /** Return sorted(by comparator) list of editions that readers have and show it */
    public EditionList showGetEditionsFromReaders(Comparator<Edition> comparator){
        if (comparator == null) return null;
        EditionList tempList = new EditionList();
        for (Edition edition : listEditions) {
            if (edition.getPerson() != null)
                tempList.add(edition);
        }
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }
    /** Return sorted(by comparator) list of editions that the reader have and show it */
    public EditionList showGetEditionsFromTheReader(Comparator<Edition> comparator, Reader reader){
        if (reader == null || comparator == null) return null;
        if (reader.getEditions().size() == 0) return null;
        EditionList tempList = new EditionList(reader.getEditions());
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }
    /** Return sorted(by comparator) list of editions search by author(if arg will be String) or year of issue(if arg will be int) */
    public EditionList findShowEditionsByAuthorOrYear(Object arg, Comparator<Edition> comparator){
        if (arg == null || comparator == null) return null;
        EditionList tempList = new EditionList();
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
    /** Return sorted(by comparator) list of editions search by keywords in all fields. Editions to String and contains with it*/
    public EditionList findShowEditionByKeywords(Comparator<Edition> comparator, String ...keywords){
        if (keywords == null || comparator == null) return null;
        EditionList tempList = new EditionList();
        for (Edition edition : listEditions) {
            for (String keyword : keywords) {
                if(edition.infoToString().contains(keyword))
                    tempList.add(edition);
            }
        }
        tempList.sort(comparator);
        showListEditions(tempList);
        return tempList;
    }
}


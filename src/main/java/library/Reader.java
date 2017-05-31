package library;


/**
 * Created by macbook on 26.05.17.
 */
public class Reader extends Person {
    private boolean isInBlackList;

    public boolean isInBlackList() {
        return isInBlackList;
    }

    public void setInBlackList(boolean inBlackList) {
        this.isInBlackList = inBlackList;
    }

    public Reader(String name, String surName, char sex, int age) {
        super(name, surName, sex, age);
    }

    public Reader(Person person) {
        super(person);
    }


    @Override
    public boolean addEdition(Edition edition) {
        if (isInBlackList) return false;
        if (super.getEditions().size() > 2) return false;
        return super.addEdition(edition);
    }
}

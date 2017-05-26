package library;

import java.util.TreeSet;

/**
 * Created by macbook on 26.05.17.
 */
public class Reader extends Person {
    public Reader(String name, String surName, char sex, int age) {
        super(name, surName, sex, age);
    }

    public Reader(Person person) {
        super(person);
    }

    public boolean addEdition(Edition edition) {
        return getEditions().add(edition);
    }

}

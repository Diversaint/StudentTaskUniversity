package library;


import java.util.ArrayList;

/**
 * Created by macbook on 26.05.17.
 */
public class Person implements Comparable<Object>{
    private String name;
    private String surName;
    private char sex;
    private int age;
    private ArrayList<Edition> editions;

    {
        editions = new ArrayList<>();
    }

    public Person(String name, String surName, char sex, int age) {
        this.name = name;
        this.surName = surName;
        this.sex = sex;
        this.age = age;
    }

    public Person(Person person) {
        if (person == null) return;
        this.name = person.name;
        this.age = person.age;
        this.surName = person.surName;
        this.sex = person.sex;
        this.editions = person.editions;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Edition> getEditions() {
        return editions;
    }
    /*
    public ArrayList<Edition> getEditions() {
        return new ArrayList<>(editions);
    }
*/


    @Override
    public int compareTo(Object o) {
        Person person = (Person) o;
        int compareToResult = this.name.compareTo(person.name);
        if (compareToResult != 0) return compareToResult;
        compareToResult = this.surName.compareTo(person.surName);
        if (compareToResult != 0) return compareToResult;
        compareToResult = this.age - person.age;
        return compareToResult;

    }
    /** Add edition to person list */
    public boolean addEdition(Edition edition) {
        if (editions.add(edition)){
            edition.setPerson(this);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (this.compareTo(o) == 0) return true;
        return false;

    }

    @Override
    public String toString() {
        return
                "name='" + name + "\t" +
                "surName='" + surName + "\t" +
                "sex=" + sex + "\t" +
                "age=" + age;
    }
}

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

 /*   public void setName(String name) {
        Pattern alph = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = alph.matcher(name);
        if (matcher.matches())
            this.name = name;
        else {
            this.name = "";
            System.out.println("For name use only letters");
        }
    }

    public void setSurName(String surName) {
        Pattern alph = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = alph.matcher(surName);
        if (matcher.matches())
            this.surName = surName;

        else {
            this.surName = "";
            System.out.println("For surname use only letters");
        }
    }

    public void setAge(int age) {
        if (age > 14 && age < 60)
            this.age = age;
        else
            System.out.println("Check typing age and try again");
    }

    public void setSex(char sex) {
        if (sex == 'w' || sex == 'm')
        this.sex = sex;
        else{
            System.out.println("Enter your sex w (woman) or m (man)");
        }
    }*/

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

    public char getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Edition> getEditions() {
        //return editions;
        return new ArrayList<>(editions);
    }


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

    public boolean addEdition(Edition edition) {
        if (editions.add(edition)){
            edition.setPerson(this);
            return true;
        }
        return false;
    }

/** Wait for task
    public boolean returnEditionToLib(Edition edition){
        if (editions.remove(edition)){
            edition.setPerson(null);
            return true;
        }
        return false;
    }
*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;
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

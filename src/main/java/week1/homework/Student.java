package week1.homework;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by saint on 17.05.17.
 */
public class Student {
    private String name;
    private String surName;
    private int age;

    public String getName() {
        return name;
    }

    public Student(){
        name = "";
        surName = "";
    }
    public Student(String name, String surName, int age){
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public void setName(String name) {
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

    public String asString(){
        return String.format("Student name - %-10s, surname - %-10s, age -  %-5d", name, surName, age);
    }
    // override equals to student // fixed
    @Override
    public boolean equals(Object var1) {
        if (var1 == null)
            return false;
        if (!(var1 instanceof Student)) // need '&& this instanceof Student' or no?
            return false;
        Student student1 = (Student)var1;
        if (student1.name.equals(this.name) && student1.surName.equals(this.surName) && student1.age == this.age)
            return true;
        return false;
    }

}

package week2;

import java.util.ArrayList;

/**
 * Created by macbook on 25.05.17.
 */
public class Cat {
    private String name;
    public static ArrayList <Cat> cats = new ArrayList<Cat>();


    public Cat(String name) {
        this.name = name;
        cats.add(this);
    }


    public void printCats(){
        System.out.println(cats.toString());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}

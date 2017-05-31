package week3.classwork;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by macbook on 28.05.17.
 */
public class Repka implements Iterator<Product> {
    private Product[] products;

    public Repka() {
    }

    public Repka(Product[] products) {
        this.products = products;
    }

    protected int position = 0;
    @Override
    public boolean hasNext() {

        for (int i = position; i < products.length; i++) {
             if (products[i] != null) {
                 position++;
                 return true;
             }
        }
        position++;
        return false;
    }

    @Override
    public Product next() {
        for (int i = position; i < products.length; i++) {
            if (hasNext())
                return products[i];
        }
        return null;
    }

    @Override
    public String toString() {
        return "Repka{" +
                "products=" + Arrays.toString(products) +
                ", position=" + position +
                '}';
    }
}

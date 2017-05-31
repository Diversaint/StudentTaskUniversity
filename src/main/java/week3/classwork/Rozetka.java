package week3.classwork;

import java.util.Iterator;
import java.util.List;

/**
 * Created by macbook on 28.05.17.
 */
public class Rozetka implements Iterator<Product>{
    private List<Product> products;
    int position = 0;

    public Rozetka(List<Product> products) {
        this.products = products;
    }

    public Rozetka() {
    }

    @Override
    public boolean hasNext() {
        if (position < products.size()){
            position++;
            return true;
        }
        position++;
        return false;
    }

    @Override
    public Product next() {
        if (hasNext()) return products.get(position);
        return null;
    }
}

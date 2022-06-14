package Generics.P03GenericSwap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Box<T> {
    List<T> elements;

    public Box() {
        elements = new ArrayList<>();
    }
    public void add(T element) {
        elements.add(element);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T element : this.elements) {
            sb.append(String.format("%s: %s%n", element.getClass().getName(), element.toString()));
        }
        return sb.toString();
    }
    public void swap(int firstIndex, int secondIndex) {
        Collections.swap(elements, firstIndex, secondIndex);
    }
}

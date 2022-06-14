package Generics.P01GenericBox;

public class Box<T> {
    T element;

    public Box(T element) {
        this.element = element;
    }

    @Override
    public String toString() {
        //java.lang.String: life in a box
        return String.format("%s: %s%n", element.getClass().getName(), element);
    }
}

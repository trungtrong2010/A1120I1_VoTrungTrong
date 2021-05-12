package _10_ads_arraylist_linkedlist._th;

import java.util.Arrays;

public class MyList {

    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(Object object) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = object;
    }

    public Object get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i);
        }
        return elements[i];
    }
}

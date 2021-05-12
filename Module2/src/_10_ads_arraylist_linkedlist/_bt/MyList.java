package _10_ads_arraylist_linkedlist._bt;

public class MyList<E> {

    private int count = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int count) {
        this.count = count;
    }


    public void add(E element) {
        elements[count] = element;
        count++;
    }

    public Object get(int index) {
        return elements[index];
    }

    public Object remove(int index) {
        Object o = null;
        if (index < elements.length) {
            o = elements[index];
            for (int i = index; i < elements.length - 1; i++) {
                elements[i] = elements[i + 1];
            }
            count--;
        }
        return o;
    }

    public void getAll() {
        System.out.print("[");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null){
                System.out.print(get(i));
                if (elements[i + 1] != null) {
                    System.out.print(", ");
                }
            }
        }
        System.out.print("]");
    }
}

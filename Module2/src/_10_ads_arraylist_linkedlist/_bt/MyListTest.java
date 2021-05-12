package _10_ads_arraylist_linkedlist._bt;

public class MyListTest {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        System.out.println("____________");
        list.remove(1);
        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));

        list.getAll();
    }
}

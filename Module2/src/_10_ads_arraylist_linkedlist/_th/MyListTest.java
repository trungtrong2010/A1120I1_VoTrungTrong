package _10_ads_arraylist_linkedlist._th;

public class MyListTest {
    public static void main(String[] args) {
        MyList listInteger = new MyList();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);

        System.out.println("element 4: "+listInteger.get(3));
        System.out.println("element 1: "+listInteger.get(1));
        System.out.println("element 2: "+listInteger.get(2));

    }
}

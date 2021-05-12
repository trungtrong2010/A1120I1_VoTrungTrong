//package _10_ads_arraylist_linkedlist._th;
//
//public class MyLinkedList {
//    private Node head;
//    private int numNodes;
//
//    public MyLinkedList(Node head) {
//        this.head = head;
//    }
//
//    public MyLinkedList(Object data) {
//        head = new Node(data);
//    }
//
//    private static class Node {
//        private Node next;
//        private Object data;
//
//        public Node(Object data) {
//            this.data = data;
//        }
//
//        public Object getData() {
//            return this.data;
//        }
//    }
//
//    public void add(int index, Object data) {
//        Node temp = head;
//        head = new Node(data);
//        head.next = temp;
//        numNodes++;
//    }
//
//    public Node get(int index){
//        Node temp=head;
//        for(int i=0; i<index; i++) {
//            temp = temp.next;
//        }
//        return temp;
//    }
//
//    public void printList() {
//        Node temp = head;
//        while(temp != null) {
//            System.out.println(temp.data);
//            temp = temp.next;
//        }
//    }
//}
package _05_access_modifire___static._th;

public class TestStaticMethodOfStudent {
    public static void main(String[] args) {
        Student.change();

        Student student1 = new Student(111, "Võ");
        Student student2 = new Student(222, "Trung");
        Student student3 = new Student(333, "Trọng");
        student1.display();
        student2.display();
        student3.display();
    }
}

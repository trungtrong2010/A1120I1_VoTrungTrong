package _05_access_modifire___static._th;

public class Student {
    private int rollno;
    private String name;
    private static String college;

    public Student() {
    }

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getCollege() {
        return college;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }

    static void change() {
        college = "2121";
    }

    void display() {
        System.out.println(getRollno() + " " + this.name + " " + college);
    }
}


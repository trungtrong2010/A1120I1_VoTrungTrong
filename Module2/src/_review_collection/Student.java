package _16_review_collection;

public class Student extends Person {
    private int point;

    public Student(String name, int age, int point) {
        super(name, age);
        this.point = point;
    }

    public Student() {

    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + super.getName() + '\'' +
                ", age=" + super.getAge() +
                ", point=" + point +
                '}';
    }

    @Override
    public void showInfo() {
        System.out.println(this.toString());
    }
}

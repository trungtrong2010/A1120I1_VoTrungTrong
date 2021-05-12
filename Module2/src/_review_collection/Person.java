package _16_review_collection;

public abstract class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null || !(obj instanceof Person)){
            return false;
        }

        Person otherPerson = (Person) obj;

        if(this.name.equals(otherPerson.getName())){
            return true;
        }
        return false;
    }

    public abstract void showInfo();
}

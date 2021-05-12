package _07_abstract_class_interface._th._1_animal_interface_edible;

public class Test {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger();
        animals[1] = new Chicken();

        for (Animal animal : animals) {
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken) {
                // ép kiểu
                Edible edible = (Chicken) animal;
                System.out.println(edible.howtoEat());
            }
        }
    }
}
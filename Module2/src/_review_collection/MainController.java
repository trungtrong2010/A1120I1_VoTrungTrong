//package _16_review_collection;
//
//import java.util.ArrayList;
//
//public class MainController {
//    public static void main(String[] args) {
//        Person student1 = new Student("Duc", 18, 10);
//        Person student2 = new Student("Trong", 15, 11);
//        Person student3 = new Student("Duc", 20, 50);
//
//        Person teacher1 = new Teacher("Trung", 26, 1000);
//        Person teacher2 = new Teacher("Linh", 12, 1500);
//
//        PersonManager personManager = new PersonManager(new ArrayList<>());
//        personManager.addPerson(student1);
//        personManager.addPerson(student2);
//        personManager.addPerson(teacher1);
//        personManager.addPerson(teacher2);
//
//        for(Person person:personManager.getPersonList()){
//            System.out.println(person);
//        }
//
////        personManager.updatePerson(student3);
//        personManager.removePerson(student3);
//        System.out.println("-------------------------");
//        for(Person person:personManager.getPersonList()){
//            person.showInfo();
//        }
//
//        System.out.println(personManager.getPersonList().contains(new Student("aa",15,50)));
//    }
//}

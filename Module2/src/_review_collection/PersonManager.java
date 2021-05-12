//package _16_review_collection;
//
//import java.util.List;
//
//public class PersonManager {
//    private List<Person> personList;
//
//    public PersonManager(List<Person> personList) {
//        this.personList = personList;
//    }
//
//    public List<Person> getPersonList() {
//        return personList;
//    }
//
//    public void setPersonList(List<Person> personList) {
//        this.personList = personList;
//    }
//
//
//    public void addPerson(Person person){
//        this.personList.add(person);
//    }
//
//    public void updatePerson(Person person){
//        int index = personList.indexOf(z);
//
//        if(index == -1){
//            addPerson(person);
//        } else {
//            personList.set(index, person);
//        }
//
//    }
//
//    public void removePerson(Person person){
//        int index = this.personList.indexOf(person);
//
//        if(index == -1){
//            System.out.println("Not found.." + person.getName());
//        } else {
//            this.personList.remove(index);
//        }
//    }
//
//    public void removePerson(int index){
//        if(index == -1 || index >= this.personList.size()){
//            System.out.println("Index not correct: "+index);
//        } else {
//            this.personList.remove(index);
//        }
//    }
//
//}

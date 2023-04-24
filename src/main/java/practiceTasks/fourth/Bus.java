package practiceTasks.fourth;

import second.Person;

import java.util.ArrayList;

public class Bus {
    private int numberOfSeats;
    protected ArrayList<Person> passengers;

    public Bus(int numberOfSeats){
        this.numberOfSeats = numberOfSeats;
        this.passengers = new ArrayList<>();
    }

    public void addPassenger(Person person){
        System.out.println("Входит пассажир: " + person.getFullName());
        if(passengers.size() < numberOfSeats){
            if (person.hasName()){
                passengers.add(person);
                if(passengers.size() > 0){
                    go();
                }
            }else {
                System.out.println("У пассажира нет имени!");
            }
            return;
            }
        System.out.println("Нет свободных мест");
    }

    public void deletePassenger(Person person) {
        System.out.println("Выходит пассажир: " + person.getFullName());
        if (passengers.size() != 0) {
            if (passengers.contains(person)) {
                passengers.remove(person);
            } else {
                System.out.println("В автобусе не найден пассажир: " + person.getFullName());
            }
        } else {
            System.out.println("В автобусе нет пассажиров");
        }
    }

    public void addPassengers(Person[] newPassengers) {
        for (Person person : newPassengers) {
            addPassenger(person);
        }
    }

    public void deletePassengers(Person[] exitPassengers){
        for (Person person : exitPassengers){
            deletePassenger(person);
        }
    }

    public void go () {
        System.out.println("Автобус отправляется в  путь. " +
                "В автобусе " + passengers.size() + " пассажиров");
    }
}
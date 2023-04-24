package practiceTasks.fourth;

import second.Person;

public class Program {
    public static void main(String[] args){
        Bus bus = new Bus(5);
        Person anna = new Person();
        Person igor = new Person("Игорь", 25);
        Person oleg = new Person("Олег", 17);
        Person antony = new Person("Антон", 30);
        Person petr = new Person("Петя", 30);
        Person olga = new Person("Ольга", 18);
        Person vasily = new Person("Василий", 18);
        Person test = new Person("", 30);
        bus.addPassenger(test);
        bus.addPassengers(new Person[]{igor, anna});
        bus.deletePassengers(new Person[]{igor});
        bus.addPassengers(new Person[]{oleg, vasily, olga, antony, petr, igor});
        bus.deletePassenger(igor);
        bus.go();

        EnhancedBus enhancedBus = new EnhancedBus(5, 20, 5);
        enhancedBus.setConditioner(true);
        enhancedBus.addPassengers(new Person[]{oleg, vasily, olga, antony, petr, igor});
        enhancedBus.deletePassenger(vasily);
        System.out.println(enhancedBus.calculateMaxDistance());
    }
}

package second;

public class Program {
    public static void main(String[] args){
        Person personX = new Person("Oleg", 25);
        personX.talk();
        Person personY = new Person();
        personY.talk();
        Person personZ = new Person("Olga", 18);
        personZ.talk();
    }
}

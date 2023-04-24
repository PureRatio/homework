package second;

public class Person {
    private static int count;
    private int id;
    private String fullName;
    private int age;

    public Person() {
        id = count;
        count++;
    }

    public Person(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
        id = count;
        count++;
    }

    public void count() {
        System.out.printf("Количество объектов: %d\n", count);
    }

    public void talk() {
        if (fullName != null) {
            if (id == 2) {
                System.out.printf("Привет, я %s, избранный\n", fullName);
            }
            else{
                System.out.printf("Привет я %s и мне %d лет\n", fullName, age);
            }
        }
    }

    public boolean hasName(){
        return fullName!=null && !fullName.equals("");
    }

    public String getFullName() {
        return fullName;
    }
}
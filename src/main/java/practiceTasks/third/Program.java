package practiceTasks.third;

public class Program {
    public static void main(String[] args) {
        Student[] students = {new Student("Игорь", "Олегов", "студенты", 4.9),
                new Aspirant("Олег", "Игорев", "аспиранты", 5, "Вода")};

        for (Student student : students){
            System.out.println(student.getScholarship());
        }
    }
}

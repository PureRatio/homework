package practiceTasks.third;

public class Aspirant extends Student{
    String scientificWork;

    public Aspirant(String firstName, String lastName, String group, double averageMark, String scientificWork){
        super(firstName, lastName, group, averageMark);
        this.scientificWork = scientificWork;
    }

    @Override
    int getScholarship(){
        if(averageMark == 5){
            return 20000;
        }
        else {
            return 15000;
        }
    }
}

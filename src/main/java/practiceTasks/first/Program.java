package practiceTasks.first;

public class Program {
    public static void main(String[] args) {
        System.out.println(calculatePoints(5, 5, 5));
    }

    static int calculatePoints(int wins, int draws, int losses){
        int result;
        result = (wins * 3) + draws;
        return result;
    }
}

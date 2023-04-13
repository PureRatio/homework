package first;

public class Program {
    public static void main(String[] args){
        task1();
        System.out.println(task2(1, 2, 3, 4, 5));
    }

    static void task1(){
        for(int i=20; i<=40; i++ )
            System.out.println(i);
    }
    static boolean task2(int... arr){
        int summ = 0;
        for (int num : arr){
            summ += num;
        }

        return (summ/arr.length)* arr.length == summ;
    }
}
package practiceTasks.second;

public class Program {
    public static void main(String[] args) {
        System.out.println(isArraySpecial(new int[] {0, 1, 2, 3, 4, 5}));
    }

    static boolean isArraySpecial(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != i % 2){
                return false;
            }
        }
        return true;
    }
}

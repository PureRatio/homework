package fourth;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSymbols {
    public void calculateSymbols(String str){
        Map<String, Integer> symbols = new HashMap<String, Integer>();
        for (int i = 0; i < str.length(); i++) {
            String c = String.valueOf(str.charAt(i));
            if(symbols.containsKey(c)){
                symbols.put(c,symbols.get(c)+1);
            } else {
                symbols.put(c,1);
            }
        }
        for(Map.Entry<String, Integer> entry : symbols.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("Letter " + key + " appears " + value + " times.");
        }
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        CountSymbols counter = new CountSymbols();
        counter.calculateSymbols(str);
        in.close();
    }
}

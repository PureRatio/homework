package practiceTasks.fifth;

import java.util.ArrayList;

public class Box implements Boxable{
    private ArrayList <Sweet> sweets = new ArrayList<>();

    @Override
    public void addSweet(Sweet sweet) {
        sweets.add(sweet);
    }

    @Override
    public void deleteSweet(int index) {
        sweets.remove(index);
    }

    @Override
    public double getWeight() {
        double weight = 0;
        for (Sweet sweet : sweets){
            weight += sweet.weight;
        }
        return weight;
    }

    @Override
    public int getCost() {
        int cost = 0;
        for (Sweet sweet : sweets){
            cost += sweet.price;
        }
        return cost;
    }

    @Override
    public void printInfo() {
        System.out.println("Наполнение коробки:");
        for (Sweet sweet: sweets) {
            System.out.println(sweet);
        }
    }
}

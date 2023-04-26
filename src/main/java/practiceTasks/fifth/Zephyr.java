package practiceTasks.fifth;

public class Zephyr extends Sweet {
    boolean isGlazed;
    public Zephyr(String name, int price, double weight, boolean isGlazed){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.isGlazed = isGlazed;
    }

    @Override
    public String toString(){
        return super.toString() + "\n Наличие глазури: " + isGlazed;
    }
}

package practiceTasks.fifth;

public class Cookie extends Sweet {
    String filling;
    public Cookie(String name, int price, double weight, String filling){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.filling = filling;
    }

    @Override
    public String toString(){
        return super.toString() + "\n Начинка: " + filling;
    }
}

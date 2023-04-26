package practiceTasks.fifth;

public class Candy extends Sweet {
    String flavor;
    public Candy(String name, int price, double weight, String flavor){
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.flavor = flavor;
    }

    @Override
    public String toString(){
        return super.toString() + "\n Вкус: " + flavor;
    }
}

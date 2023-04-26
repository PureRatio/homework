package practiceTasks.fifth;

public abstract class Sweet {
    String name;
    int price;
    double weight;

    @Override
    public String toString(){
        return "Тип сладости: " + name + "\n Цена за штуку: " + price + "\n Вес одной штуки: " + weight;
    }
}

package practiceTasks.fifth;

public class MainClass {
    public static void main(String[] args) {
        Box box = new Box();

        box.addSweet( new Candy("Карамель", 5, 0.01, "Ананас"));
        box.addSweet( new Candy("Раковые шейки", 2, 0.01, "Ваниль и арахис"));
        box.addSweet( new Cookie("Орешек", 15, 0.025, "Сгущёнка"));
        box.addSweet( new Zephyr("Зефир в йогуртовой глазури", 25, 0.05, true));
        box.deleteSweet(1);

        System.out.printf("Общий вес: %f, \nОбщая стоимость: %d \n", box.getWeight(), box.getCost());
        box.printInfo();
    }
}

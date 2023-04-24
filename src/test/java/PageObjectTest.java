import pageObject.pages.MenuPage;
import org.junit.Test;

public class PageObjectTest extends BaseTest {

    @Test
    public void test(){

        new MenuPage()
                .chooseRestaurant("Новослободская")
                .selectDish("Шефбургер Де Люкс Оригинальный")
                .addDishToCart("Шефбургер Де Люкс Оригинальный")
                .goToMenu()
                .selectDish("Лонгер")
                .addDishToCart("Лонгер")
                .goToCart()
                .checkTitle()
                .existProductWithName("Шефбургер Де Люкс Оригинальный")
                .existProductWithName("Лонгер")
                .checkAmount();
    }
}

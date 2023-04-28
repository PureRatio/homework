import io.qameta.allure.junit4.DisplayName;
import pageObject.pages.MenuPage;
import org.junit.Test;

public class PageObjectTest extends BaseTest {

    MenuPage menuPage = new MenuPage();

    @DisplayName("Добавление блюда в корзину")
    @Test
    public void test() {

        menuPage.chooseRestaurant("Новослободская")
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

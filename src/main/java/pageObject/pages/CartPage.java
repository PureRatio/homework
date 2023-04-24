package pageObject.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{
    @FindBy(xpath = "//*[text()='Ваш заказ']")
    WebElement title;

    @FindBy(xpath = "//div/a[contains(@href,'product')]")
    List<WebElement> products;

    @FindBy(xpath = "//*[text()='Итого к оплате']/../..//span[@class][1]")
    WebElement totalAmount;

    public CartPage checkTitle() {
        try {
            Assert.assertTrue("Ваш заказ",
                    title.isDisplayed());
        } catch (NoSuchElementException e) {
            Assert.fail("Отсутсвует заголвок - Ваш заказ");
        }
        return this;
    }

    public CartPage existProductWithName(String name){
        for (WebElement element : products){
            if (element.getText().contains(name)){
                return this;
            }
        }
        Assert.fail("Отсутсвует продукт с наименованием: " + name);
        return this;
    }


    public CartPage checkAmount(){
        int expectedCommonAmount = 0;
        int actualCommonAmount = Integer.parseInt(totalAmount.getText());
        for (Integer amount : cart.values()){
            expectedCommonAmount += amount;
        }
        Assert.assertTrue(String.format("Итоговое значение [%s] не равно ожидаемому значению [%s]", actualCommonAmount, expectedCommonAmount),
                actualCommonAmount == expectedCommonAmount);
        return this;
    }
}

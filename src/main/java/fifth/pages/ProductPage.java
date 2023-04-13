package fifth.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BasePage{
    @FindBy(xpath = "//h1[text()]")
    WebElement title;

    @FindBy(xpath = "//button[contains(text(),'В корзину')]")
    WebElement addDishBtn;

    @FindBy(xpath = "//a[text()='Меню']")
    WebElement menuBtn;

    @FindBy(xpath = "//a[@href='/checkout']//span")
    WebElement goToCartBtn;

    public ProductPage addDishToCart(String name) {
        WebDriver driver = WebDriverManager.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(d -> ExpectedConditions.textToBePresentInElement(title, name));
        wait.until(d -> ExpectedConditions.elementToBeClickable(addDishBtn));
        wait.ignoring(WebDriverException.class).until(d -> {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()",addDishBtn);
            return true;
        });
        return new ProductPage();
    }

    public MenuPage goToMenu(){
        menuBtn.click();
        return new MenuPage();
    }

    public CartPage goToCart(){
        goToCartBtn.click();
        return new CartPage();
    }
}

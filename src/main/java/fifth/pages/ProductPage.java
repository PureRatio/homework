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

    @FindBy(xpath = "//button[text()]")
    WebElement addDishText;

    @FindBy(xpath = "//button[contains(text(),'В корзину')]")
    WebElement addDishBtn;

    @FindBy(xpath = "//a[text()='Меню']")
    WebElement menuBtn;

    @FindBy(xpath = "//a[@href='/checkout']//span")
    WebElement goToCartBtn;

    public ProductPage addDishToCart(String name){
        WebDriver driver = WebDriverManager.getDriver();
        new WebDriverWait(driver, 10)
                .until(d -> ExpectedConditions.textToBePresentInElement(title, name));
        new WebDriverWait(driver, 10)
                .until(d -> ExpectedConditions.textToBePresentInElement(addDishText, "В корзину"));
        addDishBtn.click();
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

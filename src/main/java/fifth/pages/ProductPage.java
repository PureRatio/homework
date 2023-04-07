package fifth.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.Keys.ENTER;

public class ProductPage {
    @FindBy(xpath = "//h1[text()]")
    WebElement title;

    @FindBy(xpath = "//button[contains(text(),'В корзину')]")
    WebElement addDishBtn;

    @FindBy(xpath = "//a[text()='Меню']")
    WebElement menuBtn;

    @FindBy(xpath = "//a[@href='/checkout']//span")
    WebElement goToCartBtn;

    public ProductPage addDishToCart(String name){
        WebDriver driver = WebDriverManager.getDriver();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(title, name));

        new WebDriverWait(driver, 10)
                .ignoring(WebDriverException.class)
                .until(d -> {
                    ((JavascriptExecutor) d).executeScript("arguments[0].click()", addDishBtn);
                    //  addToCart.click();
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

package fifth.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class MenuPage extends BasePage {
    @FindBy(xpath = "//a[@href]//div[text()]/..")
    List<WebElement> products;

    @FindBy(xpath = "//button[text()='Соглашаюсь']")
    WebElement confirmCookiesBtn;

    @FindBy(xpath = "//*[text()='Выбрать способ получения']")
    WebElement deliveryType;

    @FindBy(xpath = "//button//*[contains(text(),'ресторане')]")
    WebElement inARestaurant;

    @FindBy(xpath = "//*[contains(@placeholder,'Поиск')]")
    WebElement inputRestaurant;

    @FindBy(xpath = "//button[contains(text(),'Выбрать этот ресторан')]")
    WebElement confirmationOfTheRestaurant;

    @FindBy(xpath = "//*[text()='Шефбургер Де Люкс Оригинальный']")
    WebElement chefburgerDeLuxeOrig;

    @FindBy(xpath = "//div[@id='main1002650']/descendant::div[text()='Бургер Чили Чиз']")
    WebElement chiliBurger;

    public MenuPage confirmCookie(){
        confirmCookiesBtn.click();
        return this;
    }

    public MenuPage chooseRestaurant(String value){
        WebDriver driver = WebDriverManager.getDriver();
        deliveryType.click();
        inARestaurant.click();
        inputRestaurant.sendKeys(value);
        inputRestaurant.sendKeys(ENTER);
        new WebDriverWait(driver, 10)
                .ignoring(WebDriverException.class)
                .until(d -> {
                    ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(false)",
                            confirmationOfTheRestaurant);
                    confirmationOfTheRestaurant.click();
                    return true;
                });
        return this;
    }

    public ProductPage selectDish(String name){
        WebDriver driver = WebDriverManager.getDriver();
        for (WebElement element : products){
            if (element.getText().contains(name)){
                saveDish(element, name);
                new WebDriverWait(driver, 10)
                        .ignoring(WebDriverException.class)
                        .until(d -> {
                            ((JavascriptExecutor) d).executeScript("arguments[0].scrollIntoView(false)",
                                    element.findElement(By.xpath(".//*[text()='" + name + "']/..//button")));
                            element.findElement(By.xpath(".//*[text()='" + name + "']/..")).click();
                            return true;
                        });
                break;
            }
        }
        return new ProductPage();
    }

    private void saveDish(WebElement element, String name){
        Integer price = Integer.valueOf(element.findElement(By.xpath("./..//span[1]")).getText());
        if (cart.containsKey(name)) {
            cart.put(name, cart.get(name) + price);
        } else {
            cart.put(name, price);
        }
    }
}

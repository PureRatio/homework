package fifth.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MenuPage extends BasePage {
    @FindBy(xpath = "//a[@href]//div[text()]/..")
    List<WebElement> products;

    @FindBy(xpath = "//span[text()]")
    WebElement foundOption;

    @FindBy(xpath = "//*[text()='Выбрать способ получения']")
    WebElement deliveryType;

    @FindBy(xpath = "//button//*[contains(text(),'ресторане')]")
    WebElement inARestaurant;

    @FindBy(xpath = "//*[contains(@placeholder,'Поиск')]")
    WebElement inputRestaurant;

    @FindBy(xpath = "//button[contains(text(),'Выбрать этот ресторан')]")
    WebElement confirmationOfTheRestaurant;

    public MenuPage chooseRestaurant(String value){
        WebDriver driver = WebDriverManager.getDriver();
        deliveryType.click();
        inARestaurant.click();
        inputRestaurant.sendKeys(value);
        new WebDriverWait(driver, 15)
                .until(d -> {
                    ExpectedConditions.textToBePresentInElement(foundOption, value);
                    driver.findElement(By.xpath(".//h1[contains(text(), 'Карта')]/..//span[text()='" + value + "']/..")).click();
                    return true;
                });

        new WebDriverWait(driver, 15)
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
        Integer price = Integer.valueOf(element.findElement(By.xpath(".//following-sibling::div[@itemtype]/span[1]")).getText());
        if (cart.containsKey(name)) {
            cart.put(name, cart.get(name) + price);
        } else {
            cart.put(name, price);
        }
    }
}

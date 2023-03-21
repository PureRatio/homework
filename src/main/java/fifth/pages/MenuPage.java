package fifth.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {
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

    @FindBy(xpath = "//a[@href='/checkout']//span")
    WebElement totalAmount;

    WebDriver driver;
    
    public MenuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void chooseRestaurant(String value){
        deliveryType.click();
        inARestaurant.click();
        inputRestaurant.sendKeys(value);
        confirmationOfTheRestaurant.click();
    }

}

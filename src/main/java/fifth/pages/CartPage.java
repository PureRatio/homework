package fifth.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage {
    @FindBy(xpath = "//span[text()='Итого к оплате']/../following-sibling::div//span")
    WebElement totalAmount;
}

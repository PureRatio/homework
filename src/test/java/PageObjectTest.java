import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class PageObjectTest {

    WebDriver driver;

    @Test
    public void test(){
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.kfc.ru/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//button[text()='Соглашаюсь']")).click();

        new WebDriverWait(driver, 10)
                .ignoring(WebDriverException.class)
                    .until(d -> {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false)", driver.findElement(By.xpath("//*[text()='Шефбургер Де Люкс Оригинальный']/..")));
                        driver.findElement(By.xpath("//*[text()='Шефбургер Де Люкс Оригинальный']/..")).click();
                        return true;
                    });

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Шефбургер Де Люкс Оригинальный']")));
        Assert.assertTrue("Кнопка 'В корзину' не активна",
                driver.findElement(By.xpath("//button[contains(text(),'В корзину')]")).isEnabled());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}

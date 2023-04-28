package report;

import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;
import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageObject.pages.WebDriverManager;

public class AllureReport extends AllureJunit4 {

    @Override
    public void testFailure(final Failure failure){
        saveScreenshot();
        super.testFailure(failure);
    }

    @Attachment(value = "Скриншот при ошибке", type = "image/png")
    public byte[] saveScreenshot(){
        return ((TakesScreenshot)WebDriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

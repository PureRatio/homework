package fifth.pages;

import fifth.pages.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class BasePage {

    HashMap<String, Integer> cart = new HashMap<>();

    public BasePage(){
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}
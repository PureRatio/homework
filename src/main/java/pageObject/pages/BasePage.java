package pageObject.pages;

import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;

public class BasePage {

    static HashMap<String, Integer> cart = new HashMap<>();

    public BasePage(){
        PageFactory.initElements(WebDriverManager.getDriver(), this);
    }

}
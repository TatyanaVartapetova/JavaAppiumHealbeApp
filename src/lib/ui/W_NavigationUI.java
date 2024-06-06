package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class W_NavigationUI extends MainPageObject{
    private static final String
    NAVIGATE_NEXT_BUTTON = "//android.widget.Button";

    public W_NavigationUI(AppiumDriver driver){
        super(driver);
    }
    public void navigationNext(){
        this.waitForElementAndClick(By.xpath(NAVIGATE_NEXT_BUTTON), "cannot find Navigate next button", 10);
    }

}


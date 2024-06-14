package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EnterPage extends MainPageObject {
    public EnterPage(AppiumDriver driver) {
        super(driver);
    }

    public static final By
            SIGN_IN_BUTTON = By.id("com.healbe.healbegobe.debug:id/sign_in"),
            SIGN_UP_BUTTON = By.id("com.healbe.healbegobe.debug:id/button");

    public void clickSignInFromEnterForm(){
        waitForElementAndClick(SIGN_IN_BUTTON, "Cannot find sign in button on Enter Form");
    }
    public void clickSignUpFromEnterForm(){
        waitForElementAndClick(SIGN_UP_BUTTON, "Cannot find sign in button on Enter Form");
    }

}
